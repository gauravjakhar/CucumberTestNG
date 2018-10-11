Feature: Reset functionality on login page of Application

  Scenario: Authenication
    Given Open Application and Enter url as "https://demo.openmrs.org/openmrs/login.htm"
    When enter username
    And enter password
    Then verify Msg