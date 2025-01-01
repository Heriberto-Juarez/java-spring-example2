package com.example.config;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Spring @Configuration annotation is part of the spring core framework.
 * Spring Configuration annotation indicates that the class has @Bean definition methods.
 * So Spring container can process the class and generate Spring Beans to be used in the application.
 */
@Configuration
@ComponentScan(basePackages = "com.example.beans")

public class ProjectConfig {

    @Bean
    public Vehicle vehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Aston Martin");
        return vehicle;
    }

    /**
     * Here in the code below, we are trying to wire or establish a relationship between Person and Vehicle
     * by invoking the vehicle() bean method from person() beam method.
     * Spring will make sure only 1 vehicle bean is created and also vehicle bean will be created first
     * always as person bean has dependency on it.
     */
    @Bean
    public Person person(){
        Person person = new Person();
        person.setName("Lucy");
        person.setVehicle(vehicle()); // This will wire the beans from method calling
        return person;
    }

}