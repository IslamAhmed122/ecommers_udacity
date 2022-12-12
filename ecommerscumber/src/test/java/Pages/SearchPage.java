package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;

    public SearchPage (WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }
    public WebElement getElementByPath(String elem)
    {

        return this.driver.findElement(By.xpath(elem));
    }



    @FindBy(css = "input[type=\"text\"]")
    WebElement searchPF;


    public void search_method( String searchWord ){
        searchPF.sendKeys(searchWord);

    }
    public void search_button(){
        searchPF.sendKeys(Keys.ENTER);
    }
}
