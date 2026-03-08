package org.example.api.support;

import io.restassured.response.Response;
import lombok.Data;
import lombok.Getter;

@Data
public class SharedContext {
    private Response lastResponse;
    @Getter
    private final Integer postId = 19; // We suppose that the Post with id = 19 exists. this id will be used to find/update/delete the Post
}
