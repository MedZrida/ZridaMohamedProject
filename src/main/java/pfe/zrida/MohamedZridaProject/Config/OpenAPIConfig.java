package pfe.zrida.MohamedZridaProject.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class OpenAPIConfig {


    @Value("${server.port}")  // Use Spring Boot's server port
    private String serverPort;

    @Bean
    public OpenAPI myOpenAPI() {
        Contact contact = new Contact();
        contact.setEmail("contact@mohamedzida.tn");
        contact.setName("PFE API's");

        Info info = new Info()
                .title("PFE TEST DES APIs")
                .contact(contact)
                .description("Liste des APIs développés par ZRIDA Mohamed.");

        return new OpenAPI().info(info);

    }
}
