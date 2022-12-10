package stepDefinitions;

import Pages.SearchPage;
import Pages.loginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchDefinition {



    WebDriver driver =null ;
    SearchPage search;

    @Given("user open browser to search")
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

    @And("user navigates to home page to search")
    public void user_navigates(){
        driver.navigate().to("https://egymerch.com/en");

    }

    @When("^send any valid word for search \"(.*)\"$")
    public void valid_data(String searchWord){
        search = new SearchPage(driver);

        search.search_method(searchWord);


    }

    @And("click or press enter to search")
    public void click_search (){
        search.search_button();

    }

}
