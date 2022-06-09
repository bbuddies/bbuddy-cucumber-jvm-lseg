package com.odde.cucumber.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

@Component
@Scope(value="webDriver", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Ui {

    private final WebDriver driver;

    @Autowired
    public Ui(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.of(5, SECONDS));
    }

    public void input(String id, String text) {
        driver.findElement(By.id(id)).sendKeys(text);
    }

    public void click(String id) {
        driver.findElement(By.id(id)).click();
    }

    public void clickByText(String text) {
        findElementByText(text).click();
    }

    private WebElement findElementByText(String text) {
        return driver.findElement(By.xpath(String.format("//*[ text() = '%s' ]", text)));
    }

    public void open(String url) {
        driver.get(url);
    }

    public void assertHaveText(String text) {
        assertThat(findElementByText(text)).isNotNull();
    }
}
