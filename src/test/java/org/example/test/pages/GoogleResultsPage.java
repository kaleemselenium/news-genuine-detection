package org.example.test.pages;

import org.example.test.utility.NewsMatchPercentage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

import static com.codeborne.selenide.Selenide.$$;
import static org.example.test.utility.Const.THRESHOLD;

/**
 * Google Search Results Page Object
 */
@Component
public class GoogleResultsPage {

    //Page Locators
    By NEWS = By.className("GI74Re");

    @Autowired
    NewsMatchPercentage newsMatchPercentage;

    /**
     * Method  to validate if the news is true or not
     * @param article - News article to verify
     * @return - true is article has 2 or more match sources or else false
     */
    public boolean isNewsGenuine(String article) {
        AtomicInteger validNewsCounter = new AtomicInteger();
        $$(NEWS).forEach(news -> {
            String newsText = news.text();
            int matchPercentage = newsMatchPercentage.matchPercentage(article, newsText);
            if (matchPercentage > THRESHOLD) {
                validNewsCounter.incrementAndGet();
            }
        });
        return validNewsCounter.get() >= 2;
    }
}
