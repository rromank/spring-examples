package pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import pkg.model.CustomUserDetails;
import pkg.service.UserService;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class Application {

//    @Bean
//    public MethodSecurityExpressionHandler expressionHandler() {
//        return new DefaultMethodSecurityExpressionHandler();
//    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserService userService) throws Exception {
        builder.userDetailsService(s -> new CustomUserDetails(userService.findByName(s)));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}