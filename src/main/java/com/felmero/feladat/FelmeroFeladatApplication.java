package com.felmero.feladat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.felmero.feladat"})
@ComponentScan("com.felmero.feladat") 
@EntityScan("com.felmero.feladat") 
@EnableJpaRepositories("com.felmero.feladat") 
public class FelmeroFeladatApplication {

	public static void main(String[] args) {
		SpringApplication.run(FelmeroFeladatApplication.class, args);
	}

}
