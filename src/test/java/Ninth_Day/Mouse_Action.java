package Ninth_Day;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Action {
    public static void main(String[] args) throws InterruptedException {

        //setup chrome driver
        WebDriverManager.chromedriver().setup();
        //declare and define the chrome options
        ChromeOptions options = new ChromeOptions();
        //declare all the arguments you need
        //to maximize my driver
        options.addArguments("start-maximized");
        //set as incognito mode
        options.addArguments("incognito");
        //set as headless(running the driver on background)
        //options.addArguments("headless");
        //define the web driver you are using
        WebDriver driver = new ChromeDriver(options);

        //navigate to usps
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(2000);

        //verify the welcome page title appears as expected
        String actualTitle = driver.getTitle();
        //by using if else to compare expected with actual title
        if(actualTitle.equals("Welcome | USPS")){
            System.out.println("Title matches " + actualTitle);
        } else {
            System.out.println("Title doesn't match. Actual title is " + actualTitle);
        }//end of verify the page title


        //declare mouse actions
        Actions mouseAction = new Actions(driver);

        //hover over tab to open up the dropdown list

        try {
            WebElement sendTab = driver.findElement(By.xpath("//*[text()='Send']"));
            mouseAction.moveToElement(sendTab).perform();
        }catch (Exception e){
            System.out.println("Unable hover over to send tab" + e);

        }//end of send tab

        //click to Look Up a zipcode

        try {
            WebElement lookUpZipcode = driver.findElement(By.xpath("//*[text() ='Look Up a ZIP Code']"));
            mouseAction.moveToElement(lookUpZipcode).click().perform();
        }catch (Exception e){
            System.out.println("Unable to click to Look Up a zipcode " + e);

        }//end of send tab




    }//end of main method
}//end of java class
