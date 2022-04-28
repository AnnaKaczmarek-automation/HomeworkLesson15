package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webListener.WebListener;

public class BasePage {
    protected WebDriverWait wait;
    protected Actions actions;
    protected WebDriver driver;
    private EventFiringMouse eventFiringMouse;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        actions = new Actions(driver);
    }

    public void clickOnElement(WebElement element) {
        waitUntilElementIsClickable(element);
        highlightElements(element);
        element.click();
    }
    public void waitUntilVisibilityOfElement(WebElement element) {
        highlightElements(element);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitUntilElementIsClickable(WebElement element){
        highlightElements(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void highlightElements(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red;')", element);
        try{
            Thread.sleep(1500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public void mouseHover(WebElement element){
        eventFiringMouse = new EventFiringMouse(driver, new WebListener());
        Locatable item = (Locatable)element;
        Coordinates coordinates = item.getCoordinates();
        eventFiringMouse.mouseMove(coordinates);
    }
}
