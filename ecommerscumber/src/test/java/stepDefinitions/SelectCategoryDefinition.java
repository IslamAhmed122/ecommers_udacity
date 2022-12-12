package stepDefinitions;

import Pages.SearchPage;
import Pages.SelectCategoryPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Locale;

public class SelectCategoryDefinition {


    WebDriver driver =null ;
    SelectCategoryPage select;

    @Given("user open browser to select category")
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

    @And("user navigates to home page to select category")
    public void user_navigates(){
        driver.navigate().to("https://egymerch.com/en");

    }

    @Then("user click on category button")
    public void click_onCategoryButton() throws InterruptedException {
        select = new SelectCategoryPage(driver);
        select.click_select();
        Thread.sleep(1000);
    }

    @And("user click on category Sweatshirts button")
    public void click_onSweatshirtsButton() throws InterruptedException {
        select = new SelectCategoryPage(driver);
        select.click_Sweatshirts();
        Thread.sleep(1000);
    }
    @And("user can select neu product")
    public void click_onSweatshirtsButtonToSelected() throws InterruptedException {

        select.select_Sweatshirts();
        Thread.sleep(1000);
    }

    @And("user can select neu product to can show")
    public void select_productToShow() throws InterruptedException {

        select.select_neuSweatshirts();
        Thread.sleep(1000);
    }

    @And("user can select color")
    public void select_color() throws InterruptedException {

        select. select_color();
        Thread.sleep(1000);
    }

    @And("user can select size")
    public void select_size() throws InterruptedException {

        select.select_size();
        Thread.sleep(1000);
    }
    @And("user can select design ")
    public void click_select_design() throws InterruptedException {

        select.button_addToCart();
        Thread.sleep(1000);
    }

    @And("user can click on add to cart button ")
    public void click_add_toCart() throws InterruptedException {

        select.button_selectDesigns();
        Thread.sleep(1000);
    }

    @Then("^he is redirected to \"(.*)\" page$")
    public void redirect(String category)
    {
        String expectedUrl = "https://egymerch.com/en"+category.toLowerCase(Locale.ROOT);
        String actualUrl = this.driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @After("@category")
    public void afterCategory()
    {
        this.driver.quit();
    }




}
