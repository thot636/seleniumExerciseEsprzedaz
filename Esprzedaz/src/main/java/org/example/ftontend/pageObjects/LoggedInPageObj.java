package org.example.ftontend.pageObjects;

import org.example.ftontend.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoggedInPageObj extends TestUtil {

    public String getConfirmationMsgSuccessfulLogIn(){
        WebElement confirmationElement =
                getWebDriver().findElement(By.cssSelector(".l-popup__message-content"));
        String text = confirmationElement.getText();
        return text;
    }

    public LoggedInPageObj clickOnAccountIcon(){
        WebElement accountIcon =
                getWebDriver().findElement(By.cssSelector("button[id='header-account']"));
        waitForElementAndClickOnIt(accountIcon);
        return this;
    }

    public LoggedInPageObj clickOnPopUp(){
        WebElement accountIcon =
                getWebDriver().findElement(By.xpath("//div[contains(@class,'l-popup__message-close')]"));
        waitForElementAndClickOnIt(accountIcon);
        return this;
    }

    public LoggedInPageObj clickOnLogOut(){
        WebElement accountIcon =
                getWebDriver().findElement(By.xpath("//span[contains(.,'Wyloguj')]"));
        waitForElementAndClickOnIt(accountIcon);
        return this;
    }
}
