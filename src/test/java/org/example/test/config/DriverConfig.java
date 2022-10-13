package org.example.test.config;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Driver and Cucumber Context Configuration
 */
@TestPropertySource("classpath:application.properties")
@ContextConfiguration(classes = Config.class)
@CucumberContextConfiguration
public class DriverConfig {

    @Value("${base.url}")
    protected String url;

    /**
     * Selenide Driver Configuration
     */
    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.fastSetValue = true;
        Configuration.screenshots = false;
        Configuration.timeout = 10000;
        open(url);
        getWebDriver().manage().window().maximize();
    }
}
