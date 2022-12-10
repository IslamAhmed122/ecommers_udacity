package stepDefinitions;

import Pages.ForgetUserPage;
import Pages.RegisterPage;
import Pages.loginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgetUserDefinition {

    WebDriver driver =null ;
    ForgetUserPage forget;

    @Given("user open browser for forgetPassword")
    public void openWebSite() throws InterruptedException {
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

    @And("user navigates to forgetPassword page")
    public void user_navigates(){
        driver.navigate().to("https://egymerch.com/en/forget_password");

    }
    @Then("^use email to change password \"(.*)\"$")
    public void chance_password(String restEmail) throws InterruptedException {
        forget = new ForgetUserPage(driver);
        forget.forgetStep(restEmail);
        Thread.sleep(1000);


    }
    @And("click button rest password")
     public void rest_button(){
        forget.sendEmailButton();

    }

    @Then("valid rest password")
    public void email_valid_successfully(){

        String expectedResult= "تم ارسال ايميل لإعادة تعيين كلمة المرور \uD83D\uDC4C";
        String actualResult =driver.findElement(By.cssSelector("div[class=\"d-flex\"]")).getText();

        //junit
        Assert.assertTrue(actualResult.contains(expectedResult));



    }


    @Then("invalid password")
    public void email_invalid(){

        String expectedResult= "The selected email is invalid.";
        String actualResult =driver.findElement(By.cssSelector("p[class=\"text-danger\"]")).getText();

        //junit
        Assert.assertTrue(actualResult.contains(expectedResult));



    }
//    @After
//    public void close_browser(){
//        driver.quit();
//    }
//    @Before
//    public void open_browse() throws InterruptedException {
//        //- bridge between test scripts and browsers
//        String chromePath = System.getProperty("user.dir") +"\\src\\main\\resources\\chromedriver.exe";
//        System.out.println(chromePath);
//        System.setProperty("webdriver.chrome.driver",chromePath);
//
//        //2 new object of webdriver
//        driver = new ChromeDriver();
//
//        //3 navigate to google website and maximize screen and
//        driver.manage().window().maximize();
//        Thread.sleep(3000);
//        driver.navigate().to("https://egymerch.com/en/forget_password");
//
//    }

}
