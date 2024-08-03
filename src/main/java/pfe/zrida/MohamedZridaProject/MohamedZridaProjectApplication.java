package pfe.zrida.MohamedZridaProject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableScheduling
@SpringBootApplication
@OpenAPIDefinition
@EnableConfigurationProperties
@ComponentScan(basePackages = "pfe.zrida")
public class MohamedZridaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MohamedZridaProjectApplication.class, args);
	}

}
