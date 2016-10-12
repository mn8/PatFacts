package example.security;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@PropertySource("classpath:patfacts.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${users.user}")
	String userPassword;

	@Value("${users.admin}")
	String adminPassword;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println(userPassword);
		auth
			.inMemoryAuthentication()
				.withUser("user").password(userPassword).roles("USER").and()
				.withUser("admin").password(adminPassword).roles("USER", "ADMIN");
	}

    @Override
	protected void configure(HttpSecurity http) throws Exception {
    	http.csrf().disable();
		//http.httpBasic();
	}
}