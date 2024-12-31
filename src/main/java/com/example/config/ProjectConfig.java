package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Spring @Configuration annotation is part of the spring core framework.
 * Spring Configuration annotation indicates that the class has @Bean definition methods.
 * So Spring container can process the class and generate Spring Beans to be used in the application.
 */
@Configuration
public class ProjectConfig {

    /**
     * Bean annotation, which lets Spring know that it needs to call this method
     * when it initializes its context and adds the returned value to the context.
     */
    @Primary
    @Bean(value="Gallardo")
    Vehicle vehicle() {
        var veh = new Vehicle();
        veh.setName("Lamborghini Gallardo");
        return veh;
    }

    @Bean(value="Aventador")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Lamborghini Aventador");
        return veh;
    }

    @Bean(value="Veneno")
    Vehicle vehicle3(){
        var veh = new Vehicle();
        veh.setName("Lamborghini Veneno");
        return veh;
    }

    /**
     * The method names usually follow verbs notation. But for methods which we will use
     * to create beans, we can use nouns as names
     * This will be a good practice as the method names will become bean names as well in the context.
     */
    @Bean
    String hello(){
        return "Hello world";
    }

    @Bean
    Integer number() {
        return 16;
    }

}