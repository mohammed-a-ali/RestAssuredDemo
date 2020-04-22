Feature: Find Pets By Status

  Scenario: findPetsByStatus
    Given  The user opens "v2/pet/findByStatus" endPoint
    When The user sends GET request to get all "available" pets
    Then The status code should be 200
    And The user should see the response body
