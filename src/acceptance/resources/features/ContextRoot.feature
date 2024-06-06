Feature: Context Root of this API
  In order to use the deploy API, it must be available

  Scenario: Root of the API HTTPS
    Given the application is alive
    When I navigate to "https://deploy.project.trevorism.com"
    Then then a link to the help page is displayed

  Scenario: Ping HTTPS
    Given the application is alive
    When I ping the application deployed to "https://deploy.project.trevorism.com"
    Then pong is returned, to indicate the service is alive

