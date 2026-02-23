Feature: Lead creation

  @TC01
  Scenario: User creates a lead
    Given User logs in to the application
    And user clicks CRM link in home page
    When User starts to create a new lead
    And User enters the customer information of the lead
    And User enters the basic information of the lead
    And User uploads the kyc documents in documents tab
    And User imports the census file in census lines tab
    And User starts the quotation process
    And user proceeds to the direct payment
    And user proceeds the Issue Policy