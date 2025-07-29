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
    protected static WebDriver driver;

    private static Properties properties;
    private static final String propertyFilePath = "config/configuration.properties";

    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public static void initiateWebDriver(){
        readFile();
        setUpDriver();
    }

    public static WebDriver getWebDriver(){
        return driver;
    }

    public static WebDriver setUpDriver() {
        if (driver == null) driver = createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    private static WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static Properties getProperties() {
        return properties;
    }

    private static  void readFile() {
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
