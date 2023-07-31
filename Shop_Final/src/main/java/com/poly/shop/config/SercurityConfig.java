package com.poly.shop.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SercurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("user")
                .password(passwordEncoder.encode("123456"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(passwordEncoder.encode("123456"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
////        http.csrf().disable().
////                authorizeHttpRequests().requestMatchers(HttpMethod.GET,"/").permitAll()
////                .requestMatchers(HttpMethod.GET.POST.PUT.DELETE,"/admin/**").hasAuthority("ADMIN")
////                .anyRequest().authenticated()
////                .and().formLogin().loginPage("/login").permitAll()
////                .defaultSuccessUrl("/home")
////                .failureUrl("/login/error")
////                .loginProcessingUrl("/dang-nhap")
////                .and()
////                .logout().logoutUrl("/logout").permitAll()
////                .logoutSuccessUrl("/login")
////                .invalidateHttpSession(true)
////                .deleteCookies("JSESSIONID")
////        ;
////        return http.build();
//    }


}
