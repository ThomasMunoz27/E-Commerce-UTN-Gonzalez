package com.ecommerce.ecommerce.Services;

import com.ecommerce.ecommerce.Entities.User;
import com.ecommerce.ecommerce.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> usuarios = usuarioRepository.findByName(username);
        if (usuarios.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + username);
        }
        User usuario = usuarios.get(0);

        return new org.springframework.security.core.userdetails.User(
                usuario.getName(),
                usuario.getPassword(),
                new ArrayList<>() // Aquí podés agregar roles si los tenés
            );
        }
}