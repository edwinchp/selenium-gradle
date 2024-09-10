Feature: 001 Access to Google
    Simple navigation to google

@Test @Google
Scenario: Access to Google
    Given I navigate to www.google.com
    When I click Voy a tener suerte
    Then I can see results