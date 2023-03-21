package springmvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfiguration {
 		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.httpBasic();
			http.authorizeHttpRequests().anyRequest().authenticated();
 			http.csrf().disable();
			http.cors();
	        return http.build();
	   }
}
