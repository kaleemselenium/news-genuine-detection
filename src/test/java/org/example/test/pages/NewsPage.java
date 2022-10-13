package org.example.test.pages;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

/**
 * News Site Home Page Object
 */
@Component
public class NewsPage {

    //Page locators
    By COOKIE_IFRAME = By.cssSelector("[id^='sp_message_iframe']");
    By ACCEPT_COOKIES = By.cssSelector("[title='Yes, I’m happy']");
    By FIRST_ARTICLE = By.cssSelector("[data-link-name^='news | group-0 | card-@'] .js-headline-text");


    /**
     * Navigate to news site and accept cookies if displayed
     */
    public void navigateToNewsSite(){
        if ($(COOKIE_IFRAME).isDisplayed()) {
            switchTo().frame($(COOKIE_IFRAME));
            $(ACCEPT_COOKIES).shouldBe(visible).click();
            $(ACCEPT_COOKIES).shouldBe(disappear);
        }
    }

    /**
     * Select the first article
     * @return - First article text
     */
    public String getFirstArticleTitle(){
        return $(FIRST_ARTICLE).shouldBe(visible).text();
    }
}
