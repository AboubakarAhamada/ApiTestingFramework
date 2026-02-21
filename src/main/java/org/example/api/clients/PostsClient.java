package org.example.api.clients;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.api.dto.Post;

import static io.restassured.RestAssured.*;


// Client class that encapsulates ALL HTTP calls related to "posts" resource.
public class PostsClient {
    private final RequestSpecification spec;

    // We inject a RequestSpecification so it stays reusable and testable.
    public PostsClient(RequestSpecification spec){
        this.spec = spec;
    }

    public Response getPosts(){
        return given().spec(spec)
                .when().get("/posts")
                .then().extract().response();
    }

    public Response getPost(int id){
        return given().spec(spec)
                .when().get("/post/{id}", id)
                .then().extract().response();
    }

    public Response createPost(Post body){
        return given().spec(spec)
                .body(body)
                .when().post("/posts")
                .then().extract().response();
    }

    public Response updatePost(int id, Post body){
        return given().spec(spec)
                .body(body)
                .when().patch("/posts/{id}", id)
                .then().extract().response();
    }

    public Response deletePost(int id){
        return given().spec(spec)
                .when().delete("/posts/{id}", id)
                .then().extract().response();
    }
}
