package h1b_extension.h1b_extension_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class H1bExtensionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(H1bExtensionApiApplication.class, args);
	}

}
