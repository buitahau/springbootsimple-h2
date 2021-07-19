package com.hau.bui.springbootsample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class SampleSeleniumTest {

    public String baseUrl = "http://www.google.com/";

    public WebDriver driver;

    public String GECKO_DRIVER_LOCAL = "/home/hau-kute/work/github.com/self-learning/geckodriver/geckodriver";

    public String GECKO_DRIVER_JENKINS = "/var/jenkins_home/geckodriver";

    public String FIREFOX_BIN = "/var/jenkins_home/firefox/firefox.sh";

    @BeforeTest
    public void setupDriver() {
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        firefoxOptions.setBinary(FIREFOX_BIN);
        System.setProperty("webdriver.firefox.bin", FIREFOX_BIN);
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_JENKINS);

        File pathBinary = new File(FIREFOX_BIN);
        FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
        DesiredCapabilities desired = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
//        WebDriver driver = new FirefoxDriver(options);

        driver = new FirefoxDriver(options);
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
