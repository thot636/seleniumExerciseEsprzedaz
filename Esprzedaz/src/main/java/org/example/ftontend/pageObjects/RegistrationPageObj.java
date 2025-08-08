package org.example.ftontend.pageObjects;

import org.example.ftontend.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;


public class RegistrationPageObj extends BasePage {
//    @FindBy(css =  "input[name='email']")
//    private WebElement emailInputField;

    public String getTitle(){
        return driver.getTitle().toString();
    }

    public RegistrationPageObj openRegistrationPage(){
        driver.get(getUrlLink());
        return this;
    }

    public RegistrationPageObj typeInUniqueEmail(){
        String uniqueEmail = generateUniqueEmail();
        WebElement emailInputField =
                driver.findElement(By.cssSelector("input[name='email']"));
        waitForElementAndClickOnIt(emailInputField);
        emailInputField.sendKeys(uniqueEmail);
        return this;
    }

    public RegistrationPageObj typeInPassword(String password){
        WebElement passwordInputField =
                driver.findElement(By.cssSelector("input[name='password']"));
        waitForElementAndClickOnIt(passwordInputField);
        passwordInputField.sendKeys(password);
        return this;
    }

    public RegistrationPageObj typeInConfirmPassword(String password){
        WebElement passwordConfirmField =
                driver.findElement(By.cssSelector("input[name='password_confirm']"));
        waitForElementAndClickOnIt(passwordConfirmField);
        passwordConfirmField.sendKeys(password);
        return this;
    }

    public RegistrationPageObj selectAcceptTerms(){
        WebElement checkBox =
                driver.findElement(By.cssSelector(".c-checkbox-field__checkmark"));
        waitForElementAndClickOnIt(checkBox);
        return this;
    }

    public LoggedInPageObj clickOnRegisterButton(){
        WebElement regButton =
                driver.findElement(By.cssSelector("button[type='submit']"));
        waitForElementAndClickOnIt(regButton);
        return new LoggedInPageObj(driver);
    }

    private String generateUniqueEmail(){
        return UUID.randomUUID().toString().concat("@testDomain.com");
    }

}
