package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class ProjectPage extends BasePage {
    public String projectName = "//*[@class='defect-title'][text()='%s']";//+
    public String projectCode = "//a[@class = 'project-name']/img";//+
    public static final By DROPDOWN_SETTINGS = By.xpath("(//tr[@class='project-row'])[Last()](//a[@class = 'btn btn-dropdown'])");//три точки последние на странице
    public static final By DELETE = By.xpath("(//div[@class = 'dropdown'])[last()]//button[@type ='button']");//второе delete внутри трех точек
    public static final By SETTING = By.xpath("//*[@class='defect-title'][text()='%s']/ancestor::tr//a[text()='Settings']");//+
    public static final By LIST_OF_PROJECT = By.xpath("//tr[@class = 'project-row']");
    public String FieldOfSearch = "//div[@class = 'form-inline case-search case-search-input']/input";
    public static final By ADD_FILTER = By.xpath("//div[@class = 'add-filter-outer']//button");
    public static final By PROJECTS_BUTTON = By.xpath("//div[@class = 'lsfuW_']//a[text()='Projects']");//кнопка projects в вернем меню на каждой странице

    public static final By CREATE_BUTTON = By.id("createButton");
    public ProjectPage (WebDriver driver) {

        super(driver);
    }

    @Step("Open the Project' page")
    private ProjectPage open() {
        log.info("Open the project's page");
        driver.get(BASE_URL + "/projects");
        return this;
    }

    @Step("Open project")
    public RepositoryPage openProject(String title) {
        driver.findElement(By.xpath(String.format(projectName, title))).click();
        log.info("Open the project");
        return new RepositoryPage(driver);
    }
    @Step("Enter project title")
    public void enterProjectNameInTheFieldOfSearch(String projectName) {
        driver.findElement(By.id(FieldOfSearch)).sendKeys(projectName);
        log.info("Find project at the placeholder 'Search for projects'");

    }
    @Step("Click the Dropdown button on ProjectsPage")
    public ProjectPage clickDropDownLastProject() {
        driver.findElement(DROPDOWN_SETTINGS).click();
        log.info("Find the item: " + DROPDOWN_SETTINGS + " and click");
        return this;
    }

    @Step("Open project's settings")
    public ProjectPage openSettings(String title) {
        log.info("Click setting for the project");
        driver.findElement(By.xpath(String.format(String.valueOf(SETTING), title))).click();
        return new ProjectPage(driver);
    }
   /* public ProjectPage deleteLastProject(){
        driver.findElement(DROPDOWN_SETTINGS).click();
        driver.findElement(DELETE).click();
        driver.findElement(DELETE_MODAL).click();
        return this;
    }*/

    @Step("Delete project")
    public ProjectPage clickDeleteButtonInDropDown() {
        driver.findElement(DELETE).click();
        log.info("Click delete_button");
        return this;
    }
    @Step("Create project")
    public ProjectPage clickCreateButton() {
        driver.findElement(CREATE_BUTTON).click();
        log.info("Click create_button");
        return this;
    }


    @Step("Click the Settings button in drop down on ProjectsPage")
    public ProjectPage clickSettingsButton() {
        driver.findElement(SETTING).click();
        log.info("Find the item: " + DROPDOWN_SETTINGS + " and click");
        return new ProjectPage(driver);
    }
    public int getListOfProject(){
        List<WebElement> listOfProject = driver.findElements(LIST_OF_PROJECT);
        return listOfProject.size();
    }
    public String getProjectName() {
        String nameOfProject;
        List<WebElement> listOfProjectsNames = driver.findElements(By.id(projectName));
        nameOfProject = listOfProjectsNames.get(0).getText();
        return nameOfProject;
    }

    @Step("Check if projects list page is opened")
    @Override
    public boolean isPageOpen() {
        return isExist(CREATE_BUTTON);
    }
}
