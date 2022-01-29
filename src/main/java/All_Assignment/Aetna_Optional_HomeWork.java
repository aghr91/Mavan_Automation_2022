package All_Assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class Aetna_Optional_HomeWork {
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
        //create Array list for milesRange
        /*ArrayList<Integer> milesRange  = new ArrayList<>();
        milesRange.add(40);
        milesRange.add(35);
        milesRange.add(45);*/

        //using for loop for iterate 3 times zipcode
        for (int i = 0; i< zipcode.size(); i++) {

            //navigate the Aetna home page
            driver.navigate().to("https://www.aetna.com");
            Thread.sleep(1000);

            //verify home page tittle
            String actualTittle = driver.getTitle();

            if (actualTittle.contains("Health Insurance Plans")) {
                System.out.println("Tittle matches");
            } else {
                System.out.println("Tittle does not match. Actual tittle is " + actualTittle);
            }//end verify page tittle
            Thread.sleep(1000);

            //click on shop for a plan
            driver.findElement(By.xpath("//*[text()='Shop for a plan']")).click();
            System.out.println("click on shop for a plan");
            Thread.sleep(2000);


            //declare mouse actions command
            Actions action = new Actions(driver);
            //click on medicare link
            System.out.println("click on medicare link");
            WebElement Link = driver.findElement(By.xpath("//*[text()='Medicare']"));
            action.moveToElement(Link).perform();

            //click on find a doctor
            WebElement findLink = driver.findElement(By.xpath("//*[@data-analytics-name='Find a doctor']"));
            action.moveToElement(findLink).click().perform();
            Thread.sleep(2000);

            //click on 2021 medicare plans
            driver.findElement(By.xpath("//span[contains(text(),'2021 Medicare plans you purchase yourself')]")).click();
            System.out.println("click on 2021 medicare plans you purchase yourself");
            Thread.sleep(2000);

            //click on search field and enter zipcode
            System.out.println("clear and enter zipcode");
            WebElement enterZip = driver.findElement(By.xpath("//*[@id='medZip']"));
            enterZip.clear();
            enterZip.sendKeys("11235");
            Thread.sleep(2000);

            //select zipcode from suggest
            System.out.println("select zipcode from view");
            driver.findElement(By.xpath("//*[@class='typeahead_grouping active']")).click();
            Thread.sleep(2000);

            //click skip selection
            System.out.println("click on skip protection");
            driver.findElement(By.xpath("//*[contains(text(),'Skip plan selection')]")).click();
            Thread.sleep(2000);


            //scroll page all the way down
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //scroll to the view by pixels
            jse.executeScript("scroll(0,300)");
            System.out.println("scroll the page");
            Thread.sleep(2000);

            //click on medical doctors and sp
            System.out.println("click on medical doctors and sp ");
            driver.findElement(By.xpath("//*[contains(text(),'Medical Doctors & Specialists')]")).click();
            Thread.sleep(1000);

            //click on primary doctors
            System.out.println("click on primary doctors");
            driver.findElement(By.xpath("//*[contains(text(),'Doctors (Primary Care)')]")).click();
            Thread.sleep(1000);

            //click on all  primary care physician
            System.out.println("click on all  primary care physician");
            driver.findElement(By.xpath("//*[@class='dummyLinkLabel']")).click();
            Thread.sleep(3000);
            //scroll page as my need
            JavascriptExecutor Ajse = (JavascriptExecutor) driver;
            //scroll to the view by pixels
            Ajse.executeScript("scroll(0,200)");
            System.out.println("scroll the page");
            Thread.sleep(2000);

            //capture the result for doctors details

            try {
                System.out.println(" capturing the doctors information ");
                String information = driver.findElement(By.xpath("//*[text()='AM Nephrology Care, PC']")).getText();
                String city = driver.findElement(By.xpath("//*[@class='mobileFont14px dataGridPadding']")).getText();
                System.out.println("  capturing the doctors information is " + information + " " + city);
            } catch (Exception e) {
                System.out.println(" Unable to capturing the doctors information " + e);

            }//end of schedule text

        }//end of for loop
        driver.quit();











    }//end of main method
 }//end of java class
