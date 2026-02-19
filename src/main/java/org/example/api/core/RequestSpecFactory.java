package org.example.api.core;
import org.example.api.config.Env;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {
    public static RequestSpecification buildRequestSpecification(){
        return  new RequestSpecBuilder()
                .setBaseUri(Env.baseUrl())
                .setContentType("application/json")
                .setAccept("application/json")
                .build();
    }
}
