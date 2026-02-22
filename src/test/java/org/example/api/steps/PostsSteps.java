package org.example.api.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.api.clients.PostsClient;
import org.example.api.core.RequestSpecFactory;
import org.example.api.dto.Post;
import org.example.api.support.SharedContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PostsSteps {

    private final PostsClient postsClient;
    private final SharedContext sharedContext;
    public PostsSteps(SharedContext sharedContext){
        this.sharedContext = sharedContext;
        this.postsClient = new PostsClient(RequestSpecFactory.buildRequestSpecification());
    }
    @When("I create a post with title {string} and body {string}")
    public void iCreateAPostWithTitleAndBody(String title, String body) {

    }

    @When("I fetch post with id {int}")
    public void iFetchPostWithId(int id) {
    }

    @When("I fetch all posts")
    public void iFetchAllPosts() {
    }

    @When("I update post {int} with title {string}")
    public void iUpdatePostWithTitle(int id, String title) {

    }

    @When("I delete post {int}")
    public void iDeletePost(int id) {
    }

    @Then("the HTTP status should be {int}")
    public void theHTTPStatusShouldBe(int code) {
        assertThat(sharedContext.lastResponse.statusCode()).isEqualTo(code);
    }

}
