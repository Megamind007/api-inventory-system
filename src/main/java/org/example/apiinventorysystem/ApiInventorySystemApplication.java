package org.example.apiinventorysystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.Servers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Inventory System Api"
		),
		servers = @Server(url = "/")
)
public class ApiInventorySystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiInventorySystemApplication.class, args);
	}
}
