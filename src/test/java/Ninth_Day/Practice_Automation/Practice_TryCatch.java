package Ninth_Day.Practice_Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Practice_TryCatch {
    public static void main(String[] args) throws InterruptedException {
        //set the web driver manager
        WebDriverManager.chromedriver().setup();
        //define the chrome option before set web driver
        ChromeOptions options = new ChromeOptions();
        //set up the maximized and incognito mode
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        // set the web driver
        WebDriver driver = new ChromeDriver(options);

        //navigate web page as my needed
        driver.navigate().to("http://www.mlcalc.com");
        Thread.sleep(2000);

        //using try and catch

        //enter purchase price after clear the search field
       try {
           WebElement pPrice = driver.findElement(By.xpath("//*[@id='ma']"));
           pPrice.clear();
           pPrice.sendKeys("7500000");
       }catch (Exception error){
           System.out.println("Unable to enter purchase price " + error);

       }//end of purchase price

        Thread.sleep(1500);

        //enter down payment
        try {
           WebElement dPayment = driver.findElement(By.xpath("//*[@id='dp']"));
           dPayment.clear();
           dPayment.sendKeys("50");
        }catch (Exception error){
            System.out.println(" Unable to enter down payment " + error);

        }//end of down payment

        //click on show advanced options
        try {
            driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        }catch (Exception error){
            System.out.println(" Unable to click on show advanced options");
        }//end of Show advanced button
        Thread.sleep(2000);

        //enter the month
        try {
            WebElement sMonth = driver.findElement(By.xpath("//*[@name ='sm']"));
            Select sMonthDrpDown = new Select(sMonth);
            sMonthDrpDown.selectByVisibleText("Jul");

        }catch (Exception error){
            System.out.println("Unable to enter month on search field " + error);

        }//end of enter month section

        Thread.sleep(1000);

        //select year from drop down list
        try {
            WebElement sYear = driver.findElement(By.xpath("//*[@name ='sy']"));
            Select sYearDrpDown = new Select(sYear);
            sYearDrpDown.selectByVisibleText("2024");

        }catch (Exception error){
            System.out.println("Unable to Select year from drop down list  " + error);

        }//end of enter year
        //click on calculate button
        try {
           driver.findElement(By.xpath("//*[@value ='Calculate']")).click();


        }catch (Exception error){
            System.out.println("Unable to click on calculate button  " + error);

        }//end of click calculate

        //capture monthly payment
         try {
             System.out.println(" capturing monthly ");

            String mntPayment = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(1).getText();
             System.out.println("My monthly payment is " + mntPayment);
        }catch (Exception error){
            System.out.println(" Unable to capture on monthly payment " + error);

        }//end of down payment





    }// end of main method
}//end of java class
