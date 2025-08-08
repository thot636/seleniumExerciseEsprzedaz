package org.example.ftontend.pageObjects;

import org.example.ftontend.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggedInPageObj extends BasePage {
    WebDriver driver;

    public LoggedInPageObj(WebDriver driver){
        super();
        this.driver = driver;
    }

    public String getConfirmationMsgSuccessfulLogIn(){
        WebElement confirmationElement =
                driver.findElement(By.cssSelector(".l-popup__message-content"));
        String text = confirmationElement.getText();
        return text;
    }

    public LoggedInPageObj clickOnAccountIcon(){
        WebElement accountIcon =
                driver.findElement(By.cssSelector("button[id='header-account']"));
        waitForElementAndClickOnIt(accountIcon);
        return this;
    }

    public LoggedInPageObj clickOnPopUp(){
        WebElement accountIcon =
                driver.findElement(By.xpath("//div[contains(@class,'l-popup__message-close')]"));
        waitForElementAndClickOnIt(accountIcon);
        return this;
    }

    public LoggedInPageObj clickOnLogOut(){
        WebElement accountIcon =
                driver.findElement(By.xpath("//span[contains(.,'Wyloguj')]"));
        waitForElementAndClickOnIt(accountIcon);
        return this;
    }
}
