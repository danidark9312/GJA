package com.sf.social.signinmvc.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sf.social.signinmvc.security.dto.SocialUserDetails;
import com.sf.social.signinmvc.user.model.User;
import com.sf.social.signinmvc.user.repository.UserRepository;

/**
 * This class loads the requested user by using a Spring Data JPA repository.
 * @author Petri Kainulainen
 */
public class RepositoryUserDetailsService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryUserDetailsService.class);

    private UserRepository repository;

    @Autowired
    public RepositoryUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }
    
    
    /**
     * Loads the user information.
     * @param username  The username of the requested user.
     * @return  The information of the user.
     * @throws UsernameNotFoundException    Thrown if no user is found with the given username.
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.debug("Loading user by username: {}", username);

        User user = repository.findByEmail(username);
        LOGGER.debug("Found user: {}", user);

        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + username);
        }
        
                UserDetails principal = SocialUserDetails.getBuilder()
                		.nombre(user.getNombre())
                        .id(user.getId())
                        .apellido(user.getApellido())
                        .password(user.getPassword())
                        .role(user.getRole())
                        .socialSignInProvider(user.getSignInProvider())
                        .username(user.getEmail())
                        .activo( user.getActivo())
                        .foto(user.getFoto())
                        .numeroTarjetaProfesional(user.getNumeroTarjetaProfesional())
                        .numeroTelefono(user.getNumeroTelefono())
                        .direccion(user.getDireccion())
                        
                .build();

        LOGGER.debug("Returning user details: {}", principal);

        return principal;
    }
}
