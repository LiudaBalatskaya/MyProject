package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by LiudaBalatskaya on 11/14/2016.
 */
public class Waiter {


    public static void dependableClick(WebDriver d, By by)
    {
        final int MAXIMUM_WAIT_TIME = 10;
        final int MAX_STALE_ELEMENT_RETRIES = 5;

        WebDriverWait wait = new WebDriverWait(d, MAXIMUM_WAIT_TIME);
        int retries = 0;
        while (true)
        {
            try
            {
                wait.until(ExpectedConditions.elementToBeClickable(by)).click();

                return;
            }
            catch (StaleElementReferenceException e)
            {
                if (retries < MAX_STALE_ELEMENT_RETRIES)
                {
                    retries++;
                    continue;
                }
                else
                {
                    throw e;
                }
            }
        }
    }

}
