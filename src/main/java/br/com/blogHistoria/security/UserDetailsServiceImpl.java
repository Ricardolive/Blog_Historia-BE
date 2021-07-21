package br.com.blogHistoria.security;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.blogHistoria.model.Usuario;
import br.com.blogHistoria.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<Usuario> user = repository.findByEmail(username);
         user.orElseThrow(() -> new UsernameNotFoundException( username + " not found."));
         
         return user.map(UserDetailsImpl::new).get();
	}

}
