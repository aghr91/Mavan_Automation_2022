package Ninth_Day.Practice_Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Practice_Handling_Tabs {
    public static void main(String[] args) throws InterruptedException {
        //set up the web driver manager
        WebDriverManager.chromedriver().setup();
        //set also chrome driver
        ChromeOptions options = new ChromeOptions();
        // set maximized and incognito mode in driver
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //set the web driver
        WebDriver driver = new ChromeDriver(options);

        //navigate uhc page
        driver.navigate().to("http://www.uhc.com");
        System.out.println("navigate the uhc page");
        Thread.sleep(2000);

        //click on find doctor
        driver.findElement(By.xpath("//*[@aria-label='Find a doctor']")).click();

        //scroll page until select plan
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,200)");
        System.out.println("scroll the page down");

        //select plan
        driver.findElement(By.xpath("//*[contains(text(),'Select your plan to sign in')]")).click();
        System.out.println("select plan about my needs");

        Thread.sleep(1500);
        //chose the plan
        driver.findElement(By.xpath("//*[text()='Medicare plan']")).click();
        System.out.println("chose medicare plan");
        Thread.sleep(2000);


        //For handling new switch tab using array list
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //get new tab use switch handle
        driver.switchTo().window(tabs.get(1));
        System.out.println("handling new tab");
        Thread.sleep(2000);

        //pop up dismiss
        driver.findElement(By.xpath("//*[@id='alert-sticky__dismiss-button']")).click();

        //
        driver.findElement(By.xpath("//*[contains(text(),'Register Now')]")).click();
        //Reusable_Actions.clickMethod(driver,"//*[contains(text(),'"+month.get(i)+"')]","month");
        //optionsMonth.click();
        // driver.findElement(By.xpath("//*[text()='January']")).click();

        // Reusable_Actions.dropDownMenu(driver,"//*[text(),January']",month,"click month");

        //select month from drop down
        //WebElement options=Reusable_Actions.dropDownMenu(driver, "//*[text()='January']", month.get(i), "select month");

       // @id='_next']
/*
Title does not match.Actual title is Stream TV and Movies Live and Online | Hulu
scroll the page
Clicking on element select button
Typing on element enter email
Typing on element enter password
Typing on element enter name
select month
Clicking on element Month field
Clicking on element Actual Month
Clicking on element click Day
Clicking on element Actual Day
Clicking on element click year
Clicking on element Actual Year
Clicking on element click Gender
Clicking on element Actual Gender
Clicking on element Continue
capturing text on element Subscription Amount
capture the subscription amount $6.99/mo
capturing text on element Total due today
capture the Total due amount is Total Due Today
$0.00
Title does not match.Actual title is Stream TV and Movies Live and Online | Hulu
scroll the page
Clicking on element select button
Typing on element enter email
Typing on element enter password
Typing on element enter name
select month
Clicking on element Month field
Clicking on element Actual Month
Clicking on element click Day
Clicking on element Actual Day
Clicking on element click year
Clicking on element Actual Year
Clicking on element click Gender
Clicking on element Actual Gender
Clicking on element Continue
capturing text on element Subscription Amount
capture the subscription amount $6.99/mo
capturing text on element Total due today
capture the Total due amount is Total Due Today
$0.00
 */



    }//end of main method
}//end of java class
