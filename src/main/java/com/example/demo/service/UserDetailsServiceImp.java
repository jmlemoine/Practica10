package com.example.demo.service;

import com.example.demo.entity.AppRole;
import com.example.demo.entity.AppUser;
import com.example.demo.repositories.RolRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.*;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = userRepository.findByUsername(username);

        if (appUser == null){
            System.out.println("No se encontro el usuario: " + username);
            throw new UsernameNotFoundException("El usuario " + username + " no esta en la BD");
        }

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (AppRole role : appUser.getRolSet()){
            roles.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return new org.springframework.security.core.userdetails.User(appUser.getUsername(), appUser.getPassword(), appUser.isEnabled(), true, true, true, grantedAuthorities);

    }

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void createAdmin(){
        if (!findAdmin()){
            AppRole rol = new AppRole("ROLE_ADMIN");
            rolRepository.save(rol);

            AppUser admin = new AppUser();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setEnabled(true);
            admin.setRolSet(new HashSet<>(Arrays.asList(rol)));

            userRepository.save(admin);

        }
    }

    public boolean findAdmin(){
        AppRole rol = rolRepository.findByRoleName("ROLE_ADMIN");
        if (rol == null){
            return false;
        }
        return true;
    }

}
