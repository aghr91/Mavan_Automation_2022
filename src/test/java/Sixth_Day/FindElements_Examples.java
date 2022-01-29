package Sixth_Day;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElements_Examples {

    public static void main(String[] args) throws InterruptedException {

        //set the property of the chromedriver we are using
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
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

        //navigate to yahoo
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);

        //click on News link using findElements
        driver.findElements(By.xpath("//*[contains(@class,'_yb_1rhax')]")).get(1).click();
        System.out.println(" open news home page");


    }//end of main method
}//end of java class
