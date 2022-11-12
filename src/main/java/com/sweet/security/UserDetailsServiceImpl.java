package com.sweet.security;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.core.userdetails.UsernameNotFoundException;
	import org.springframework.stereotype.Service;
	
	import com.sweet.entity.User;
	import com.sweet.repository.IUserDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	 private IUserDAO userDAO;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User usuario = this.userDAO.findByUserName(username);
        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }
}