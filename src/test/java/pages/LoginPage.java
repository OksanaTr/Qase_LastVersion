package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;

import static org.testng.Assert.assertTrue;


@Log4j2
public class LoginPage extends BasePage{

    public static final By CHECKBOX_INPUT = By.xpath("//input[@name='remember']");
    final By SIGN_IN_BUTTON = By.xpath("//button[@type='submit']/span");
    public static final String textError = "//div[@class='tdishH']//small";
    final By ERROR_MESSAGE2 = By.xpath("//div[@class='nlvny_']//span[@class='VF_8Uu']");
    public static final By EMAIL = By.xpath("//input[@name='email']");
    public static final By PASSWORD = By.xpath("//input[@name='password']");



    public LoginPage(WebDriver driver) {

        super(driver);
    }

    @Step("Open login page")
    public LoginPage open() {
        driver.get(BASE_URL + "login");
        log.info("Open login page");
        return new LoginPage(driver);
    }

    @Step("Input data about email and password")
    public LoginPage enterEmailAndPasswordData (String email, String password) {
        driver.findElement(EMAIL).sendKeys(email);
        log.info("Enter data in the field email");
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("Enter data in the field password");
        return this;
    }

    @Step("Select of Checkbox")
    public void clickCheckBoxInput() {
        Boolean value = driver.findElement(By.id("CHECKBOX_INPUT")).isEnabled();
        assertTrue(value);
        if (value = false){
            driver.findElement(CHECKBOX_INPUT).click();}
        log.info("Find CHECKBOX_INPUT and click on 'Remember me'");

    }

    @Step("Click on Sign in button")
    public ProjectPage clickSingInButton() {
        log.info("Click on [Sign_in] button");
        driver.findElement(SIGN_IN_BUTTON).click();
        return new ProjectPage(driver);
    }

    @Step("Get a message that you need to enter data of email and/or password")
    public String getErrorMessage( ) {
        String errorMessage=driver.findElement(ERROR_MESSAGE2).getText();
        log.info("Get a text message about incorrect authorization: " + errorMessage);
        return errorMessage;
    }

       @Step("Get message about uncorrected data of email and/or password")
    public String getErrorMessage2(String placeholder) {
           String textMessage = driver.findElement(By.xpath(String.format(textError, placeholder))).getText();
           log.info("Get a text message about incorrect authorization: " + textMessage);
           return textMessage;   }

    @Step("User registers with valid data")
    public ProjectPage inputValidLoginData() {
        open();
        log.info("Open LoginPage");
        enterEmailAndPasswordData(System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email")),
                System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password")));
        log.info("Input login and password");
        clickSingInButton();
        log.info("Click the Sign in button");
        return new ProjectPage(driver);
    }

    @Override
    public boolean isPageOpen() {

        return isExist(SIGN_IN_BUTTON);
    }
}