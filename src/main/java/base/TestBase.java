package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import helper.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;


/**
 * 11.10.2016
 */
@Listeners({TestListener.class})
public class TestBase {
    private static final String DEFAULT_URL = "http://gmail.com";
    private static final String DEFAULT_BROWSER = "firefox";
    //private static final String DEFAULT_BROWSER = "Chrome";
    public String siteUrl;

    @BeforeMethod()
    public void setup() {
        Configuration.baseUrl = System.getProperty("url", DEFAULT_URL);
        Configuration.browser = System.getProperty("browser", DEFAULT_BROWSER);
        Configuration.timeout = 10000;
        siteUrl = DEFAULT_URL;
        open(Configuration.baseUrl);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterMethod
        public void exit(){close(); }


}

