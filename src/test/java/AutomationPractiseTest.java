import org.junit.jupiter.api.Test;
import pages.BlousesPage;
import pages.HomePage;
import pages.ProductPage;

public class AutomationPractiseTest extends TestBase {
    protected HomePage homePage;
    protected BlousesPage blousesPage;
    protected ProductPage productPage;

    @Test
    public void hoverOnElementTest(){
        homePage = new HomePage(driver);
        blousesPage = new BlousesPage(driver);
        productPage = new ProductPage(driver);

        homePage.openBlouseCategory();
        blousesPage.openBlousesProductPage();
        productPage.compareWithMiniature(productPage.getBigPicture(),productPage.getSmallPicture1());
        productPage.compareWithMiniature(productPage.getBigPicture(),productPage.getSmallPicture2());
        productPage.compareWithMiniature(productPage.getBigPicture(),productPage.getSmallPicture3());
    }
}
