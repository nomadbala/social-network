package kz.runamicon.socialnetwork.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Runamicon Social Network Documentation",
                description = "Social Network", version = "0.0.1",
                contact = @Contact(
                        name = "Kanishev Ilya",
                        email = "kanishevilya2@gmail.com"
                )
        )
)
public class OpenApiConfig {
}
