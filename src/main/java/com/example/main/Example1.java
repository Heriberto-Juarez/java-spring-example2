package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle aventador = context.getBean("Aventador",Vehicle.class);
        System.out.println("Vehicle from Spring Context is: " + aventador.getName());

        Vehicle primaryVehicle = context.getBean(Vehicle.class);
        System.out.println("Vehicle from Spring Context is: " + primaryVehicle.getName());

    }
}
