@app
Feature: Interview project testing

  @Scenario1 
  Scenario: Assignment1 Highlight and Get text dynmically
  Given launch webdriver
  Then Navigate to ReactJS site
  Then Click on Docs tab
  Then Expand main Concepts Tab
  Then Expand Advanced Guides Tab
  
  @Scenario2
  Scenario: Assignment2 Scroll, Bold and Blue line verification
  Given launch webdriver
  Then Navigate to ReactJS site
  Then Click on Tutorial tab
  Then Verify scroll text bold and blue line
  
  @Scenario3
  Scenario: Assignment3 API verification
  Given Make a get call
  Then Count the categories
  Then Get names of Food and Geo locations