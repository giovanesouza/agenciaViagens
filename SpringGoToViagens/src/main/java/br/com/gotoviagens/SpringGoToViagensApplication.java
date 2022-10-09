package br.com.gotoviagens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
// O CÓDIGO ABAIXO CORRIGIU O BUG
// "Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured."
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringGoToViagensApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringGoToViagensApplication.class, args);
		
		System.out.println("Aplicação rodando...");
	}

}
