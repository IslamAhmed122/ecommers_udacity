package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {


    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="input[name=\"name\"]")
    WebElement usernamePF;

    @FindBy(css= "input[name=\"email\"]")
    WebElement emailPF;

    @FindBy(css = "input[name=\"phone\"]")
    WebElement phonePF;

    @FindBy(css = "input[name=\"password\"]")
    WebElement passwordPF;

    @FindBy(css = "input[name=\"password_confirmation\"]")
    public
    WebElement confirmationPF;

    public WebElement getElementByClass(String elem)
    {

        return this.driver.findElement(By.className(elem));
    }
    public WebElement getElementByID(String elem)
    {

        return this.driver.findElement(By.id(elem));
    }
    public WebElement getElementByPath(String elem)
    {

        return this.driver.findElement(By.xpath(elem));
    }




    @FindBy(css= "i[class=\"fas fa-heart mx-2\"]")
    public
    WebElement registerPF;



    public void RegisterStep(String userName,String email,String phone , String password,String confirmPassword ) throws InterruptedException {
        usernamePF.clear();
        usernamePF.sendKeys(userName);
        emailPF.sendKeys(email);
        phonePF.sendKeys(phone);
        passwordPF.sendKeys(password);
        confirmationPF.sendKeys(confirmPassword);





    }

}
