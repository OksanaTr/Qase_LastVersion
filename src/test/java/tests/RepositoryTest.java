package tests;

import io.qameta.allure.Description;
import models.*;
import org.testng.annotations.Test;
import tests.bases.BaseTest;

import static org.testng.Assert.assertEquals;


public class RepositoryTest extends BaseTest {
    @Test(description = "Create of suite")
    public void createOfSuite() {
        loginPage
                    .open()
                    .enterEmailAndPasswordData(email, password)
                    .clickSingInButton();
            modalProjectPage.clickCreateButton();

            Project project = ProjectFactory.enterRandomFieldModalProjectPage();
            modalProjectPage.createProject(project);
        repositoryPage.clickSuiteButton();
        Suite newSuite = SuiteFactory.enterAllFieldOfTheSuite();

        repositoryPage.clickSuiteButton();

        assertEquals(repositoryPage.getTextAlertMessageOnRepositoryPage(), "Suite was successfully created.",
                "The message is missing or does not match");

        }
    @Description("Create a case")
    @Test
    public void createCaseWithAllFields() {
        loginPage.open()
                .enterEmailAndPasswordData(email,password)
                .clickSingInButton();
                modalProjectPage.clickProjectsButton();
        Project project = ProjectFactory.enterRandomFieldModalProjectPage();
        modalProjectPage.createProject(project)
                .clickCaseButton();
        Case caseBasic = CaseFactory.fillInAllFieldsOfBasicCase();
        Case caseConditions = CaseFactory.fillInAllFieldsOfBasicCase();

        assertEquals(repositoryPage.getTextAlertMessageOnRepositoryPage(), "Test case was created successfully!",
                "The message is missing or does not match");

    }}

  /*  @Description("The user delete a case")
    @Test
    public void deleteCase() {
        loginPage.open()
                .enterEmailAndPasswordData(email, password)
                .clickSingInButton();
        Project Project;
        modalProjectPage.createProject(Project);

                Project project = ProjectFactory.enterRandomFieldModalProjectPage();
        modalProjectPage.createProject(project)
                .clickCaseButton();
        Case caseBasic = CaseFactory.fillInAllFieldsOfBasicCase();
        casePage.createCase();
                repositoryPage.clickCaseButton()
                        .deleteCase();
                assertTrue(repositoryPage.checksThatListIsDisplayed(), "The list contains cases");
        projectsPage.deleteLatestProjectAfterTest();
    }*/