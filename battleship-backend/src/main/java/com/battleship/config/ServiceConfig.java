package com.battleship.config;

import com.battleship.service.BattleFieldService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public BattleFieldService battleFieldService() {
        return new BattleFieldService();
    }
} 