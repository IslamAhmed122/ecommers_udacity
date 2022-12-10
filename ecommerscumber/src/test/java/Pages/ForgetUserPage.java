package Pages;

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

    @FindBy(css = "button[class=\"btn btn-fill-out btn-block hover-up\"]")
    WebElement restPasswordPF;




    public void forgetStep(String restEmail) {

        forgetEmailPF.sendKeys(restEmail);
    }

    public void sendEmailButton(){
        forgetEmailPF.sendKeys(Keys.ENTER);
        restPasswordPF.click();
    }


}