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
import org.openqa.selenium.NoSuchElementException;
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
     public void rest_button(String email){
        forget.sendEmailButton(email);}


        @When("^user asks to reset with email \"(.*)\"$")
        public void resetEmail(String email) throws InterruptedException {
            forget.sendEmailButton(email);
            Thread.sleep(1000);
            forget.getElementByPath("/html/body/main/main/section/div/div/div/div/div[2]/div/div/form/div[2]/div/button").click();
        }
        @Then("\"Email with instructions has been sent to you\" is displayed")
        public void validReset()
        {

            try{
                String expectedResult = " تم ارسال ايميل لإعادة تعيين كلمة المرور \uD83D\uDC4C" ;
                String actualResult = forget.getElementByPath("/html/body/main/main/section/div/div/div[1]/div[1]/h4").getText();
                Assert.assertTrue(actualResult.contains(expectedResult));
            }catch(NoSuchElementException e)
            {
                System.out.println("Exception in valid login");
            }
        }

        @Then("\"Wrong Email\" is displayed")
        public void invalidReset()
        {

            try{
                String expectedResult = "Wrong email" ;
                String actualResult = forget.getElementByPath("/html/body/main/main/section/div/div/div/div/div[2]/div/div/form/div[1]/p").getText();
                Assert.assertTrue(actualResult.contains(expectedResult));
            }catch(NoSuchElementException e)
            {
                System.out.println("Exception in invalid login");
            }
        }



        @After("@Reset")
        public void afterReset()
        {
            this.driver.quit();
        }

    }
