package frontend;

import org.example.ftontend.managers.WebDriverManage;
import org.example.ftontend.pageObjects.LoggedInPageObj;
import org.example.ftontend.pageObjects.RegistrationPageObj;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.ftontend.managers.WebDriverManage.getWebDriver;

public class ExampleFrontendTest {

    @BeforeClass
    public void setUp() {
        WebDriverManage.initiateWebDriver();

    }

    @Test
    public void ifNewUserSuccessfullyRegister() {
        String password = "testtest123";
        RegistrationPageObj regPage = new RegistrationPageObj();

        regPage.openRegistrationPage();

        assertThat(regPage.getTitle()).isEqualTo("Rejestracja");

        LoggedInPageObj loggedInPage = regPage.typeInUniqueEmail()
                .typeInPassword(password)
                .typeInConfirmPassword(password)
                .selectAcceptTerms()
                .clickOnRegisterButton();

        assertThat(loggedInPage.getConfirmationMsgSuccessfulLogIn())
                .contains("automatycznie zalogowany na swoje konto.");
        loggedInPage
                .clickOnPopUp()
                .clickOnAccountIcon()
                .clickOnLogOut();
    }

    @AfterTest
    public void tearDown() {
        getWebDriver().quit();
    }
}
