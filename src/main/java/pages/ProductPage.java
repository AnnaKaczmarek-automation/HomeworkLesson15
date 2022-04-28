package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#bigpic")
    private WebElement bigPicture;

    @FindBy(css = "#thumb_5")
    private WebElement smallPicture1;

    @FindBy(css = "#thumb_6")
    private WebElement smallPicture2;

    @FindBy(css = "#thumb_7")
    private WebElement smallPicture3;

    public WebElement getBigPicture() {
        return bigPicture;
    }

     public WebElement getSmallPicture1() {
        return smallPicture1;
    }

    public WebElement getSmallPicture2() {
        return smallPicture2;
    }

    public WebElement getSmallPicture3() {
        return smallPicture3;
    }
}
