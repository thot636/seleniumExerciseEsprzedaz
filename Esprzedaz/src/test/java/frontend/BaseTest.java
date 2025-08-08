package frontend;

import org.example.ftontend.managers.WebDriverManage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void setUp() {
        WebDriverManage.getInstance().getDriver();
    }

    @AfterClass
    public static void tearDown() {
        WebDriverManage.getInstance().quitDriver();
    }
}

