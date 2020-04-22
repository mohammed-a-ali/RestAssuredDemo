Feature: [Delete Request] Delete a pet
  This allows the user to delete a pet from the store


  Scenario: Delete an existing pet from the store
    Given The user opens "v2/pet/15935" endPoint
    When The user DELETE pet by id