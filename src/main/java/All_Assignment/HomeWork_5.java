package All_Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class HomeWork_5 {
    public static void main(String[] args) throws InterruptedException {

        //set the web driver manager
        WebDriverManager.chromedriver().setup();
        //define the chrome option before set web driver
        ChromeOptions options = new ChromeOptions();
        //set up the maximized and incognito mode
        options.addArguments("start-maximized");
        //options.addArguments("incognito");
        // set the web driver
        WebDriver driver = new ChromeDriver(options);


        //create Array list for zipcode
        ArrayList<String> zipcode = new ArrayList<>();
        zipcode.add("11235");
        zipcode.add("11228");
        zipcode.add("11218");

        //using for loop for iterate 3 times zipcode
        for (int i = 0; i< zipcode.size(); i++){

            //navigate the page
            try {
                driver.navigate().to("https://www.weightwatchers.com");
                System.out.println("navigate the weight watchers page");
            }catch (Exception e) {
                System.out.println(" Unable to navigate the weight watchers page " + e);
            }//end of navigate page
            Thread.sleep(2000);

            //click on attend
            try {
                driver.findElement(By.xpath("//*[@data-e2e-name='attend']")).click();
                System.out.println("click on attend ");
            }catch (Exception e) {
                System.out.println(" unable to click on attend " + e);

            }//end of click attend
            Thread.sleep(1000);

            //click on workshop
            try {
                driver.findElement(By.xpath("//*[@data-e2e-name='unlimited_workshops']")).click();
                System.out.println("click on find workshop");
            }catch (Exception e) {
                System.out.println("click on find workshop" +e);
            }//end of click workshop
            Thread.sleep(2000);


            //click on studio link
            try {
                driver.findElement(By.xpath("//*[text()='Studio']")).click();
                System.out.println("click on studio link");
            }catch (Exception e) {
                System.out.println(" unable to click on studio link" +e);
            }//end of click on studio link
            Thread.sleep(1500);

            //click on search field and enter zipcode
            try {
                System.out.println("enter zipcode in search field");
                WebElement searchZip = driver.findElement(By.xpath("//*[@id='location-search']"));
                searchZip.click();
                searchZip.sendKeys(zipcode.get(i));
                searchZip.submit();

            } catch (Exception e) {
                System.out.println(" Unable to enter zipcode " + e);
            }//end of enter zipcode

            Thread.sleep(2000);

            //click on multiples  link
            if (i == 0) {
                try {
                    System.out.println("click on second link");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(1).click();

                } catch (Exception e) {
                    System.out.println("Unable to click on second link " + e);
                }
            }else if (i == 1) {
                try {
                    System.out.println("click on  Third link");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(2).click();


                } catch (Exception e) {
                    System.out.println("Unable to click on Third link " + e );

                }
            }else if(i==2) {

                try {
                    System.out.println("click on first link");
                    driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']")).get(0).click();

                }catch (Exception e){
                    System.out.println("Unable to click on first link " + e );
                }
            }//end of multiple link
            Thread.sleep(2000);


            //capture the address
            try {
                System.out.println("capture the entire address");
                String address1 = driver.findElement(By.xpath("//*[@class='locationName-1jro_']")).getText();
                System.out.println(" print address " + address1);

                //String address2 = driver.findElement(By.xpath("//*[@class='address-3-YC0']")).getText();
                // System.out.println("My location is " + address1 + " " + address2);
            }catch (Exception e){
                System.out.println("unable to print address " + e);
            }//end of capture address

            //scroll page all the way down
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //scroll to the view by pixels
            jse.executeScript("scroll(0,1000)");
            System.out.println("scroll the page");
            Thread.sleep(2000);

            //capture the schedule of operation hours
            try {
                System.out.println(" capturing the operation hour ");
                String schedule = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
                System.out.println(" My schedule operation hours is " + schedule);
            }catch (Exception e){
                System.out.println(" Unable to capture schedule page " + e);
            }//end of schedule text














        }//end of for loop
        driver.quit();

    }//end of main method
}//end of java class
