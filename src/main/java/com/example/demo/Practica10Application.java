package com.example.demo;

import com.example.demo.property.FileStorageProperties;
import com.example.demo.service.UserDetailsServiceImp;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class Practica10Application {

    public static final String USE_HAZELCAST = "true";

    public static void main(String[] args) {

        System.out.println("KLK");

        ApplicationContext applicationContext = SpringApplication.run(Practica10Application.class, args);



        /*UserDetailsServiceImp userDetailsServiceImp;

        try {
            userDetailsServiceImp = (UserDetailsServiceImp) applicationContext.getBean("userDetailsServiceImp");
            userDetailsServiceImp.createAdmin();
        } catch (BeansException e){
            e.printStackTrace();
        }*/

    }

    @RequestMapping("/")
    public String sayKlk()
    {
        return "Práctica Hecha Por Roselin Sosa y Jean Lemoine";

    }


}
