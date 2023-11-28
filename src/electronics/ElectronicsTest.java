package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import java.util.Random;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1. Test name verifyUserShouldNavigateToCellPhonesPageSuccessfully
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // 1.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        // 1.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Cell phones ']"));
        // 1.3 Verify the text “Cell phones”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");

    }

    // 2. Test name verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        // 2.1 Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        // 2.2 Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Cell phones ']"));
        // 2.3 Verify the text “Cell phones”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Cell phones']"), "Cell phones");
        // 2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[normalize-space()='List']"));
        // 2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        // 2.6 Verify the text “Nokia Lumia 1020”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Nokia Lumia 1020']"), "Nokia Lumia 1020");
        // 2.7 Verify the price “$349.00”
        verifyTheStringMessage(By.xpath("//span[@id='price-value-20']"),"$349.00");
        // 2.8 Change quantity to 2
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        clickOnElement(By.xpath("//input[@id='product_enteredQuantity_20']"));
        // 2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        // 2.10 Verify the Message "The product has been added to your shopping cart" on Top green Ba
        verifyTheStringMessage(By.xpath("//p[@class='content']"),"The product has been added to your shopping cart");
        // After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
        Thread.sleep(2000);
        // 2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElementAndClick(By.xpath("//span[@class='cart-label']"));
        // 2.12 Verify the message "Shopping cart"
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Shopping cart']"),"Shopping cart");
        Thread.sleep(2000);
        // 2.13 Verify the quantity is 2
        //verifyTheStringMessage(By.id("itemquantity11221"),"2");
        // 2.14 Verify the Total $698.00
        verifyTheStringMessage(By.xpath("//span[@class='product-subtotal']"),"$698.00");
        // 2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // 2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // 2.17 Verify the Text “Welcome, Please Sign In!”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"),"Welcome, Please Sign In!");
        // 2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[normalize-space()='Register']"));
        // 2.19 Verify the text “Register”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Register']"),"Register");
        // 2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElement(By.id("FirstName"),"Rohit");
        sendTextToElement(By.id("LastName"),"Sharma");
        sendTextToElement(By.name("DateOfBirthDay"),"12");
        sendTextToElement(By.name("DateOfBirthMonth"),"April");
        sendTextToElement(By.name("DateOfBirthYear"),"1989");
        Random random = new Random(); // Random email generator
        String email = "shane" + random.nextInt() + "@gmail.com";
        sendTextToElement(By.id("Email"),"rohit1234@gmial.com");
        sendTextToElement(By.id("Password"),"hit123");
        sendTextToElement(By.id("ConfirmPassword"),"hit123");
        // 2.21 Click on “REGISTER”Button
        clickOnElement(By.id("register-button"));
        // 2.22 Verify the message “Your registration completed”
        verifyTheStringMessage(By.xpath("//div[@class='result']"),"Your registration completed");
        // 2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        // 2.24 Verify the text “Shopping card”
        verifyTheStringMessage(By.xpath("//h1[normalize-space()='Shopping cart']"),"Shopping cart");
        // 2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        // 2.26 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        // 2.27 Fill the Mandatory fields
        sendTextToElement(By.id("BillingNewAddress.FirstName"),"Rohit");
        sendTextToElement(By.id("BillingNewAddress_LastName"),"Sharma");
        sendTextToElement(By.id("BillingNewAddress_Email"),"rohit1234@gmial.com");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"),"India");
        sendTextToElement(By.id("BillingNewAddress_City"),"Mumbai");
        sendTextToElement(By.id("BillingNewAddress_Address1"),"Fashion Strret");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"),"380014");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"),"9142566885");
        // 2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        // 2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        // 2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        // 2.31 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        // 2.32 Select “Visa” From Select credit card dropdown
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));
        // 2.33 Fill all the details
        sendTextToElement(By.id("CardholderName"),"pin");
        sendKeysToElement(By.id("CardNumber"),"4917484589897208");
        selectByIndexFromDropDown(By.id("ExpireYear"),2);
        sendTextToElement(By.id("CardCode"),"123");
        // 2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));
        // 2.35 Verify “Payment Method” is “Credit Card”
        verifyText("Credit Card", By.xpath("//li[@class='payment-method']/span[2]"), "Credit card validation");
        // 2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyText("2nd Day Air", By.xpath("//li[@class='shipping-method']/span[2]"), "Shipping method validation");
        // 2.37 Verify Total is “$698.00”
        verifyText("$698.00", By.xpath("//td[@class='subtotal']/span"), "Amount validation");
        // 2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));
        // 2.39 Verify the Text “Thank You”
        verifyText("Thank you", By.xpath("//div[@class='page checkout-page order-completed-page']/div[1]/h1"), "Thank you text validation");
        // 2.40 Verify the message “Your order has been successfully processed!”
        verifyText("Your order has been successfully processed!", By.xpath("//div[@class='page checkout-page order-completed-page']/div[2]/div/div[1]"), "yoru order has been successfully processed");
        // 2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//div[@class='section order-completed']/div[3]/button"));
        // 2.42 Verify the text “Welcome to our store”
        verifyText("Welcome to our store", By.xpath("//div[@class='topic-block-title']/h2"), "Welcome to store text");
        // 2.43 Click on “Logout” link
        clickOnElement(By.xpath("//div[@class='header-links']/ul/li[2]"));
        // 2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demo.nopcommerce.com/";
        Assert.assertEquals(actualUrl, expectedUrl);

    }
    @After
    public void teardown() {
        closeBrowser();
    }
}
