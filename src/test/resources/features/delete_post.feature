Feature: Delete a post

  Scenario: Delete a post
    When I delete post 1
    Then the HTTP status should be 200
