package base;

import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertTrue;

/**
 * Created by student on 2/4/2015.
 */
public class PageBase {

    protected static void checkExpectedElements(List<WebElement> elements) {
        for (WebElement element : elements) {
            assertTrue(element.isDisplayed());
        }
    }
}
