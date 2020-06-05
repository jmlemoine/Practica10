package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class Practica10Application {

    public static void main(String[] args) {
        SpringApplication.run(Practica10Application.class, args);
        System.out.println("KLK");
    }

    /*@RequestMapping("/")
    public String sayKlk()
    {
        return "Práctica Hecha Por Roselin Sosa y Jean Lemoine";

    }*/

}
