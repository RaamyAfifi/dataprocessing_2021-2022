package dataprocessing_2022.raamy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class RaamyApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(RaamyApplication.class, args);
    }
    @Bean
    public Docket swaggerConfiguration()
    {
        //return an prepared docket
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("dataprocessing_2022.raamy"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Anime Rest API",
                "This API is connected to a sql database on localhost. Disclaimer; the data in the database is fake, the datasets did not contain the right information.",
                "v1.0",
                "",
                new Contact("Raamy Afifi", "https://www.linkedin.com/in/raamy-afifi/", "raamy.afifi@student.nhlstenden.com"),
                "No License", "https://github.com/RaamyAfifi/dataprocessing_2021-2022", Collections.emptyList());
    }
}
