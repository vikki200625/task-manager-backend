package com.taskmanager.task_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }

    /**
     * Configuration to allow the React frontend (running on port 3000)
     * to communicate with the Spring Boot backend (running on port 8080).
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Apply this configuration to all endpoints under /api/
                registry.addMapping("/api/**")
                        // Allow requests coming from the React development server
                        .allowedOrigins("http://localhost:3000")
                        // Allow all standard HTTP methods used for CRUD
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        // Allow headers and credentials
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}