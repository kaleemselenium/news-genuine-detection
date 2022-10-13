package org.example.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * Test Runner Class
 */
@CucumberOptions(features = {"classpath:features"},
        glue = {"org.example.test.stepdefs", "org.example.test.config"},
        plugin = {"json:target/cucumber-report/cucumber.json","html:target/cucumber-report/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
