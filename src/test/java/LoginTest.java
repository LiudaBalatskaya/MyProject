import base.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Created by student on 2/4/2015.
 */

public class LoginTest extends TestBase {

    private static String FULL_USER1 = "seleniumtests10@gmail.com";
    private static String FULL_USER2 = "seleniumtests10@gmail.com";
    private static String FULL_USER3 = "seleniumtests10@gmail.com";
    public static WebDriver driver;

    @Override
    @BeforeMethod
    public void setup() {
        super.setup();
        driver = WebDriverRunner.getWebDriver();
      }

    @Test
    public static void loginToGMailTestUser1() {
        LoginPage.enterUserName(driver, "user1");
        LoginPage.checkUserDate(driver, FULL_USER1);
        LoginPage.goOUT(driver);
    }

    @Test
    public static void loginToGMailTestUser2() {
        LoginPage.enterUserName(driver, "user2");
        LoginPage.checkUserDate(driver, FULL_USER2);
        LoginPage.goOUT(driver);
    }

 /*   @Test
    public static void loginToGMailTestUser3() {
        LoginPage.enterUserName(driver, "user3");
        LoginPage.checkUserDate(driver, FULL_USER3);
        LoginPage.goOUT(driver);
    }
    */
}
