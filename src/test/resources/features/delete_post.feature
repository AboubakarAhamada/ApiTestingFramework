Feature: Delete a post

  @needsExistingPost
  Scenario: Delete a post
    When I delete existing post
    Then the HTTP status should be 200
