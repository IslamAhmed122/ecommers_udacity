package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetUserPage {
    WebDriver driver;

    public ForgetUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css= "input[type=\"email\"]")
    WebElement forgetEmailPF;

    public WebElement getElementByPath(String elem)
    {

        return this.driver.findElement(By.xpath(elem));
    }



    public void forgetStep(String restEmail) {

        forgetEmailPF.sendKeys(restEmail);
    }

    public void sendEmailButton(String email){
        forgetEmailPF.sendKeys(Keys.ENTER);

    }


}