package com.qa.main;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.qa.models.ShoppingCart;


@SpringBootApplication
@ComponentScan(basePackages={"com.qa.controllers", "com.qa.services", "com.qa.configs"})
@EntityScan("com.qa.models")
public class CaseStudyApplication{


	public static void main(String[] args) {
		SpringApplication.run(CaseStudyApplication.class, args);
	}
	

}
