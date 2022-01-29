package Ninth_Day;

import All_Reusable_Methods.Reusable_Actions;
import org.openqa.selenium.WebDriver;

public class UPS_reusableMethod {
    public static void main(String[] args) {




        WebDriver driver = Reusable_Actions.setDriver();

        //navigate to usps
        driver.navigate().to("https://www.ups.com/us/en/Home.page");

        //click on track using Reusable method
        Reusable_Actions.clickMethod(driver,"//*[text()='Tracking']","Track");

        //click on track package
        Reusable_Actions.clickMethod(driver,"//*[text()='Track a Package']"," Track a package");

        //enter any tracking number
        Reusable_Actions.sendKeysMethod(driver,"//*[@id='stApp_trackingNumber']","11232344533","Enter Tracking");

        //click on search button on track
        Reusable_Actions.clickMethod(driver,"//*[@id='stApp_btnTrack']","click on track button");

        //capture the error message and print out only 'We could not locate the shipment'
        String resultValue = Reusable_Actions.getTextMethod(driver,"//*[@id='stApp_error_alert_list0']","Error Message");
        //declare array and split
        String[] arrayResult = resultValue.split("details");
        System.out.println("My error info is " + arrayResult[0]);




    }//end of main method
}//end of java class
