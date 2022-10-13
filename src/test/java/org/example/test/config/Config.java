package org.example.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Configuration
 */
@Configuration
@ComponentScan({"org.example.test", "com.codeborne.selenide"})
public class Config {
}
