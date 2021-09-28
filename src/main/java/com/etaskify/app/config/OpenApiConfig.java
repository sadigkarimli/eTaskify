package com.etaskify.app.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class OpenApiConfig {
    private static final String MAINTAINER_EMAIL = "karimli.sadig@gmail.com";
    private static final String MAINTAINER_NAME = "Sadig Karimli";

    @Bean
    public OpenAPI openApiConfiguration(
            @Value("${api.name}") final String title,
            @Value("${api.version}") final String version
    ) {
        return new OpenAPI()
                .info(new Info()
                        .title(title)
                        .version(version)
                        .contact(getContact())
                );
    }

    private Contact getContact() {
        Contact contact = new Contact();
        contact.setEmail(MAINTAINER_EMAIL);
        contact.setName(MAINTAINER_NAME);
        contact.setExtensions(Collections.emptyMap());
        return contact;
    }
}
