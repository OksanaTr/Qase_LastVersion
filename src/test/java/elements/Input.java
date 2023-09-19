package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class Input {
    WebDriver driver;
    WebDriverWait wait;
    String label;
    String inputLocator = "//label[text()='%s']/../..//input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Step("Clear and write the text in Input")
    public void write(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(String.format(inputLocator, this.label))))).clear();
        log.info("Find the input field by label: "+label+" and clear: ");
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(String.format(inputLocator, this.label))))).sendKeys(text);
        log.info("Find the input field by label: "+label+" and write text: " +text);

    }

}


