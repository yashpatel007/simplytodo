package com.simplytodo.configuration;

import com.simplytodo.controller.TodoActuatorEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorConfig {
    @Bean
    public TodoActuatorEndpoint customEndpoint() {
        return new TodoActuatorEndpoint();
    }
}
