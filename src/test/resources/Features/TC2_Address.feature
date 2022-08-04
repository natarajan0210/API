@Address
Feature: Address Module API Automation

  Scenario Outline: Verify add new address to the application through api
    Given User add headers and bearer authorizaton for accessing new address endpoints
    When User add request body for add new address "<first_name>", "<last_name>", "<mobile>", "<apartment>", "<state>", "<city>", "<country>", "<zipcode>", "<address>" and "<address_type>"
    When User send "POST" request for add new address
    Then User should verify the status code is 200
    And User should verify the add new address response message matches "Address added successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      | Bala       | N         | 6374803139 | Black     |    44 |   45 |     100 |  621001 | OMR     | Chennai      |

  Scenario Outline: Verify update existing address to the application through api
    Given User add headers and bearer authorizaton for accessing update address endpoints
    When User add request body for update existing address "<address_id>", "<first_name>", "<last_name>", "<mobile>", "<apartment>", "<state>", "<city>", "<country>", "<zipcode>", "<address>" and "<address_type>"
    When User send "PUT" request for update existing address
    Then User should verify the status code is 200
    And User should verify the update existing address response message matches "Address updated successfully"

    Examples: 
      | address_id | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      |      11619 | Natarajan  | N         | 6374803139 | Black     |    44 |   45 |     100 |  621001 | OMR     | Chennai      |

  Scenario Outline: Verify delete existing address to the application through api
    Given User add headers and bearer authorizaton for accessing delete address endpoints
    When User add request body for delete existing address "<address_id>"
    When User send "DELETE" request for delete existing address
    Then User should verify the status code is 200
    And User should verify the delete existing address response message matches "Address deleted successfully"

    Examples: 
      | address_id |
      |      11619 |

  Scenario: Verify get the existing address to the application through api
    Given User add headers and bearer authorizaton for accessing get address endpoints
    When User send "GET" request for get existing address
    Then User should verify the status code is 200
    And User should verify the get existing address response message matches "OK"
