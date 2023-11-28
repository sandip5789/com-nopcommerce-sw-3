package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * 1. create class "TopMenuTest"
 * 1.1 create method with name "selectMenu" it has one parameter name "menu" of type
 * string
 * 1.2 This method should click on the menu whatever name is passed as parameter.
 * 1.3. create the @Test method name verifyPageNavigation.use selectMenu method to
 * select the Menu and click on it and verify the page navigation.
 */
// 1. create class "TopMenuTest"
public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    // Individual open and close
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu) {
        // 1.2 This method should click on the menu whatever name is passed as parameter
        List<WebElement> selectMenu = driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li"));
        for (WebElement element : selectMenu) {
            if (element.getText().equalsIgnoreCase(menu)) {
                element.click();
                break;

            }

        }


    }

    // 1.3. create the @Test method name verifyPageNavigation.use selectMenu method
    // to select the Menu and click on it and verify the page navigation.
    @Test
    public void verifyPageNavigation() {
        selectMenu("Electronics");
        verifyTheStringMessage(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"),"Electronics");

    }
    // Individual open and close
    @After
    public void tearDown() {
        closeBrowser();
    }
}

