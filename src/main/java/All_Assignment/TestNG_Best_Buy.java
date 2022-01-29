package All_Assignment;

import All_Reusable_Methods.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_Best_Buy {
    //declare the web driver outside the annotation methods So it can be called on all the methods
    WebDriver driver;

    @BeforeSuite
    public void SetTheDriver() {
        driver = Reusable_Actions.setDriver();
        //navigate best buy page
        System.out.println("Navigate the best buy website");
        driver.navigate().to("https://www.bestbuy.com");
        driver.manage().deleteAllCookies();
    }//end of preCondition

    @Test(priority = 1)
    public void buyLaptop() throws InterruptedException {
        //verify the best buy page title
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Best Buy | Official Online Store | Shop Now & Save")) {
            System.out.println("Title Matches");
        } else {
            System.out.println("Title does not match.Actual title is " + actualTitle);
        }//end of verify page title

        // Thread.sleep(2000);

        //remove PopUp
        Reusable_Actions.click_popUp(driver, "//*[@aria-label='Close']", "remove popUp");

        //click on search Field and enter keyword
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='gh-search-input']", "hp laptop", "hp laptop");

        //submit
        Reusable_Actions.submitMethod(driver, "//*[@class='header-search-button']", "Submit Button");

        //click on add to cart
        Reusable_Actions.clickMethod(driver, "//*[text()='Add to Cart']", "Add to Cart");
        //click on Go to Cart
        Reusable_Actions.clickMethod(driver, "//*[text()='Go to Cart']", "Go to Cart");
        //click on CheckOut
        Reusable_Actions.clickMethod(driver, "//button[contains(text(),'Checkout')]", "CheckOut");
        //click on Continue as Guest
        Reusable_Actions.clickMethod(driver, "//button[contains(text(),'Continue as Guest')]", "Continue as Guest");
        Thread.sleep(3000);
    }//@test 1

    @Test(dependsOnMethods = "buyLaptop")
    public void ShippingAddress() {
        //enter First Name
        Reusable_Actions.sendKeysMethod(driver, "//input[@id='firstName']", "Alamgir", "firstName");
        //enter last name
        Reusable_Actions.sendKeysMethod(driver, "//input[@id='lastName']", "Hossain", "last name");
        //enter house Address
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='street']", "2911 Brighton 5th St", "Address");
        //enter city name
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='city']", "Brooklyn", "enter city");
        //select state from drop down
        Reusable_Actions.dropDownMenu(driver, "//*[@id='state']", "NY", " select State ");

        //enter zipcode
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='zipcode']", "11235", "zipcode");
        //enter email
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='user.emailAddress']", "haghr91@gmail.com", "enter email address");
        //enter phone number
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='user.phone']", "9292933737", "enter phone number");
        //click on Continue to Payment Information
        Reusable_Actions.clickMethod(driver, "//*[contains(text(),'Continue to Payment Information')]", "Continue to Payment Information");


    }//end @test 2


    @AfterSuite
    public void CloseSession() {
        driver.quit();
    }


}//end of TestNG_Best_Buy
