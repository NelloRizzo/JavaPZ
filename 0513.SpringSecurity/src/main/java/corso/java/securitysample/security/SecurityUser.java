package corso.java.securitysample.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import corso.java.securitysample.entities.UserEntity;

public class SecurityUser implements UserDetails {
	private static final long serialVersionUID = 1L;

	private final UserEntity user;

	public SecurityUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(user.getRole().toString()));
	}
}
