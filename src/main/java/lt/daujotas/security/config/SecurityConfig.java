package lt.daujotas.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final DataSource dataSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/",
                                "/client/**",
                                "/cart/**",
                                "/user/**",
                                "/clientaccountform/**"

                        )
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                )
//                .formLogin(Customizer.withDefaults())
                .formLogin(loginConfig -> loginConfig
                        .permitAll()
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/clientaccountform", true)
                        .usernameParameter("username")
                        .passwordParameter("password")
                )
//                .logout(LogoutConfigurer::permitAll)
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(

                        PathRequest.toStaticResources().atCommonLocations()
                );
    }

    @Bean
    public UserDetailsService inMemoryUserDetailsService() {
        final UserDetails adminUser = User.builder()
                .username("admin")
                .password("{noop}admin!@#123")      // PasswordencodingFactories =>look for encoding
                .roles("ADMN", "USER")
                .build();
        final UserDetails userUser = User.builder()
                .username("user")
                .password("{noop}user!@#123")
                .roles("USER").build();
        return new InMemoryUserDetailsManager(adminUser, userUser);
    }

    @Bean

    public UserDetailsService jdbsUserDetailsService() {
        final JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);

        return users;
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        final DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(jdbsUserDetailsService());
        return authenticationProvider;
    }
}



