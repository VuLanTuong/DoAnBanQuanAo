//package com.example.doanbanquanao.configurtion;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class LogoutOnRequestConfiguration {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers("/static/image/**","/", "/homepage", "/signup/**", "/login/**", "/login", "products/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .csrf(AbstractHttpConfigurer::disable)
//                .logout(logout -> logout
//                        .logoutUrl("/logout") // Specify the logout URL
//                        .logoutSuccessUrl("/homepage") // Specify the redirect URL after logout
//                        .invalidateHttpSession(true) // Invalidate the HttpSession
//                        .deleteCookies("JSESSIONID") // Delete any specified cookies
//                );
//        return http.build();
//    }
//
//}
