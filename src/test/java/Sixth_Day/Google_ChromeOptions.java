package Sixth_Day;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.jar.JarEntry;

public class Google_ChromeOptions {

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

        //navigate to google
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);
        System.out.println("navigated to yahoo page");
        //
        WebElement searchField = driver.findElement(By.xpath("//*[@name='p']"));
        //clear any predefined value on the field
        searchField.clear();
        //enter new keyword
        searchField.sendKeys("cars");
        searchField.submit();
        //need to scroll the capture of search result
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        //scroll down the page using javascript executor command
        jse.executeScript("scroll(0,5000)");

        //capture entire footer including the result
        String searchResult = driver.findElement(By.xpath("//*[]")).getText();
        String[] arrayResult = searchResult.split("Next");
        String[] searchNumber = arrayResult[1].split(" ");
        System.out.println("My search number is " + searchNumber[0]);







        /*

        //enter a keyword on google search
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        System.out.println("Entered keyword car on google search");*/


    }//end of main method

}//end java class
