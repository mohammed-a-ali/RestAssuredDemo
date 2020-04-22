Feature: [GET Request] Find Pets By Status
  This allows the user to find all pets in the store with a specified status

  Scenario: Find Pets By Status
    Given  The user opens "v2/pet/findByStatus" endPoint
    When The user sends GET request to get all "available" pets
    Then The status code should be 200
    And The user should see the response body
