package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Lamborghini Veneno");
        System.out.println("Vehicle name form non-spring context is: " + vehicle.getName());
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle from Spring Context is: " + veh.getName());
    }
}
