package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RadioButton {
    WebDriver driver;
    String label;
    String radioButtonLocator = "//span[text()='%s']/ancestor::label//input";


    public RadioButton(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }
    @Step("Click on RadioButton")
    public void clickOnRadioButton(){
        driver.findElement(By.xpath(String.format(radioButtonLocator,this.label))).click();
        log.info("Find the RadioButton by label: " + label + " and clicks");
    }
}
