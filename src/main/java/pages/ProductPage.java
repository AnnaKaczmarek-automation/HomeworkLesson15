package pages;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    Logger log = LoggerFactory.getLogger("ProductPage.class");

    @FindBy(css = "#bigpic")
    private WebElement bigPicture;

    @FindBy(css = "#thumbs_list_frame li")
    private List<WebElement> miniatureList;

    public WebElement getBigPicture() {
        return  bigPicture;
    }

    public void compareWithMiniature(WebElement bigPicture){

        SoftAssertions softAssertions = new SoftAssertions();
        for (WebElement miniature : miniatureList) {
            String srcBeforeHover = bigPicture.getAttribute("src");
            mouseHover(miniature);
            String srcAfterHover = bigPicture.getAttribute("src");
            softAssertions.assertThat(srcAfterHover).isNotEqualTo(srcBeforeHover);
        }
        softAssertions.assertAll();
        log.info("**** Big picture was correctly changed after hover on miniature *****");
    }


}
