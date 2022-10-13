package org.example.test.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Google Search Page Object
 */
@Component
public class GoogleSearchPage {

    //Page locators
    String ACCEPT_COOKIES = "Accept all";
    String NEWS_TAB = "News";
    By SEARCH_BOX = By.name("q");
    By TOP_NAV = By.id("top_nav");

    /**
     * Navigate to Google search and accept cookies if displayed
     */
    public void navigateToGoogleSearch() {
        open("https://www.google.co.uk/");
        if ($(byText(ACCEPT_COOKIES)).isDisplayed()) {
            $(byText(ACCEPT_COOKIES)).shouldBe(visible).click();
            $(byText(ACCEPT_COOKIES)).should(disappear);
        }
    }

    /**
     * Google searches the article
     * @param article - News article to search
     */
    public void searchArticle(String article){
        $(SEARCH_BOX).val(article).pressEnter();
    }

    /**
     * Switch to the news tab
     */
    public void selectNews(){
        $(TOP_NAV).shouldBe(visible).find(byText(NEWS_TAB)).click();
    }

}
