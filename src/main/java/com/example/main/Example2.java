package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.*;
import java.util.Random;
import java.util.function.Supplier;


public class Example2 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);


        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");

        Supplier<Vehicle> volskwagenSupplier = ()-> volkswagen;

        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(10);

        System.out.println("randoNumber=" + randomNumber);

        if (randomNumber %2 == 0){
            context.registerBean("volkswagen", Vehicle.class, volskwagenSupplier);
        }else{
            context.registerBean("audi", Vehicle.class, audiSupplier);
        }

        Vehicle volksVehicle = null;
        Vehicle audiVehicle = null;

        try {
            volksVehicle = context.getBean("volkswagen", Vehicle.class);
        }catch (NoSuchBeanDefinitionException noSuchBeanDefinitionException) {
            System.out.println("Error while creating Volkswagen vehicle");
        }

        try {
            audiVehicle = context.getBean("audi", Vehicle.class);
        }catch(NoSuchBeanDefinitionException noSuchBeanDefinitionException){
            System.out.println("Error while creating Audi vehicle");
        }

        System.out.println("Programming vehicle name from spring Context is: " + (volksVehicle == null ? audiVehicle.getName() : volksVehicle.getName()));

    }

}
