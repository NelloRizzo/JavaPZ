package corso.java.securitysample.security;

import java.util.Date;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	// Chiave per la crittografia del token
	private static final String SECRET_KEY = "qh0PUaZkOaFThBsnkXpdqM2w3YDzGHYcbQyOjGq5vBQ=";
	// Scadenza del token in ms
	private static final long EXPIRATION_TIME = 864_000_000; // 10 giorni

	// legge lo username dal token
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	// applica una funzione che estrae una singola claim tra quelle
	// contenute nel token
	public <T> T extractClaim(String token, Function<Claims, T> resolver) {
		final Claims claims = extractAllClaims(token);
		return resolver.apply(claims);
	}

	public boolean isTokenExpired(String token) {
		return extractClaim(token, Claims::getExpiration).before(new Date());
	}

	public boolean isTokenValid(String token, UserDetails u) {
		final String username = extractUsername(token);
		return username.equals(u.getUsername()) && !isTokenExpired(token);
	}

	// ottiene la chiave di crittografia
	private SecretKey getSigningKey() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
	}

	// recupera le claims dal token
	private Claims extractAllClaims(String token) {
		return Jwts //
				.parser() //
				.verifyWith(getSigningKey()) //
				.build() //
				.parseSignedClaims(token) //
				.getPayload();

	}

	// genera il token
	public String generateToken(Map<String, Object> extaClaims, UserDetails u) {
		return Jwts //
				.builder() //
				.claims().empty().add(extaClaims).and() //
				.subject(u.getUsername()) //
				.issuedAt(new Date(System.currentTimeMillis())) //
				.expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) //
				.signWith(getSigningKey()) //
				.compact();
	}
}
