Feature: Create API Pattern

  @type=api
  Scenario: Validate the XML Request
    Given Validate the "XML" request by changing the City "Melbourne" for the Object "City" with the ID "2"
    And Submit the "PublicAPI" request
    Then response is "200"

  @type=api
  Scenario: Validate the JSON Request
    Given Validate the "JSON" request by changing the Product "12323455" for the Object "article/product/sub_product_id"
    And Submit the "JSON" request
    Then response is "202"