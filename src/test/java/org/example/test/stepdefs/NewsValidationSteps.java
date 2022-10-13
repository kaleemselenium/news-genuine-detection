package org.example.test.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.test.pages.GoogleResultsPage;
import org.example.test.pages.GoogleSearchPage;
import org.example.test.pages.NewsPage;
import org.example.test.utility.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

/**
 * Step Definitions Class
 */
public class NewsValidationSteps {

    @Autowired
    NewsPage newsPage;

    @Autowired
    GoogleSearchPage googleSearchPage;

    @Autowired
    GoogleResultsPage googleResultsPage;

    String firstArticle;

    @Given("user on news home page")
    public void newsPage() {
        newsPage.navigateToNewsSite();
    }

    @When("he selected the first news article")
    public void selectFirstArticle() {
        firstArticle = newsPage.getFirstArticleTitle();
    }

    @And("searches it on Google")
    public void search() {
        googleSearchPage.navigateToGoogleSearch();
        googleSearchPage.searchArticle(firstArticle);
        googleSearchPage.selectNews();
    }

    @Then("he should see similar news reported from at least 2 others sources")
    public void matchResults() {
        Assert.assertTrue(googleResultsPage.isNewsGenuine(firstArticle),
                "Article doesn't have least 2 matched other sources");
    }

    @Given("user identifies the fake news")
    public void fakeNews() {
        firstArticle = Const.FAKE_NEWS;
    }

    @Then("he should see no matching results")
    public void noMatchResults() {
        Assert.assertFalse(googleResultsPage.isNewsGenuine(firstArticle));
    }
}
