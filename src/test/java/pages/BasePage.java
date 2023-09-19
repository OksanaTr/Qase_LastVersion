package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

import java.time.Duration;

@Log4j2
public abstract class BasePage {

    public static WebDriver driver;
    public WebDriverWait wait;

    public static final String BASE_URL = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
    public abstract boolean isPageOpen();

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));}


    @Step("Сheck the presence of the locator on the loaded page")
    protected boolean isExist(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }}