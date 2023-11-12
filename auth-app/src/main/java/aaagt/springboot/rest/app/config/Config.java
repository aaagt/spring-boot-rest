package aaagt.springboot.rest.app.config;

import aaagt.springboot.rest.app.resolver.UserHandlerMethodArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class Config implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserHandlerMethodArgumentResolver());
    }

    @Bean
    public UserHandlerMethodArgumentResolver userHandlerMethodArgumentResolver() {
        return new UserHandlerMethodArgumentResolver();
    }
}
