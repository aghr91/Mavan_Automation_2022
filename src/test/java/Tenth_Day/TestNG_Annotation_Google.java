package Tenth_Day;

import All_Reusable_Methods.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestNG_Annotation_Google {
    //declare the web driver OutSide  the annotation methods So it can be called on all the methods
    WebDriver driver;

    @BeforeSuite
    public void SetTheDriver(){
        driver = Reusable_Actions.setDriver();
    }//end of precondition

    @Test
    public void googleSearchLoop(){
        ArrayList<String > cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Tesla");

        for(int i = 0; i < cars.size(); i++){
            //navigating to google
            driver.navigate().to("https://www.google.com");
            //entering a unique keyword from array list
            Reusable_Actions.sendKeysMethod(driver,"//*[@name='q']",cars.get(i),"Search Field");



        }


    }//end of test

    @AfterSuite
    public void endSession() {
        driver.quit();
    }
}//end of testNG
/*
Navigate the best buy website
Title Matches
Clicking on element remove popUp
Typing on element hp laptop
Submitting on element Submit Button
Clicking on element Add to Cart
Clicking on element Go to Cart
Clicking on element CheckOut
Clicking on element Continue as Guest
Typing on element firstName
Typing on element last name
Typing on element Address
Typing on element enter city
selecting select State
Typing on element zipcode
Typing on element enter email address
Typing on element enter phone number
Clicking on element Continue to Payment Information


 */
