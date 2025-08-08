package org.example.ftontend;

import org.example.ftontend.managers.WebDriverManage;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class BasePage extends WebDriverManage {
    private static Properties properties;
    private final String propertyFilePath = "config/configuration.properties";
    private String urlLink;
    protected final WebDriver driver = WebDriverManage.getInstance().getDriver();

    private List<Class<? extends WebDriverException>> ignoredWebDriverExceptions = Arrays.asList(NoSuchElementException.class, ElementClickInterceptedException.class,
            StaleElementReferenceException.class, ElementNotInteractableException.class);

    public BasePage() {
        readFile();
        chooseEnv();
    }

    @BeforeClass
    public void setUp() {
        WebDriverManage.getInstance().getDriver();
    }

    public String getUrlLink() {
        return urlLink;
    }

    private void chooseEnv() {
        Properties prop = getProperties();
        String env = prop.getProperty("environment");

        switch (env) {
            case "dev":
                urlLink = prop.getProperty("urlDev");
                break;

            case "prod":
                urlLink = prop.getProperty("urlProd");
                break;
        }
    }

    public void waitForElementAndClickOnIt(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public WebElement waitForElementToBeVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }


    private void readFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public Properties  getProperties() {
        return properties;
    }
}
