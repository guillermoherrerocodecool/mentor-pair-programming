package com.codecool.robodog.configuration;

import com.codecool.robodog.persistence.DogStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Random;

@Configuration
public class BeansConfiguration {
    @Bean
    DogStorage dogStorage() {
        return new DogStorage(new ArrayList<>());
    }

    @Bean
    Random random() {
        return new Random();
    }
}
