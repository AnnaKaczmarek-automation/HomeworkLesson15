import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BlousesPage;
import pages.HomePage;
import pages.ProductPage;

public class AutomationPractiseTest extends TestBase {
    protected HomePage homePage;
    protected BlousesPage blousesPage;
    protected ProductPage productPage;
    Logger log = LoggerFactory.getLogger("AutomationPractiseTest");

    @Test
    public void hoverOnElementTest() {
        homePage = new HomePage(driver);
        blousesPage = new BlousesPage(driver);
        productPage = new ProductPage(driver);

        basePage.mouseHover(homePage.getWomenBtn());
        log.info("**** Mouse hovered on Women category *****");
        homePage.mouseHover(homePage.getBlousesCategory());
        log.info("**** Mouse hovered on Blouses category *****");
        basePage.clickOnElement(homePage.getBlousesCategory());
        log.info("**** Blouses category is opened *****");
        basePage.clickOnElement(blousesPage.getBlouse());
        log.info("**** Blouses product page is opened *****");
        WebElement displayedPicture = productPage.getBigPicture();
        String initialPictureSrc = displayedPicture.getAttribute("src");
        basePage.highlightElements(productPage.getSmallPicture1());
        basePage.mouseHover(productPage.getSmallPicture1());
        String srcAfterHover = productPage.getBigPicture().getAttribute("src");
        Assert.assertNotEquals(initialPictureSrc, srcAfterHover);
        log.info("**** Big picture was changed after hover on miniature *****");
        basePage.highlightElements(productPage.getSmallPicture2());
        basePage.mouseHover(productPage.getSmallPicture2());
        String srcSecondHover = productPage.getBigPicture().getAttribute("src");
        Assert.assertNotEquals(srcAfterHover, srcSecondHover);
        log.info("**** Big picture was changed after hover on second miniature *****");
        basePage.highlightElements(productPage.getSmallPicture3());
        basePage.mouseHover(productPage.getSmallPicture3());
        String srcThirdHover = productPage.getBigPicture().getAttribute("src");
        Assert.assertNotEquals(srcSecondHover, srcThirdHover);
        log.info("**** Big picture was changed after hover on third miniature *****");
    }
}
