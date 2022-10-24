package br.com.gotoviagens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringGoToViagensApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGoToViagensApplication.class, args);
		
		System.out.println("Aplicação rodando...");
		
	}

}
