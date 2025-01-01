package com.example.main;

import com.example.beans.Vehicle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Example2 {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("beans.xml");

        Vehicle primaryVehicle = context.getBean(Vehicle.class);
        System.out.println("Vehicle is: " + primaryVehicle.getName());
        primaryVehicle.printHello();

        context.close();
    }
}
