package com.example.ejemplo_uno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EjemploUnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjemploUnoApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")  // Permite todas las rutas
						.allowedOrigins("*")  // Permite cualquier origen
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Métodos permitidos
						.allowedHeaders("*");  // Permite todos los encabezados
			}
		};
	}
}
