Feature: Create new post

  Scenario: Create a new post
    When I create a post with title "Hello World" and body "Testing API"
    Then the HTTP status should be 201
