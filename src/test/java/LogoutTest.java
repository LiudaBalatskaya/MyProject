import base.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Created by LiudaBalatskaya on 11/14/2016.
 */
public class LogoutTest extends TestBase {

    private static String USER_NAME1 = "seleniumtests10";
    private static String FULL_USER_NAME1 = "seleniumtests10@gmail.com";
    private static String PASSWORD = "060788avavav";
    public static WebDriver driver;

    @Override
    @BeforeMethod
    public void setup() {
        super.setup();
        driver = WebDriverRunner.getWebDriver();
    }

    @Test
    public static void logoutFromGMail() {
       LoginPage.enterUserName(driver, "user1");
       LoginPage.gotoS(driver);
       LoginPage.goOUT(driver);
    }

    @Test
    public static void logoutFromGMailUser2() {
        LoginPage.enterUserName(driver, "user2");
        LoginPage.gotoS(driver);
        LoginPage.goOUT(driver);
    }

}
