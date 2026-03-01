Feature: update existing post

  @needsExistingPost
  Scenario: User can update post title
    When I update post with title "Updated title"
    Then the HTTP status should be 200
