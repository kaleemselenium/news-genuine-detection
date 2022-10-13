Feature: Validate the news published is fake

  Scenario: Verify the top news published is true by searching on other sources
    Given user on news home page
    When he selected the first news article
    And searches it on Google
    Then he should see similar news reported from at least 2 others sources

  Scenario: Search the fake news to see if it matches on other sources
    Given user identifies the fake news
    When searches it on Google
    Then he should see no matching results
