package Ninth_Day.Practice_Automation;

import All_Reusable_Methods.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_UPS {
    WebDriver driver;
    //declare the web driver outside the annotation methods So it can be called on all the methods
    @BeforeSuite
    public void SetTheDriver(){
        driver= Reusable_Actions.setDriver();
        //navigate the ups website
        driver.navigate().to("https://www.ups.com/us/en/Home.page");

    }//end of precondition

    @Test(priority = 1)
    public void upsSearch() {
        //verify the UPS page title
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Global Shipping & Logistics Services")) {
            System.out.println("Title Matches");
        } else {
            System.out.println("Title does not match.Actual title is " + actualTitle);
        }//end of verify page title

        //click on tracking
        Reusable_Actions.clickMethod(driver, "//*[text()='Tracking']", "tracking");

        //click on track a package
        Reusable_Actions.clickMethod(driver, "//*[text()='Track a Package']", "Track a Package");

        //enter any tracking number
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='stApp_trackingNumber']", "12333333333", "Enter Tracking Number");

        //click on search button on track
        Reusable_Actions.clickMethod(driver, "//*[@id='stApp_btnTrack']", "Search Button");
    }//end test 1
        @Test(priority = 2)
        public void ErrorText(){
        //capture the invalid text
        String result = Reusable_Actions.getTextMethod(driver,"//*[@id='stApp_error_alert_list0']","Error Message");
        //System.out.println("My result is " + result);
        String[] arrayResult = result.split("details");
        System.out.println("result is " + arrayResult[0]);


    }//end of @Test 2

    @AfterSuite
    public void EndSession(){
        driver.quit();
    }



}//end of TestNG
