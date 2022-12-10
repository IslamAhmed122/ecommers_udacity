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

    @And("user click in register button")
    public void login_register_button() throws InterruptedException {

        register.confirmationPF.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

    }
    @Then("user could login  unsuccessfully")
    public void unSuccess_login(){
       String expectedResult= "The email has already been taken.";
       String actualResult = driver.findElement(By.cssSelector("P[class=\"text-danger\"]")).getText();

       //junit
       Assert.assertTrue(actualResult.contains(expectedResult));


   }
    @And("user navigates to home page")
    public void back_home_page() throws InterruptedException {
        Thread.sleep(1000);
        driver.navigate().to("https://egymerch.com/en");
        Thread.sleep(1000);



    }
    @After
    public void close_browser(){
        driver.quit();
    }
    @Before
    public void open_browse() throws InterruptedException {
        //- bridge between test scripts and browsers
        String chromePath = System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver",chromePath);

        //2 new object of webdriver
        driver = new ChromeDriver();

        //3 navigate to google website and maximize screen and
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://egymerch.com/en/register");

    }




}
