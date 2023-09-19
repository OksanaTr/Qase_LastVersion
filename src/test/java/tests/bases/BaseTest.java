package tests.bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {
    protected String baseUrl, email, password;
    public WebDriver driver;
    protected String getErrorMessage2;
    protected String getErrorMessage1;
    protected LoginPage loginPage;
    protected ModalProjectPage modalProjectPage;
    protected ProjectPage projectPage;
    protected RepositoryPage repositoryPage;
    public DeleteModalPage deleteModalPage;
public  CasePage casePage;
public SuiteModalPage suiteModalPage;
   @Step("Setting up and opening the browser")
   @BeforeMethod
   public void setUp() {
       baseUrl = System.getenv().getOrDefault("QASE_URL", PropertyReader.getProperty("qase.url"));
       email = System.getenv().getOrDefault("QASE_EMAIL", PropertyReader.getProperty("qase.email"));
       password = System.getenv().getOrDefault("QASE_PASSWORD", PropertyReader.getProperty("qase.password"));
       WebDriverManager.chromedriver().setup();
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--start-maximized");
       //options.addArguments("--headless");
       driver = new ChromeDriver(options);
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        loginPage = new LoginPage(driver);
        modalProjectPage = new ModalProjectPage(driver);
        projectPage = new ProjectPage(driver);
        casePage = new CasePage(driver);
        repositoryPage = new RepositoryPage(driver);
        suiteModalPage = new SuiteModalPage(driver);
        deleteModalPage = new DeleteModalPage(driver);
    }

    @Step("Closing the browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        driver.quit();
    }
}
