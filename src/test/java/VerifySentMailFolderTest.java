import base.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

/**
 * Created by LiudaBalatskaya on 11/16/2016.
 */
public class VerifySentMailFolderTest extends TestBase {

    private static WebDriver driver;
    private static String FULL_USER_NAME2 = "seleniumtests30@gmail.com";

    @Override
    @BeforeMethod
    public void setup() {
        super.setup();
        driver = WebDriverRunner.getWebDriver();;
    }

    @Test
    public static void sendMessage() {
        LoginPage.enterUserName(driver, "user1");
        LoginPage.enterEmail(driver, FULL_USER_NAME2);
        LoginPage.gotoS(driver);
        LoginPage.goOUT(driver);
    }
    @Test//(dependsOnMethods = {"sendMessage"})
    public static void verifyMessage() {
        LoginPage.enterUserName(driver, "user1");
        Assert.assertTrue(LoginPage.verifySentMailList(driver));
    }


}
