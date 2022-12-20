package com.groupe3.fakeslack.security;

import com.groupe3.fakeslack.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        // Authentication is set here

        // This is to test with a hard-coded user
/*
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password"))
                .roles("ADMIN");
*/

        // This authenticates a user from database
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "SELECT username, password, enabled FROM users WHERE username = ?"
                )
                .authoritiesByUsernameQuery("SELECT username, role FROM users WHERE username = ?");


    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // This is where Authorizations are set up

        // Everything is allowed
        /*
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
         */

        // Some urls are allowed, depending on user role
        http
                .csrf().disable()// Allow request from outer application
                .authorizeRequests()
                .antMatchers("/user/**")
                .hasRole("ADMIN")

                .and()

                .httpBasic()

                .and()
                // Logout set up - has to clean everything
                .logout(logout -> logout.logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID"));

        return http.build();
    }

}

