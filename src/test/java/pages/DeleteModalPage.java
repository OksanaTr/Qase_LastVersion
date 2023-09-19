package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteModalPage extends ProjectPage{
    public final By DELETE_MODAL = By.xpath("//span[text()='Delete project']");//delete  в модальном окне, после нажатия на которое удаляется проект

    public DeleteModalPage(WebDriver driver) {
        super(driver);
    }
    public ProjectPage clickDeleteModal(){
        driver.findElement(DELETE_MODAL).click();
        return this;
    }
}
