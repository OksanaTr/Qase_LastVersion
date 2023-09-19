package tests;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.bases.BaseTest;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@Log4j2
public class LoginTest extends BaseTest {

    @Description("Authorization with valid data")
    @Test
    public void userLogInWithValidData() {
 boolean isProjectPage = loginPage.open()
        .enterEmailAndPasswordData(email, password)
        .clickSingInButton()
                .isPageOpen();

        assertTrue(isProjectPage);
   }

    @DataProvider(name = "InvalidLoginTest")
    public Object[][] InvalidLoginTest () {
        return new Object[][]{
                {"xetive9314@sportrid.com", "1234567891abc!S", "These credentials do not match our records."},
                {"ыва@yandex.com", "1234567891abc!S", "Value 'ыва@yandex.com' does not match format email of type string"},
                {"xetive9314@sportrid.com", "1234567891abc!S**************************************", "These credentials do not match our records."},
                {"xetive9314@sportrid.com", "1234567891чмc!S", "These credentials do not match our records."},
                {"ghnb@yande.ru", "1234567891abc!S", "These credentials do not match our records."},
                {"xetive9314@sportrid.com ","1542368S**15a", "Value 'xetive9314@sportrid.com ' does not match format email of type string"},
                {"xetive9314@sportrid.com", "123456789", "Security notice: The password entered has been found in a public data leak. Please reset your password to ensure the safety of your account"},
                };
    }
    @Description("Input invalid data")
    @Test(dataProvider="InvalidLoginTest")
    public void userEnterInvalidDataInLogin(String email, String password, String textError) {
       loginPage.open()
                .enterEmailAndPasswordData(email,password)
                .clickSingInButton()
                .isPageOpen();

        assertEquals(loginPage.getErrorMessage(), textError,
                "The message text is incorrect or missing");
    }
    @Description("Leave field email is empty")
    @Test(description = "don't enter the data of the email")
    public void LeaveEmailIsEmpty(){
        loginPage.open()
                .enterEmailAndPasswordData("",password)
                .clickSingInButton().isPageOpen();
        assertEquals(loginPage.getErrorMessage2("Work email"), "This field is required", "This field is required");
    }
    @Description("Leave field password is empty")
    @Test(description = "don't enter the data of the password")
    public void LeavePasswordIsEmpty(){
       loginPage.open()
                .enterEmailAndPasswordData(email,"")
                .clickSingInButton().isPageOpen();
        assertEquals(loginPage.getErrorMessage2("Password"),"This field is required","This field is required");
    }
}