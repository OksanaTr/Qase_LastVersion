package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TextArea {
    WebDriver driver;
    String label;
    String textAreaLocator = "//label[text()='%s']/ancestor::div//textarea";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    @Step("Clear and write the text in TextArea")
    public void write(String text) {
        driver.findElement(By.xpath(String.format(textAreaLocator, this.label))).clear();
        log.info("Find the TextArea field by label: " + label + " and clear: ");
        driver.findElement(By.xpath(String.format(textAreaLocator, this.label))).sendKeys(text);
        log.info("Find the TextArea field by label: " + label + " and write text: " + text);
    }
}