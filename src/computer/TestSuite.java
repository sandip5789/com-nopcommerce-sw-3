package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {

    String baseUrl = "https://demo.nopcommerce.com/";

    // Individual open and close
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1.Test name verifyProductArrangeInAlphaBaticalOrder()
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        // 1.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        // 1.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        // 1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//span[normalize-space()='Sort by']"));
        sortByPosition(By.xpath("//option[normalize-space()='Name: Z to A']"), "Name: Z to A");
        Thread.sleep(2000);
        // 1.4 Verify the Product will arrange in Descending order
        boolean ans = verifyTheListIsDecendingOrder(By.xpath("//h2[@class='product-title']"));
        Assert.assertEquals(false, ans);

    }

    // 2. Test name verifyProductAddedToShoppingCartSuccessFully()
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        // 2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        // 2.2 Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        // 2.3 Select Sort By position "Name: A to Z"
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        sortByPosition(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        // 2.4 Click on "Add To Cart"
        //clickOnElement("");
        clickOnElement(By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]"));
        Thread.sleep(2000);
        // 2.5 Verify the Text "Build your own computer"
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Build your own computer']"), "Build your own computer");
        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        // 2.7.Select "8GB [+$60.00]" using Select class
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        // 2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_3_7']"));
        // 2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander +$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));
        // 2.11 Verify the price "$1,475.00"
        //Thread.sleep(2000);
        // verifyTheStringMessage(By.xpath("//div[@class='product-price']"),"$1,475.00"); // price keep changing
        // 2.12 Click on "ADD TO CARD" Button
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        //After that close the bar clicking on the cross button
        verifyTheStringMessage(By.xpath("//p[@class='content']"), "The product has been added to your shopping cart");
        clickOnElement(By.xpath("//span[@title='Close']"));
        // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        mouseHoverToElementAndClick(By.xpath("//button[normalize-space()='Go to cart']"));
        // 2.15 Verify the message "Shopping cart"
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Shopping cart']"), "Shopping cart");
        // 2.16 Change the Qty to "2" and Click on "Update shopping cart"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//td[@class='quantity']/child::input"));
        driver.findElement(By.xpath("//td[@class='quantity']/child::input")).clear();
        sendTextToElement(By.xpath("//td[@class='quantity']/child::input"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        // 2.17 Verify the Total"$2,950.00"
        verifyTheStringMessage(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"), "$2,950.00");
        // 2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // 2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.20 Verify the Text “Welcome, Please Sign In!”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"), "Welcome, Please Sign In!");
        // 2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));
        // 2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Virat ");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Kohli");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "virat1234@gmail.com");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "India");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Delhi");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "Chandni Chowk");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "380012");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "912345678");
        // 2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        // 2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//li[@id='opc-shipping_method']//li[2]//div[1]"));
        // 2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        // 2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        // 2.27 Select “Master card” From Select credit card dropdown
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");
        // 2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Virat Kohli");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5100080000000000");
        Thread.sleep(2000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"),"4");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2026");
        selectByVisibleTextFromDropDown(By.xpath("//input[@id='CardCode']"), "123");
        // 2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        // 2.30 Verify “Payment Method” is “Credit Card”
        verifyTheStringMessage(By.xpath("//span[normalize-space()='Credit Card']"), "Payment Method");
        // 2.32 Verify “Shipping Method” is “Next Day Air”
        verifyTheStringMessage(By.xpath("//span[normalize-space()='Next Day Air']"), "Shipping Method");
        // 2.33 Verify Total is “$2,950.00”
        verifyTheStringMessage(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')]"), "Total:");
        // 2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        // 2.35 Verify the Text “Thank You”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Thank you']"),"Thank you");
        // 2.36 Verify the message “Your order has been successfully processed!”
        verifyTheStringMessage(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"),"Your order has been successfully processed!");
        // 2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        // 2.37 Verify the text “Welcome to our store”
        verifyTheStringMessage(By.xpath("//h2[normalize-space()='Welcome to our store']"),"Welcome to our store");

    }
    @After
    public void tearDown() {
        closeBrowser();
    }

}