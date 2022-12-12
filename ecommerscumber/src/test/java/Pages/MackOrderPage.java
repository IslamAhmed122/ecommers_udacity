package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MackOrderPage {

    WebDriver driver;

    public MackOrderPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }
}
