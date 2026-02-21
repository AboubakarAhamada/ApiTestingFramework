Feature: update existing post

  Scenario: Update an existing post
    When I update post 1 with title "Updated title"
    Then the HTTP status should be 200
