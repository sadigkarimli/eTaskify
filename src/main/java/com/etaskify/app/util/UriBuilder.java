package com.etaskify.app.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class UriBuilder {

    public static URI build(String path) {
        return URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path(path)
                        .toUriString()
        );
    }

    public static URI buildAndExpand(String path, Object... uriVariableValues) {
        return URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath().path(path)
                        .buildAndExpand()
                        .toUriString()
        );
    }
}
