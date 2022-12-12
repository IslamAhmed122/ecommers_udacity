package stepDefinitions;
import Pages.loginPage;
import io.cucumber.java.After;
import org.junit.Assert;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @Then("he gets redirected to home page as authenticated user")
    public void validLogin() throws InterruptedException {
        login.getElementByPath("//*[@id=\"login-seller\"]").click();
        Thread.sleep(1000);
        String expectedURL = "https://egymerch.com/en";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue("Not expected url",actualURL.contains(expectedURL));
        WebElement logoutBtn = login.getElementByPartialText("Log out");
        Assert.assertTrue("Not auth user",logoutBtn!=null);

    }

    @Then("he stays on the same page and error messeges for invalid login appear")
    public void invalidLogin() throws InterruptedException, NoSuchElementException {
        login.getElementByPath("//*[@id=\"login-seller\"]").click();
        Thread.sleep(1000);
        String expectedURL = "https://egymerch.com/en/login";
        String actualURL = driver.getCurrentUrl();
        Assert.assertTrue("Not expected url",actualURL.contains(expectedURL));
        String actualMsg = driver.getCurrentUrl();
        String expectedMsg = "Login was unsuccessful";
        Assert.assertTrue("Error in warning msg",actualMsg.contains(expectedMsg));

    }
    @After("@login")
    public void afterLogin()
    {
        this.driver.quit();
    }

}








