Feature: Create new post

  Scenario Outline: Create a new post
    When I create a post with userId <userId> and title "<title>" and body "<body>"
    Then the HTTP status should be 201

    Examples:
      | userId | title                   | body                |
      | 333    | Body can be empty       |                     |
      | 444    |                         | Title can be empty  |
      | -25    | UserId can be negative  | negative userId     |
      | 999    | Post 999                | Post 999 body       |
