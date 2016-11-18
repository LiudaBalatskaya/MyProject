package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

/**
 * Created by student on 2/4/2015.
 */
public class MainPage extends PageBase {

 //   protected static final String BASE_URL = "http://gmail.com";
    private static final By GMAILCOM_LINK = By.cssSelector("#.FH0XAb>div");
 //   private static final By ADD_ACCOUNT = By.cssSelector("#account-chooser-add-account");

    public static void checkExpectedElements(WebDriver driver) {
        checkExpectedElements(Arrays.asList(new WebElement[]{driver.findElement(GMAILCOM_LINK)}));
    }


}