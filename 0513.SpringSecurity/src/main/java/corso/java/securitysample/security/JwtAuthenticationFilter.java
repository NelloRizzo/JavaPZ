package corso.java.securitysample.security;

import java.io.IOException;

import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final UserDetailsService userDetailsService;
	private final JwtService jwtService;

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain) throws ServletException, IOException {
		// leggo lo header di autorizzazione
		final String authHeader = request.getHeader("Authorization");
		// se esiste e inizia con la stringa 'Bearer '
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			// gestisco l'autenticazione

			// il token segue la stringa 'Bearer ' nello header
			String token = authHeader.substring(7);

			// estrae lo username dal token tramite l'apposito servizio
			String username = jwtService.extractUsername(token); // occorre un servizio per recuperare lo username dal
																	// token
			if (username != null &&
			// classe di sistema che gestisce il contesto di sicurezza
					SecurityContextHolder.getContext().getAuthentication() == null) {
				// recupera l'utente a partire dallo username
				UserDetails u = userDetailsService.loadUserByUsername(username);
				if (jwtService.isTokenValid(token, u)) {
					// creiamo un utente del contesto di sicurezza di Spring
					var authToken = new UsernamePasswordAuthenticationToken( //
							u, null, u.getAuthorities());
					// scrivo l'utente come autenticato nel sistema
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			}
		}
		// passo il controllo al filtro successivo della
		// catena di gestione della request
		filterChain.doFilter(request, response);
	}

}
