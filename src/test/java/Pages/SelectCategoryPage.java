package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectCategoryPage {


    WebDriver driver;

    public SelectCategoryPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "i[class=\"fi-rs-angle-down\"]")
    WebElement selectCategory;

    @FindBy(css = "a[href=\"https://egymerch.com/shop?category_id=19\"]")
    WebElement Sweatshirts;

    @FindBy(css="h2[style=\"min-height:38px;\"]")
    WebElement selectPF;

    @FindBy(css = "div[class=\"custom_product_data text-start p-2\"]")
    WebElement  selectNeuPF;

    @FindBy(css = "span[class=\"color_span btn btn-sm p-3\"]")
    WebElement selectColorPF;

    @FindBy(css = "span[data-size=\"L\"]")
    WebElement selectSizePF;


    @FindBy(id="add_custom_item")
    WebElement addToCartButton;

    @FindBy(css = "img[src=\"https://egymerch.s3.eu-west-3.amazonaws.com/library_designs_thumbs/%D9%86%D8%A7%D8%AF%D9%8A-%D8%A7%D9%84%D8%A7%D9%87%D9%84%D9%8A-bV70.png\"]")
    WebElement selectDesigns;

    @FindBy(css="a[href=\"https://egymerch.com/en/checkout\"]")
    WebElement checkout;




    public void click_select(){
        selectCategory.click();
    }
    public void click_Sweatshirts(){
        Sweatshirts.click();
    }

    public void select_Sweatshirts(){
        selectPF.click();
    }
    public void select_neuSweatshirts(){
        selectNeuPF.click();
    }

    public void select_color(){
        selectColorPF.click();
    }

    public void select_size(){
        selectSizePF.click();
    }
    public void button_addToCart(){
        addToCartButton.click();
    }
    public void button_selectDesigns(){
        selectDesigns.click();
    }
    public void button_checkout(){
        checkout.click();
    }
}
