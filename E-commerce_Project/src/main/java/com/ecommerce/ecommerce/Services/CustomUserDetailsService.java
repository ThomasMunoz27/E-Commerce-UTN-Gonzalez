package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.User;
import com.ecommerce.ecommerce.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUsuario = usuarioRepository.findByUsername(username);

        User usuario = optionalUsuario.orElseThrow(() ->
                new UsernameNotFoundException("Usuario no encontrado: " + username)
        );

        return new org.springframework.security.core.userdetails.User(
                usuario.getUsername(),
                usuario.getPassword(),
                Collections.emptyList() // O roles si los tenés implementados
        );
    }
}
