package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    Logger log = LoggerFactory.getLogger("HomePage.class");

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[1]")
    private WebElement womenBtn;

    @FindBy(xpath = "//ul[@class='submenu-container clearfix first-in-line-xs']/li[1]/ul/li[2]/a")
    private WebElement blousesCategory;

    public WebElement getWomenBtn() {
        return womenBtn;
    }

    public WebElement getBlousesCategory() {
        return blousesCategory;
    }

    public void openBlouseCategory(){
        mouseHover(getWomenBtn());
        log.info("**** Mouse hovered on Women category *****");
        mouseHover(getBlousesCategory());
        log.info("**** Mouse hovered on Blouses category *****");
        clickOnElement(getBlousesCategory());
        log.info("**** Blouses category is opened *****");
    }
}
