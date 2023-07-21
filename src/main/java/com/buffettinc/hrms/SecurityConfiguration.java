package com.buffettinc.hrms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .authorizeRequests(authorize -> authorize

                                .requestMatchers("/index").permitAll() // Unlocks index page
                                .requestMatchers("/login").permitAll()  // Unlocks login page
                                .requestMatchers("/register").permitAll() // Unlocks register page
                                .requestMatchers("/register_success").permitAll()
                                .requestMatchers("/logout").permitAll()
                                .anyRequest().authenticated() // Locks all other pages, requiring login

                        //.anyRequest().permitAll() // Unlocks all pages, not required login
                )
                .formLogin(formLogin -> formLogin
                        .defaultSuccessUrl("/dashboard", true) // sets default page after successful login
                        .loginProcessingUrl("/register_success")
                        .loginPage("/login")

                )
                .logout( logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/index")
                )
                .httpBasic(Customizer.withDefaults())
                .csrf().disable();
         return http.build();
    }


}
