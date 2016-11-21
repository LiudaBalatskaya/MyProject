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
public class VerifyDeletedEmailTest extends TestBase {

   public static WebDriver driver;

    @Override
    @BeforeMethod
    public void setup() {
        super.setup();
        driver = WebDriverRunner.getWebDriver();
    }

    @Test
    public static void deleteMessageVerify() {
        LoginPage.enterUserName(driver, "user1");
        Assert.assertTrue(LoginPage.deleteMailVerify(driver));
    }



}
