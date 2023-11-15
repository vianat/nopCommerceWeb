@web
Feature: TEAM2-1 Add a product
  As an administrator I should be able to add a product to a web-store.

  @web
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    And wait 200
    When Click Login button
    And Enter email "team-sun@noreply.portnov.com"
    And Enter password "ow!<lSy~2H87"
    And Push Enter
    Then Make sure you see Log out button and text: "Welcome to our store"
    And I navigate to "https://env-sun.portnov.com/Admin"
    And wait 200
    And Click Catalog
    And wait 300
    And Click Products
    And wait 200
    And Click Add New
    And Fill in Product Name "Samsung Galaxy S23"
    And Fill in Product Short Description "Snapdragon 8 Gen 2 chipset, 8GB RAM"
    And Clean the textbox and add price 800
    And Clean the shippingtxtbox and add weight 1
    And Choose inventory method
    And Click Save button
    Then Verify the product added message "The new product has been added successfully."

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      #| safari  |