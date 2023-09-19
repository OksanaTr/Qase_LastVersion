package tests;

import io.qameta.allure.Description;
import models.Project;
import models.ProjectFactory;
import org.testng.annotations.Test;
import tests.bases.BaseTest;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;


public class ProjectTest extends BaseTest {
    @Test(description = "Create a new project")
    public void createProject() {
        loginPage
                .open()
                .enterEmailAndPasswordData(email, password)
                .clickSingInButton();
        projectPage.clickCreateButton();

        Project project = ProjectFactory.enterRandomFieldModalProjectPage();
        modalProjectPage.createProject(project);
        assertTrue(repositoryPage.getNameOfProject(), "The project is not found");

    }
    @Description("The user delete the project")
    @Test
    public void userDeleteProject() {
        loginPage
                .open()
                .enterEmailAndPasswordData(email, password)
                .clickSingInButton();
                modalProjectPage.clickCreateButton();

        Project project = ProjectFactory.enterRandomFieldModalProjectPage();
        modalProjectPage.clickCreateButton();
        assertTrue(repositoryPage.getNameOfProject(), "The project is not found");

        int list1 = projectPage.getListOfProject();

         projectPage.clickDropDownLastProject()
                .clickDeleteButtonInDropDown();
         deleteModalPage.clickDeleteModal();
        modalProjectPage.clickProjectsButton();
        int list2 = projectPage.getListOfProject();

        assertNotEquals(list2, list1, "Lists = ");
    } }

   /* @Test(description = "Update project")
    public void updateProject() {
    RepositoryPage.open()
            .openProject("projectName");
    assertTrue(RepositoryPage.isPageOpen());
        Project project = ProjectFactory.get();
        modalProjectPage.enterTheDataInModalPage(project);

        assertTrue(repositoryPage.getProjectCode());

    }*/









