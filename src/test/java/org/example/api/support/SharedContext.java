package org.example.api.support;

import io.restassured.response.Response;
import lombok.Data;

@Data
public class SharedContext {
    private Response lastResponse;
    private Integer postId;
}
