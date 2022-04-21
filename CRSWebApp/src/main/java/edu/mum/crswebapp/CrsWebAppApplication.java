package edu.mum.crswebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CrsWebAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(CrsWebAppApplication.class, args
        );
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/crs/api/v1/customer/").allowedOrigins("http://172.19.140.16:8088");
//            }
//        };
//    }

}
