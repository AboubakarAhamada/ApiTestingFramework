Feature: retrieve posts

  Scenario: retrieve a post by id
    When I fetch post with id 1
    Then the HTTP status should be 200

  Scenario: retrieve all posts
    When I fetch all posts
    Then the HTTP status should be 200
