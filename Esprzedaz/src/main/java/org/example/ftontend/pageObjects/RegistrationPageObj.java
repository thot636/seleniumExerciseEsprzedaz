package org.example.ftontend.pageObjects;

import org.example.ftontend.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.UUID;


public class RegistrationPageObj extends TestUtil {

    public RegistrationPageObj(){
        super();
    }
    public String getTitle(){
        return getWebDriver().getTitle().toString();
    }

    public RegistrationPageObj openRegistrationPage(){
        getWebDriver().get(getUrlLink());
        return this;
    }

    public RegistrationPageObj typeInUniqueEmail(){
        String uniqueEmail = generateUniqueEmail();
        WebElement emailInputField =
                getWebDriver().findElement(By.cssSelector("input[name='email']"));
        waitForElementAndClickOnIt(emailInputField);
        emailInputField.sendKeys(uniqueEmail);
        return this;
    }

    public RegistrationPageObj typeInPassword(String password){
        WebElement passwordInputField =
                getWebDriver().findElement(By.cssSelector("input[name='password']"));
        waitForElementAndClickOnIt(passwordInputField);
        passwordInputField.sendKeys(password);
        return this;
    }

    public RegistrationPageObj typeInConfirmPassword(String password){
        WebElement passwordConfirmField =
                getWebDriver().findElement(By.cssSelector("input[name='password_confirm']"));
        waitForElementAndClickOnIt(passwordConfirmField);
        passwordConfirmField.sendKeys(password);
        return this;
    }

    public RegistrationPageObj selectAcceptTerms(){
        WebElement checkBox =
                getWebDriver().findElement(By.cssSelector(".c-checkbox-field__checkmark"));
        waitForElementAndClickOnIt(checkBox);
        return this;
    }

    public LoggedInPageObj clickOnRegisterButton(){
        WebElement regButton =
                getWebDriver().findElement(By.cssSelector("button[type='submit']"));
        waitForElementAndClickOnIt(regButton);
        return new LoggedInPageObj();
    }

    private String generateUniqueEmail(){
        return UUID.randomUUID().toString().concat("@testDomain.com");
    }

}
