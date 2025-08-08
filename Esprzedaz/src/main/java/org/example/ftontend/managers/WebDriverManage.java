package org.example.ftontend.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class WebDriverManage {
    protected WebDriver driver;

    private Properties properties;
    private final String propertyFilePath = "config/configuration.properties";
    private static final WebDriverManage INSTANCE = new WebDriverManage();

    private final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public static WebDriverManage getInstance() {
        return INSTANCE;
    }

    public WebDriverManage(){
        readFile();
    }

    public void quitDriver() {
            if (driver != null) {
                driver.quit();
            }

    }

    public WebDriver getDriver() {
            if (driver == null) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }
            return driver;
    }

    public Properties getProperties() {
        return properties;
    }

    private  void readFile() {
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
}
