Feature: Kay tests

  @type=QEtest
  Scenario: To verify DuckDuckGo
    Given Launch DuckDuckGo Page
    When I search for Revolution IT
    Then Search results is displayed

  @type=QEtest
  Scenario: Validate the XML Request for swapi people 3
    Given Validate the "XML" request by changing the Criteria "people" with value "3"
    And Submit the "PublicAPI" request
    Then response is "200"


  @type=QEtest
  Scenario: Validate the JSON Request for swapi planets 2
    Given Validate the "JSON" request by changing the Criteria "planets" with value "2"
    And Submit the "PublicAPI" request
    Then response is "200"