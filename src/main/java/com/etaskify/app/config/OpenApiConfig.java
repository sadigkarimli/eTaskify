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

    private static final String API_TITLE = "eTaskify Rest API";
    private static final String API_VERSION = "v1.0";
    private static final String API_DESCRIPTION =
            "API is for the enterprise task manager platform" +
            "where organizations where companies can manage their daily tasks online.";

    private static final String MAINTAINER_EMAIL = "karimli.sadig@gmail.com";
    private static final String MAINTAINER_NAME = "Sadig Karimli";

    @Bean
    public OpenAPI openApiConfiguration() {
        return new OpenAPI()
                .info(new Info()
                        .title(API_TITLE)
                        .version(API_VERSION)
                        .description(API_DESCRIPTION)
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
