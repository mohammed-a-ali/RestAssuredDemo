Feature: [POST Request] Add a pet
  This allows the user to add a new pet to the store


  Scenario: Add a new pet
    Given The user opens "v2/pet" endPoint
    When The user sends a request using the following data
      | id | name       | status  |
      | 0  | Grumpy Cat | sold    |
    Then The POST method should return 200