package edu.eci.arsw.api.primesrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.api.primesrepo"})
public class PrimesrepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimesrepoApplication.class, args);
	}
}
