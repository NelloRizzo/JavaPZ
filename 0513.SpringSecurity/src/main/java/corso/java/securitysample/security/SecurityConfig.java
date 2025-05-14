package corso.java.securitysample.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final UserDetailsService userDetailsService;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http // gestione della security chain
				.csrf(AbstractHttpConfigurer::disable) // disabilita CSRF
				// determina la configurazione delle opzioni CORS (Cross Origin Resource Sharing)
				.cors(c -> c.configurationSource(corsConfigurationSource())) 
				.authorizeHttpRequests( //
						// autorizza l'accesso solo al percorso di autenticazione
						auth -> auth //
								.requestMatchers("/api/auth/**").permitAll() //
								// mentre gli altri path sono protetti e l'utente deve essere autenticato
								.requestMatchers("/api/admin/**").hasAuthority("admin") //
								.requestMatchers("/api/hello/**").permitAll()
								.anyRequest().authenticated()) //
				// la sessione deve essere priva di stato (COOKIE LESS)
				.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider())
				// aggiunge il filtro di autenticazione custom che abbiamo creato
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		var config = new CorsConfiguration();
		// siti autorizzati
		config.setAllowedOrigins(List.of("http://localhost:4200"));
		// metodi autorizzati (GET, POST...) * = tutti
		config.setAllowedMethods(List.of("*"));
		// headers autorizzati (tutti)
		config.setAllowedHeaders(List.of("*"));
		// consente l'invio di credenziali
		config.setAllowCredentials(true);
		var source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationProvider authenticationProvider() {
		var authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
}
