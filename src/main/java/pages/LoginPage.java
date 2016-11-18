package pages;

import base.PageBase;
import helper.Creds;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by student on 2/4/2015.
 */
public class LoginPage extends PageBase {

    protected static final String fromtext = "Message from the Test" ;
    protected static final String text = "Hello,my friend!";

    protected static final String BASE_URL = "http://gmail.com";
    private static final By GMAILCOM_LINK = By.cssSelector("#.FH0XAb>div");
    private static final By ADD_ACCOUNT = By.cssSelector("#account-chooser-add-account");

    // enter user name
    private static final By USER_NAME = By.cssSelector("#Email");
    private static final By NEXT = By.cssSelector("#next");
    private static final By CHOOSE_ACCOUNT_USER1 = By.cssSelector("#choose-account-3");
    // login
    private static final By LOGIN_INPUT = By.cssSelector("");
    // пароль
    private static final By PASSWORD_INPUT = By.cssSelector("input#Passwd");
    private static final By SIGN_IN = By.cssSelector("#signIn");

    // check loaded into mail
    private static final By TO_CHECK = By.cssSelector(".gb_8a.gbii");
    private static final By CHECK_USERNAME = By.cssSelector(".gb_vb");

    private static final By GO_OUT = By.cssSelector("#gb_71");

    private static final By START_NEW_MESSAGE = By.cssSelector(".z0");
    private static final By TO_EMAIL = By.cssSelector("textarea[aria-label=\"To\"]");
    private static final By SUBJECT = By.cssSelector("input[placeholder=\"Subject\"]");
    private static final By TEXT = By.cssSelector("div[aria-label='Message Body']");
    private static final By SEND = By.cssSelector("*.IZ tbody tr td div[class=\"T-I J-J5-Ji aoO T-I-atl L3\"]");
    private static final By EXPLANATION_STRING = By.cssSelector(".vh");
    private static final By BUTTON_DELETE = By.cssSelector(".ar9.T-I-J3.J-J5-Ji");

    // TRASH
    private static final By TRASH_ONE_FOUR = By.cssSelector(".F.cf.zt tr:nth-child(1) td:nth-child(4) .afn span");
    private static final By COLUMN_FOUR = By.cssSelector(".aAX .F.cf.zt tr td:nth-child(4)");
    private static final By COLUMN_SEX = By.cssSelector(".aAX .F.cf.zt tr td:nth-child(6) span:first-child");
    private static final By COLUMN_SEX_TWO = By.cssSelector(".F.cf.zt tr td:nth-child(6) span:nth-child(2)");

    private static final By FIRST_ROW_CHECKBOX = By.cssSelector("table[class=\"F cf zt\"] tr:first-child td:nth-child(2)");
    // 1-я str,col=4
    private static final By FIRST_ROW_FOUR = By.cssSelector(".aAX .F.cf.zt tr:first-child td:nth-child(4)");
    // 1-я str,col=6
    private static final By FIRST_ROW_SIX = By.cssSelector(".aAX .F.cf.zt tr:first-child td:nth-child(6) span:first-child");
    // 1-я str,col=6
    private static final By FIRST_ROW_SEVEN = By.cssSelector("table[class=\"F cf zt\"] tr:first-child td:nth-child(6) span:nth-child(2)");
    //4
    private static final By SENT_MAIL = By.cssSelector("span.nU .J-Ke.n0[title=\"Sent Mail\"]");
    private static final By BLOCK = By.cssSelector(".r9gPwb");
    private static final By MORE = By.cssSelector(".n6");

    private static final By TRASHTABEL = By.cssSelector(".BltHke.nH.oy8Mbf .ya");
    private static final By TRASH = By.cssSelector(".r9gPwb a.J-Ke.n0[title=\"Trash\"]");
    private static final By TRASHCOLL_FOUR = By.cssSelector("div.Cp .F.cf.zt .zA.zE td:nth-of-type(4)");
    private static final By TRASHCOLL_SEX = By.cssSelector("div.Cp .F.cf.zt .zA.zE td:nth-of-type(6) .y6 span:first-of-type");

    private static final By SENT_MAIL_FIRST_FOUR = By.cssSelector(".ae4.UI .F.cf.zt tr:first-of-type td:nth-child(4)");
    // .afn span[name=\"seleniumtests30\"]");
    private static final By SENT_MAIL_FIRST_SEX_ONE = By.cssSelector("div[role=\"main\"] .F.cf.zt tr:first-child td:nth-child(6) span:first-of-type");
    private static final By SENT_MAIL_FIRST_SEX_TWO = By.cssSelector("div[role=\"main\"] .F.cf.zt tr:first-child td:nth-child(6) span:nth-of-type(2)");

    public static void login() {
        String[] creds = Creds.get(System.getProperty("user", "defaultUser"));
 //       login(creds[0], creds[1]);
    }

    public static void toNewMessage(WebDriver driver) {
        Waiter.dependableClick(driver,START_NEW_MESSAGE);
    }
//3

    public static void enterEmail(WebDriver driver, String email) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(START_NEW_MESSAGE));
        driver.findElement(START_NEW_MESSAGE).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(TO_EMAIL));
        driver.findElement(TO_EMAIL).sendKeys(email);
        driver.findElement(SUBJECT).sendKeys(fromtext);
        driver.findElement(TEXT).sendKeys(text);
        driver.findElement(SEND).click();
}
    //3
    public static void verifyMessage(WebDriver driver) {

        String str;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(FIRST_ROW_FOUR));
        str = driver.findElement(FIRST_ROW_FOUR).getText();
        str.contentEquals("Selenium Selenium");

        str = driver.findElement(FIRST_ROW_SIX).getText();
        str.contentEquals("Message from the Test");

        str = driver.findElement(FIRST_ROW_SEVEN).getText();
        str.contentEquals("Hello,my friend!");

        }

    public static boolean verifySentMailList(WebDriver driver) {
        String str;
        boolean bul=false;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(SENT_MAIL));
        driver.findElement(SENT_MAIL).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(SENT_MAIL_FIRST_FOUR));
        driver.findElement(SENT_MAIL_FIRST_FOUR);
        str = driver.findElement(SENT_MAIL_FIRST_SEX_ONE).getText();
        if (str.equalsIgnoreCase("Message from the Test")){
            bul = true; }

        if (bul){
            str = driver.findElement(SENT_MAIL_FIRST_SEX_TWO).getText();
            if(str.equalsIgnoreCase(" - Hello,my friend!")) {
                bul = true;
            }
            else {bul = false;}
        }
        return bul;
    }

    public static boolean deleteMailVerify(WebDriver driver) {
        String name;
        String subj;
        String str;
        String str1;

        boolean bul=false;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(FIRST_ROW_FOUR));
        name = driver.findElement(FIRST_ROW_FOUR).getText();
        subj = driver.findElement(FIRST_ROW_SIX).getText();

        driver.findElement(FIRST_ROW_CHECKBOX).click();
        driver.findElement(BUTTON_DELETE).click();

        driver.findElement(BLOCK).click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(MORE));
        driver.findElement(MORE).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(TRASH));
        driver.findElement(TRASH).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(TRASHTABEL));
          int i=-1;
        List<WebElement> trashFour = driver.findElements(TRASHCOLL_FOUR);
        List<WebElement> trashSex = driver.findElements(TRASHCOLL_SEX);
        int k = trashFour.size();
        for (WebElement suggestion : trashFour) {
            str = suggestion.getText();
            i++;
            if (str.equalsIgnoreCase(name)){
                str1 = trashSex.get(i).getText();
                if(str1.equalsIgnoreCase(subj)){
                    bul = true;
                }
            }
        }
        return bul;
        }



    public static void gotoPage(WebDriver driver) {
        driver.get(BASE_URL);
    }

    // to add account
    public static void gotoAddAccount(WebDriver driver) {
        driver.findElement(ADD_ACCOUNT).click();
    }

    public static void enterUserName(WebDriver driver)  {
        String[] creds = Creds.get(System.getProperty("user", "password"));

        driver.findElement(USER_NAME).sendKeys(creds[0]);
        Waiter.dependableClick(driver,NEXT);
        driver.findElement(PASSWORD_INPUT).sendKeys(creds[1]);
        Waiter.dependableClick(driver,SIGN_IN);
    }

    public static void enterUserName(WebDriver driver, String userKey)  {
        String[] creds = Creds.get(userKey);
        WebElement element;
        driver.findElement(USER_NAME).sendKeys(creds[0]);
        Waiter.dependableClick(driver,NEXT);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_INPUT));
        driver.findElement(PASSWORD_INPUT).sendKeys(creds[1]);
        Waiter.dependableClick(driver,SIGN_IN);

    }


    public static void enterUserName(WebDriver driver, String name, String pass) {
        driver.findElement(USER_NAME).sendKeys(name);
        Waiter.dependableClick(driver,NEXT);
        driver.findElement(PASSWORD_INPUT).sendKeys(pass);
        Waiter.dependableClick(driver,SIGN_IN);
    }

    public static void chooseUser1(WebDriver driver) {
        driver.findElement(CHOOSE_ACCOUNT_USER1).sendKeys();
    }

    public static void enterLogin(WebDriver driver, String login) {
        driver.findElement(LOGIN_INPUT).sendKeys(login);
    }

    public static void checkUserDate(WebDriver driver, String login) {
        // login - full name
        String foolname;
        Waiter.dependableClick(driver,TO_CHECK);
        foolname = driver.findElement(CHECK_USERNAME).getAttribute(login);
    }

    public static void gotoS(WebDriver driver) {
        Waiter.dependableClick(driver,TO_CHECK);
    }
    public static void goOUT(WebDriver driver) {
        Waiter.dependableClick(driver,GO_OUT);

    }


}
