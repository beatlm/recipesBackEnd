package com.thermomix.recipes.security;



import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.thermomix.users.UserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository usuarioRepository;

	public UserDetailsServiceImpl(UserRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.thermomix.users.entity.User usuario = usuarioRepository.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
	}
}