Feature: retrieve posts

  @needsExistingPost
  Scenario: Retrieve a prepared post by id
    When I fetch the prepared post with known id
    Then the HTTP status should be 200

  Scenario: retrieve all posts
    When I fetch all posts
    Then the HTTP status should be 200
