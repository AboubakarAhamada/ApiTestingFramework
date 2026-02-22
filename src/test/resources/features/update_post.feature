Feature: update existing post

  Scenario: User can update post title
    When I update post 1 with title "Updated title"
    Then the HTTP status should be 200
