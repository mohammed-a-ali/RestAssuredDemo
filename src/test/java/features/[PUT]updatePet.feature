Feature: [PUT Request] Add a pet
  This allows the user to update an existing pet in the store


  Scenario: Update an existing pet
    Given The user opens "v2/pet" endPoint
    When The user sends PUT request using the following data
      | id    | name       | status    |
      | 15935 | Grumpy Cat | available |
    Then The PUT method should return 200