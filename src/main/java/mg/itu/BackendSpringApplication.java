package mg.itu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendSpringApplication {
	public static void main(String[] args) {
		System.out.println("Hello, Spring Boot!");
		SpringApplication.run(BackendSpringApplication.class, args);
	}
}