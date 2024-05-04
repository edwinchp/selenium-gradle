Feature: File Upload

@Test @FileUpload
  Scenario: Upload a file to a web page
    Given I navigate to "https://demo.guru99.com/test/upload/"
    And I select a file to upload
    And I click on the Submit File button
    Then I should see a success message confirming the file upload
