package com.example.bai2;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise2Test {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fo = new FirefoxOptions();
                fo.addArguments("--headless");
                fo.addArguments("--disable-gpu");
                fo.addArguments("--no-sandbox");
                driver = new FirefoxDriver(fo);
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--headless");
                co.addArguments("--disable-gpu");
                co.addArguments("--no-sandbox");
                driver = new ChromeDriver(co);
                break;
        }
    }

    @Test
    public void openGoogleAndPrintTitle() {
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
