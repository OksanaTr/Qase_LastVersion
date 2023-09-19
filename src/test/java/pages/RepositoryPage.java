package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class RepositoryPage extends BasePage {

    public static final By PROJECTS_BUTTON = By.xpath("//a[@class = 'prLoyX' and text() = 'Projects']");//кнопка projects в вернем меню на каждой странице
    public static final By REPOSITORY_NAME = By.xpath("//div[@class = 'CVtO6O']//h1");
    public static final By SUITE_CREATE_BTN = By.id("create-suite-button");
    public static final By CASE_CREATE_BTN = By.id("create-case-button");
   public  static  final  By SEARCH_FIELD = By.xpath("//div[@class = 'form-inline case-search case-search-input']//input");
    public  static final By ADD_FILTER = By.xpath("//button[@class = 'add-filter-button']");
    String TRASH_BIN_SETTING = "//a[@href='case/%s/trashbin']";
    private static final By VIEWS_BUTTON = By.xpath("//span/i[@class='far fa-stream']");
    public static final By DELETE_BUTTON_IN_DROPDOWN = By.xpath("//div//i[@class='fas fa-trash' or text()='Delete']");
    public static final By EDIT_BUTTON_IN_DROPDOWN = By.xpath("//div[@class='Cr3S77']//i[@class='far fa-pencil']");
    public static final By CLONE_BUTTON_IN_DROPDOWN = By.xpath("//div[@class='Cr3S77']//i[@class='far fa-clone']");
    public static final By DELETE_BUTTON = By.xpath("//button[@type='submit']//span[text()='Delete']");
    String ALERT_MESSAGE = "//span[@class= 'ic9QAx']";
    public RepositoryPage(WebDriver driver) {

        super(driver);
    }


    @Step("Get the project code")
    public boolean getProjectCode() {
        boolean projectCode = driver.findElement(REPOSITORY_NAME).isDisplayed();
        log.info("Find xpath and get the project code: " + REPOSITORY_NAME);
        return projectCode;
    }
    @Step("Get the project name")
    public boolean getNameOfProject(){
        boolean nameProject= driver.findElement(REPOSITORY_NAME).isDisplayed();
        return nameProject;
    }
    @Step("Click the projects-button")
    public ProjectPage clickProjectsButton(){
        driver.findElement(PROJECTS_BUTTON);
        return new ProjectPage(driver);
    }
    @Step("Click Suite button")
    public SuiteModalPage clickSuiteButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(SUITE_CREATE_BTN)).click();
        log.info("Find the item: " + SUITE_CREATE_BTN + " and click");
        return new SuiteModalPage(driver);
    }

    @Step("Click Case button")
    public CasePage clickCaseButton() {
        driver.findElement(CASE_CREATE_BTN).click();
        log.info("Find the item: " + CASE_CREATE_BTN + " and click");
        return new CasePage(driver);
    }

       @Step("Click the Delete button in drop down")
    public RepositoryPage clickDeleteButtonInDropDown() {
        driver.findElement(DELETE_BUTTON_IN_DROPDOWN).click();
        log.info("Find the item: " + DELETE_BUTTON_IN_DROPDOWN + " and click");
        return this;
    }
    @Step("Click the Delete button")
    public RepositoryPage clickDeleteButton() {
        driver.findElement(DELETE_BUTTON).click();
        log.info("Find the item: " + DELETE_BUTTON + " and click");
        return this;
    }


    @Step("Click the Add filter button")
    public RepositoryPage clickAddFilterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_FILTER)).click();
        log.info("Find the item: " + ADD_FILTER + " and click");
        return this;
    }
    @Step("Get the alert message on the RepositoryPage")
    public String getTextAlertMessageOnRepositoryPage() {
        String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ALERT_MESSAGE))).getText();
        log.info("Get a message about creating suites");
        return text;
    }


    @Override
    public boolean isPageOpen() {

        return isExist(REPOSITORY_NAME);
    }
}