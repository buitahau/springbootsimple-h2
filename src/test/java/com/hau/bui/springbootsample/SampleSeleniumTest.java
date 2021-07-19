package com.hau.bui.springbootsample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleSeleniumTest {

    public String baseUrl = "http://www.google.com/";

    public WebDriver driver;

    public String GECKO_DRIVER_LOCAL = "/home/hau-kute/work/github.com/self-learning/geckodriver/geckodriver";

    public String GECKO_DRIVER_JENKINS = "/var/jenkins_home/geckodriver";

    @BeforeTest
    public void setupDriver() {
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_JENKINS);
        driver = new FirefoxDriver();
    }

    @Test
    public void verifyHomePageTitle() {
        driver.get(baseUrl);
        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));
        // Enter something to search for
        element.sendKeys("Cheese!");
        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
