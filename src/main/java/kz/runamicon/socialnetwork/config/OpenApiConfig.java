package kz.runamicon.socialnetwork.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@OpenAPIDefinition(
//        info = @Info(
//                title = "Runamicon Social Network Documentation",
//                description = "Social Network", version = "0.0.1",
//                contact = {
//                        @Contact(
//                                name = "Kanishev Ilya",
//                                email = "kanishevilya2@gmail.com"
//                        ),
//                        @Contact(
//                                name = "Sapar Sayat",
//                                email = "saparsayat01@gmail.com"
//                        )
//                }
//        )
//)
@Configuration
@EnableSwagger2
public class OpenApiConfig {
    @Bean
    public Docket api() {
        Contact firstContact = new ContactBuilder()
                .name("Имя Первого Контакта")
                .email("первый@почта.ру")
                .build();

        Contact secondContact = new ContactBuilder()
                .name("Имя Второго Контакта")
                .email("второй@почта.ру")
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("Ваш заголовок API")
                        .description("Описание вашего API")
                        .contact(firstContact)
                        .contact(secondContact)
                        .build());
    }

}
