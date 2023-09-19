package pages;

import elements.Input;
import elements.RadioButton;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ModalProjectPage extends BasePage {
    public static final By UPDATE_BUTTON = By.xpath("//button[@type = 'submit']//span");

    public static final By CANCEL_BUTTON = By.xpath("//button[@type = 'button']/span[text() = 'Cancel']");
    public static final By PROJECTS_BUTTON = By.xpath("//div[@class = 'lsfuW_']//a[text()='Projects']");//кнопка projects в вернем меню на каждой странице


    public ModalProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Create a new project")
    public RepositoryPage createProject(Project project) {
        new Input(driver,"Project name").write(project.getTitle());
        new Input(driver,"Project code").write(project.getProjectCode());
        new TextArea(driver, "Description").write(project.getDescription());
        new RadioButton(driver,"Private").clickOnRadioButton();
        new RadioButton(driver,"Add all members to this project").clickOnRadioButton();
        return clickCreateButton();
    }
    public RepositoryPage clickCreateButton(){
        driver.findElement(UPDATE_BUTTON).click();
        return new RepositoryPage(driver);
    }

    @Step("Cancel the ModalPage")
    public ProjectPage clickCancelButton() {
        log.info("Find and click" + CANCEL_BUTTON);
        driver.findElement(CANCEL_BUTTON).click();
        return new ProjectPage(driver);
    }
    @Step("Click the projects-button")
    public ProjectPage clickProjectsButton(){
        driver.findElement(PROJECTS_BUTTON);
        return new ProjectPage(driver);
    }
    @Override
    public boolean isPageOpen() {

        return isExist(UPDATE_BUTTON);
    }

}