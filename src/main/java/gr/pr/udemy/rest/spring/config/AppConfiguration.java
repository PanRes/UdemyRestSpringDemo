package gr.pr.udemy.rest.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("gr.pr.udemy.rest.spring")
public class AppConfiguration {

}
