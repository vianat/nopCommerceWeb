@web
Feature: wishlist functionality test.
  As a user I want to:
             add a product to the wishlist,
             change the number of products in the list,
             remove products from the list

  @web1
  Scenario Outline: <browser>
    Given I navigate to "https://env-sun.portnov.com/"
    When click Digital downloads
    And add to wishlist second product
    And close header pop-up notification
    And open wishlist
    And check wishlist is not empty
    And change number of product to 10
    And click update wishlist button
    And verify qty of items is 10
    And click remove btn
    Then Check if the message "The wishlist is empty!" appeared

    Examples:
      | browser |
      | firefox |
      | chrome  |
      | edge    |
      | safari  |