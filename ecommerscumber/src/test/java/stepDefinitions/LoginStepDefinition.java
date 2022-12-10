package stepDefinitions;
import Pages.loginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {
    WebDriver driver =null ;
    loginPage login;

    @Given("user open browser")
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

    @And("user navigates to login page")
    public void user_navigates(){
        driver.navigate().to("https://egymerch.com/en/login");

    }

    @When("^user enter \"(.*)\" and \"(.*)\"$")
    public void valid_data(String email, String password){
        login = new loginPage(driver);

        login.LoginSteps(email,password);


    }

    @And("user click in login button")
    public void login_button() throws InterruptedException {
        Thread.sleep(1000);
        login.clickEnter();
        Thread.sleep(1000);

    }
    //comper

//    @Then("user could login successfully")
//    public void success_login(){
//        String expectedResult= "";
////        String actualResult = driver.findElement()
//
//         //junit
//        Assert.assertTrue(actualResult.contains(expectedResult));
//        Assert.assertEquals(actualResult.contains(expectedResult),true);
//
//    }

    @And("user go to home page")
    public void home_page(){
        Assert.assertEquals("https://egymerch.com/en",driver.getCurrentUrl());

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
        driver.navigate().to("https://egymerch.com/en/login");

    }





}
