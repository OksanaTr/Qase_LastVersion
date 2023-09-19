package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CasePage extends BasePage{
    public static final By DELETE_BUTTON = By.xpath("//span[@class='ZwgkIF']//i[@class='far fa-trash']");
    public static final By CLONE_BUTTON = By.xpath("//span[@class='ZwgkIF']//i[@class='far fa-clone']");
    public static final By EDIT_BUTTON = By.xpath("//span[@class='ZwgkIF']//i[@class='far fa-pencil']");
    public static final By DELETE_BUTTON_IN_MODAL = By.xpath("//button[@type='button']" +
            "/ancestor::div[contains(@class,'ReactModal__Content')]//span[text()='Delete']");
    public static final By SAVE_BUTTON = By.xpath("//button[@id= 'save-case']//span");

    public CasePage(WebDriver driver) {
        super(driver);
    }
    @Step("Delete a case")
    public RepositoryPage deleteCase() {
        driver.findElement(DELETE_BUTTON).click();
       log.info("Click button DELETE");
        driver.findElement(DELETE_BUTTON_IN_MODAL).click();
        log.info("Click DELETE_BUTTON_IN_MODAL");
        return new RepositoryPage(driver);
    }

    @Step("Click the Clone button on CaseModalPage")
    public CasePage clickCloneButtonOnCaseModalPage() {
        driver.findElement(CLONE_BUTTON).click();
        log.info("Find the item: " + CLONE_BUTTON + " and click");
        return new CasePage(driver);
    }

    @Step("Click the Edit button")
    public CasePage clickEditButtonOnCaseModalPage() {
        driver.findElement(EDIT_BUTTON).click();
        log.info("Create case from clone case");
        return new CasePage(driver);
    }
    @Step("Click Save button")
    public RepositoryPage clickSaveButton(){
        driver.findElement(SAVE_BUTTON).click();;
        log.info("Click on the Save button");
        return new RepositoryPage(driver);
    }

    /*@Step("Create a new project")
    public RepositoryPage createCase(Case case) {
        new Input(driver,"Project name").write(case.getTitle());
        new Input(driver,"Project code").write(case.getProjectCode());
        new TextArea(driver, "Description").write(case.getDescription());
        new RadioButton(driver,"Private").clickOnRadioButton();
        new RadioButton(driver,"Add all members to this project").clickOnRadioButton();
        return clickSaveButton();
    }*/

    @Step("CaseModalPage loaded")
    @Override
    public boolean isPageOpen() {
        return isExist(DELETE_BUTTON);
    }
}
