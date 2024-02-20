package lt.daujotas.security.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@Profile("!unsecure")
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http

                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/",
                                "/signin/userregistrationform",
                                "/client/**",
                                "/cart/**",
                                "/user/**",
                                "/error/**",
                                "/userregistrationform"

                        )
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
                .formLogin(loginConfig -> loginConfig
                        .permitAll()
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/usergeneralform", true)
                        .usernameParameter("username")
                        .passwordParameter("password")
                )

                .logout(logoutConfig -> logoutConfig
                        .logoutUrl("/logout")
                        .permitAll()
                        .logoutSuccessUrl("/")
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                )
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(

                        PathRequest.toStaticResources().atCommonLocations()
                );
    }

//    @Bean
//    public UserDetailsService inMemoryUserDetailsService() {
//        final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//        final UserDetails adminUser = User.builder()
//                .username("admin")
//                .password(encoder.encode("admin"))     // PasswordencodingFactories =>look for encoding
////                .password("{noop}admin!@#123")     // PasswordencodingFactories =>look for encoding
//                .roles("ADMIN", "USER")
//                .build();
//        System.out.println(encoder.encode("admin"));
//        final UserDetails userUser = User.builder()
//                .username("user")
//                .password("{noop}user!@#123")
//                .roles("USER").build();
//
//        return new InMemoryUserDetailsManager(adminUser, userUser);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}



