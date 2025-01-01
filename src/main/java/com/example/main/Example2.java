package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle primaryVehicle = context.getBean(Vehicle.class);
        System.out.println("Vehicle is: " + primaryVehicle.getName());
        primaryVehicle.printHello();

        context.close();
    }
}
