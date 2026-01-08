package com.javanauta.bff_agendador_tarefas.infrastructure.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeingConfig {

    @Bean
    public FeingError feingError(){
        return new FeingError();
    }
}
