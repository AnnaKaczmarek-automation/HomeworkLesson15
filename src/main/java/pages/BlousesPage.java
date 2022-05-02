package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlousesPage extends BasePage{
    public BlousesPage(WebDriver driver) {
        super(driver);
    }

    Logger log = LoggerFactory.getLogger("BlousesPage.class");

    @FindBy(css = ".left-block .product-image-container")
    private WebElement blousePicture;

    @FindBy(css = ".button.lnk_view.btn.btn-default")
    private WebElement moreBtn;

    public WebElement getMoreBtn() {
        return moreBtn;
    }

    public WebElement getBlousePicture() {
        return blousePicture;
    }

    public void openBlousesProductPage(){
        mouseHover(getBlousePicture());
        clickOnElement(getMoreBtn());
        log.info("**** Blouses product page is opened *****");
    }
}
