package elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Log4j2
public class DropDown {

    WebDriver driver;
    String label;
    WebDriverWait wait;
    String dropDownValue = "//label[text()='%s']/ancestor::div[contains(@class,'col-sm-12')]//div[@class='Thgbhj euhZGB cfvQxI']";
    String optionLocator = "//div[@class='vp8Qwu']//div//div//div[text()='%s']";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Step("Select option from dropdowns")
        public void selectOptions(String option){
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(dropDownValue,this.label)))).click();
            log.info("Find the DropDown field by label: " + label + " and clicks");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(optionLocator, option)))).click();
            log.info("Find the DropDown option field by label: " + label + " and clicks");
        }
    }