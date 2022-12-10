package stepDefinitions;

import Pages.SelectCategoryPage;
import Pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCartDefinition {

    WebDriver driver =null ;
    loginPage login;
    SelectCategoryPage select;

    @Given("user open browser to add to cart")
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

    @And("user navigates to login page to make order")
    public void user_navigates(){
        driver.navigate().to("https://egymerch.com/en/login");

    }

    @When("^user enter user and password to go to has account \"(.*)\" and \"(.*)\"$")
    public void valid_data(String email, String password){
        login = new loginPage(driver);

        login.LoginSteps(email,password);


    }

    @And("user click in login button to has account")
    public void login_button() throws InterruptedException {
        Thread.sleep(1000);
        login.clickEnter();
        Thread.sleep(1000);

    }
    @And("user navigates to home page to shopping")
    public void user_navigatesToHomePage() {
        driver.navigate().to("https://egymerch.com/en");
    }
    @Then("user click on category button to add to cart")
    public void click_onCategoryButtonToAddCart() throws InterruptedException {
        select = new SelectCategoryPage(driver);
        select.click_select();
        Thread.sleep(1000);
    }

    @And("user click on category Sweatshirts button to add to cart")
    public void click_onSweatshirtsButtonToAddCart() throws InterruptedException {
        select = new SelectCategoryPage(driver);
        select.click_Sweatshirts();
        Thread.sleep(1000);
    }
    @And("user can select neu product to add to cart")
    public void click_onSweatshirtsButtonToSelected_ToAddCart() throws InterruptedException {

        select.select_Sweatshirts();
        Thread.sleep(1000);
    }

    @And("user can select neu product to can show to add to cart")
    public void select_productToShow_ToAddCart() throws InterruptedException {

        select.select_neuSweatshirts();
        Thread.sleep(1000);
    }

    @And("user can select color to add to cart")
    public void select_color_ToAddCart() throws InterruptedException {

        select. select_color();
        Thread.sleep(1000);
    }

    @And("user can select size to add to cart")
    public void select_size_ToAddCart() throws InterruptedException {

        select.select_size();
        Thread.sleep(1000);
    }
    @And("user can select design to add to cart")
    public void click_select_design_ToAddCart() throws InterruptedException {

        select.button_addToCart();
        Thread.sleep(1000);
    }

    @And("user can click on add to cart button to add to cart")
    public void click_add_toCart_ToAddCart() throws InterruptedException {

        select.button_selectDesigns();
        Thread.sleep(1000);
    }
    @And("user can click on add to cart button to add to cart")
    public void click_check_out_button() throws InterruptedException {

        select.button_checkout();
        Thread.sleep(1000);
    }






}
