package com.sweet.security;

	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.GrantedAuthority;
	import org.springframework.security.core.authority.SimpleGrantedAuthority;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.core.userdetails.UsernameNotFoundException;
	import org.springframework.stereotype.Service;
	
	import com.sweet.entity.Rol;
	import com.sweet.entity.User;
	import com.sweet.repository.UserDAO;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User usuario = userDAO.findByUserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con ese username o email: " + username));
		return new org.springframework.security.core.userdetails.User(usuario.getUserName(), usuario.getPassword(), mapRoles(usuario.getUserRol()));
	}
	
	private Collection<? extends GrantedAuthority> mapRoles(Rol rol) {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(rol.getRolName()));
		
		return authorities;
	}
}