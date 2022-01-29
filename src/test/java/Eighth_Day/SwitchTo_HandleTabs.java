package Eighth_Day;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class SwitchTo_HandleTabs {
    public static void main(String[] args) throws InterruptedException {
        //call the web\driver manager
        WebDriverManager.chromedriver().setup();
        //call chrome options
        ChromeOptions options = new ChromeOptions();
        //set incognito and maximize the driver
        options.addArguments("start-maximized");
        //options.addArguments("incognito");
        //set my web driver
        WebDriver driver = new ChromeDriver(options);



       //navigate to UHC
        driver.navigate().to("https://www.uhc.com");
        Thread.sleep(2500);
        //click on find a doctor
        driver.findElement(By.xpath("//*[text()='Find a doctor']")).click();





        //close dismiss button
        //driver.findElement(By.xpath("//*[contains(text(),'expoBtnClose')]")).click();
       // Thread.sleep(3000);
        //click on select your plan dropdown and choose medicare as value
        driver.findElement(By.xpath("//*[contains(text(),'Select your plan to sign in')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Medicare plan']")).click();

        //to switch to new tab use arraylist
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //switch to new tab
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2500);
        //click on dismiss
       // driver.findElement(By.xpath("//*[@id='alert-sticky__dismiss-button']")).click();
       // Thread.sleep(1000);
        //click on Sign In
        driver.findElement(By.xpath("//*[text()='Sign In']")).click();



    }//end main method
}//end java class
/*
Title does not match.Actual title is Express - Men's & Women's Clothing
Hovering on element Hover on Women Tab
Clicking on element Dress link
 scroll the page
Clicking on element selectDress
 scroll the page
Clicking on element Add to Bag
Clicking on element View Bag
Clicking on element select Quantity
Clicking on element PopupAppear
Pop up didn't appear. proceeding to next step
Clicking on element continue-to-checkout
Clicking on element Checkout as Guest
Typing on element Enter First Name
Typing on element Enter last Name
Typing on element Enter Email Address
Typing on element ReEnter Email Address
Typing on element Enter Phone Number
Clicking on element Continue button
Typing on element Shipping Address
Typing on element Enter postal code
Typing on element enter city
Clicking on element select State
Clicking on element Continue
Clicking on element Delivery Options continue
Typing on element Enter credit card number
Clicking on element select Expire Month
Clicking on element select Expire Year
Typing on element Enter Cvv security code
Clicking on element pop up appear
Pop up didn't appear. proceeding to next step
Clicking on element Place Order
Capturing text on element
Unable to capture text on  Error:org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of Proxy element for: DefaultElementLocator 'By.xpath: //div[@id='rvn-note-NaN']' (tried for 15 second(s) with 500 milliseconds interval)
log4j:WARN No app

 */
