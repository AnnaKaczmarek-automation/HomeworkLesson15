package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlousesPage extends BasePage{
    public BlousesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".right-block h5 a")
    private WebElement blouse;

    public WebElement getBlouse(){
        return blouse;
    }
}
