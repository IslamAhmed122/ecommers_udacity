package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
WebDriver driver;

   public loginPage(WebDriver driver){
       this.driver = driver ;
       PageFactory.initElements(driver,this);
   }

   @FindBy(id = "login-name")
    WebElement emailRealPF;


    @FindBy(id = "login-password")
    WebElement passwordRealPF;


    @FindBy( id = "login-seller")
    public
    WebElement loginButton;


    public void LoginSteps( String email , String password ){
        //enter user name
        emailRealPF.clear();
        emailRealPF.sendKeys(email);
        passwordRealPF.sendKeys(password);



    }
    public void clickEnter(){
        passwordRealPF.sendKeys(Keys.ENTER) ;
    }









}
