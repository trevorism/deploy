Feature: Context Root of this API
  In order to use the deploy API, it must be available

  Scenario: Root of the API HTTPS
    Given the application is alive
    When I navigate to the application root
    Then then a link to the help page is displayed

  Scenario: Ping HTTPS
    Given the application is alive
    When I ping the application
    Then pong is returned, to indicate the service is alive

  Scenario: Version reports the deployed build
    Given the application is alive
    When I request the version
    Then the version returned is "0-5-0"
