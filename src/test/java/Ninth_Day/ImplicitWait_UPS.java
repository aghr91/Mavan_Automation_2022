package Ninth_Day;

import All_Reusable_Methods.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ImplicitWait_UPS {
    public static void main(String[] args) {
       WebDriver driver = Reusable_Actions.setDriver();

//declare and define your global implicit wait for all web elements
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //navigate to usps
        driver.navigate().to("https://www.ups.com/us/en/Home.page");
        //Thread.sleep(2000);
        //click on Track
        driver.findElement(By.xpath("//*[text()='Tracking']")).click();
        //click on track a package
        driver.findElement(By.xpath("//*[text()='Track a Package']")).click();


    }//end of main method
}//end of java class
