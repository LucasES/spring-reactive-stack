package br.com.reactivecrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class ReactiveCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveCrudApplication.class, args);
	}

}
