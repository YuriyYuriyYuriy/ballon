//package com.balloon_spring_jpa.ballon.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsManager manager(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(config ->
//                config
//                        .requestMatchers(HttpMethod.GET, "/api/foil/balloons").hasRole("CUSTOMER")
//                        .requestMatchers(HttpMethod.GET, "/api/latex/balloons").hasRole("CUSTOMER")
//                        .requestMatchers(HttpMethod.GET, "/api/orders/**").hasRole("CUSTOMER")
//                        .requestMatchers(HttpMethod.PUT, "/api/orders/**").hasRole("CUSTOMER")
//
//                        .requestMatchers(HttpMethod.GET, "/api/**").hasRole("ADMIN")   // dont
//                        .requestMatchers(HttpMethod.GET, "/api/foil/balloons").hasRole("ADMIN")    // dont
//                        .requestMatchers(HttpMethod.GET, "/api/foil/balloons/**").hasRole("ADMIN") // dont
//                        .requestMatchers(HttpMethod.GET, "/api/latex/balloons/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/customers").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/customers/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/customers/orders").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/orders/**").hasRole("ADMIN")
//
//                        .requestMatchers(HttpMethod.PUT, "/api/latex/balloons/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.PUT, "/api/foil/balloons/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.PUT, "/api/customers/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.PUT, "/api/orders/**").hasRole("ADMIN")
//
//                        .requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/api/foil/balloons").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/api/customers").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST, "/api/orders").hasRole("ADMIN")
//
//                        .requestMatchers(HttpMethod.DELETE, "/api/latex/balloons/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.DELETE, "/api/foil/balloons/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.DELETE, "/api/customers/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.DELETE, "/api/orders/**").hasRole("ADMIN")
//        );
//
//        http.httpBasic(Customizer.withDefaults());
//        http.csrf(csrf -> csrf.disable());
//
//        return http.build();
//    }
//}
