package com.odde.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@CucumberContextConfiguration
@SpringBootTest
public class CucumberConfiguration {
    @Configuration
    @ComponentScan("com.odde.cucumber")
    @EnableAutoConfiguration
    public static class Cucumber {}
}

