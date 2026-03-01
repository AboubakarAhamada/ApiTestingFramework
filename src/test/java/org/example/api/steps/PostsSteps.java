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
        Post post = new Post();
        post.setUserId(333);
        post.setTitle(title);
        post.setBody(body);

        sharedContext.setLastResponse(postsClient.createPost(post));
        System.out.println(sharedContext.getLastResponse().body().asString());

    }

    @When("I fetch the prepared post with known id")
    public void iFetchThePreparedPostWithKnownId() {
        if (sharedContext.getPostId() == null) {
            // Message clair pour diagnostiquer rapidement si le hook/Given n'a pas tourné
            throw new IllegalStateException(
                    "postId is null. Ensure the scenario sets it (e.g., tag @needsPost or Given I use post id <n>).");
        }
        sharedContext.setLastResponse(postsClient.getPost(sharedContext.getPostId()));
        System.out.println(sharedContext.getLastResponse().body().asString());
    }


    @When("I fetch all posts")
    public void iFetchAllPosts() {
        sharedContext.setLastResponse(postsClient.getPosts());
        //System.out.println(sharedContext.getLastResponse().body().asString());

    }

    @When("I update post with title {string}")
    public void iUpdatePostWithTitle(String title) {
        Post post = new Post();
        post.setTitle(title);

        sharedContext.setLastResponse(postsClient.updatePost(sharedContext.getPostId(),post));
        System.out.println(sharedContext.getLastResponse().body().asString());


    }

    @When("I delete existing post")
    public void iDeleteExistingPost() {
        sharedContext.setLastResponse(postsClient.deletePost(sharedContext.getPostId()));
        System.out.println(sharedContext.getLastResponse().body().asString());

    }

    @Then("the HTTP status should be {int}")
    public void theHTTPStatusShouldBe(int code) {
        assertThat(sharedContext.getLastResponse().statusCode()).isEqualTo(code);
    }

}
