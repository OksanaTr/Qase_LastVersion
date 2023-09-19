package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TextEditor {
    WebDriver driver;
    String label;
    String textEditorLoc = "//label[text()='%s']/../..//p";

    public TextEditor(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    @Step("Delete and write text in a textEditor")
    public void write(String text) {
        driver.findElement(By.xpath(String.format(textEditorLoc, this.label))).clear();
        log.info("Clear the TextEditor field ");
        driver.findElement(By.xpath(String.format(textEditorLoc, this.label))).sendKeys(text);
        log.info("Write text in the field TextEditor");
    }

}