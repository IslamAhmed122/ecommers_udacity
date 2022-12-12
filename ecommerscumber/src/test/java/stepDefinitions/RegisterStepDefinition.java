package stepDefinitions;

import Pages.RegisterPage;
import Pages.loginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterStepDefinition {
    WebDriver driver =null ;
    RegisterPage register;


    @Given("user open browser for register")
    public void openRegister() throws InterruptedException {
        //- bridge between test scripts and browsers
        String chromePath = System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver",chromePath);

        //2 new object of webdriver
        driver = new ChromeDriver();

        //3 navigate to google website and maximize screen and
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @And("user navigates to register page")
    public void user_navigates(){
        driver.navigate().to("https://egymerch.com/en/register");

    }
    @When("^user enter valid \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
    public void register_user (String userName, String email, String phone, String password,String confirmPassword) throws InterruptedException {
        register = new RegisterPage(driver);
        register.RegisterStep( userName, email,phone,password,confirmPassword);
    }


    @Then("he can register successfully and \"Your registeration completed\" messege appears")
    public void validRegister() throws InterruptedException {
        register.confirmationPF.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        String expected = "Your registration completed";
        String actual = register.getElementByClass("d-flex").getText();

        Assert.assertTrue(" تم ارسال ايميل لتاكيد الحساب \uD83D\uDC4C",expected.contains(actual));
        Thread.sleep(2000);
    }



    @Then("error messeges for invalid fields appear")
    public void invalidRegister() throws InterruptedException, NoSuchElementException {
        register.confirmationPF.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        String expectedEmail = "Wrong email";
        String expectedPassword = "Password must meet the following rules:";
        String expectedConfirmPassword = "The password and confirmation password do not match.";

        try {
            String actualEmail = register.getElementByPath("/html/body/main/main/section/div/div/div[1]/div/div/div/form/div[2]/p").getText();
            Assert.assertTrue("The email has already been taken.", expectedEmail.contains(actualEmail));
        } catch (NoSuchElementException e) {
            System.out.println("Exception in Email");

        }
        try {
            String actualPassword = register.getElementByPath("/html/body/main/main/section/div/div/div[1]/div/div/div/form/div[4]/p").getText();
            System.out.println(actualPassword);
            Assert.assertTrue("Error in Password", expectedPassword.contains(actualPassword));
        } catch (NoSuchElementException e1) {
            System.out.println("Exception in Password");

        }
        try{
            String actualConfirmPassword = register.getElementByID("ConfirmPassword-error").getText();
            Assert.assertTrue("The password confirmation does not match.", expectedConfirmPassword.contains(actualConfirmPassword));
        }catch(NoSuchElementException e2){
            System.out.println("Exception in Confirm Password");

        }


    }






    @And("user navigates to home page")
    public void back_home_page() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().to("https://egymerch.com/en");
        Thread.sleep(1000);



    }
    @Then("error messeges for existing account appear")
    public void existingRegister() throws InterruptedException {
        register.confirmationPF.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        String expectedEmail = "The specified email already exists\n";
        String actualEmail = register.getElementByPath("/html/body/main/main/section/div/div/div[1]/div/div/div/form/div[2]/p").getText();
        Assert.assertTrue(" Email exists ",expectedEmail.contains(actualEmail) );


    }
    @After("@regression")
    public void afterRegistration()
    {
        this.driver.quit();
    }
}





