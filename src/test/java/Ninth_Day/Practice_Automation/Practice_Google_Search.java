package Ninth_Day.Practice_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_Google_Search {
    public static void main(String[] args) throws InterruptedException {
        //set the property for webdriver
        System.setProperty("webdriver.chrome.driver.", "src/main/resources/chromedriver.exe");

        //define the webdriver
        WebDriver driver = new ChromeDriver();

        //open google website
        driver.navigate().to("http://www.google.com");

        //maximize the google page
        driver.manage().window().maximize();

        //when you go to new page put some wait statement
        Thread.sleep(2000);

        //searching for cars on google search field
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");

        //hit submit button
        driver.findElement(By.xpath("//*[@value='Google Search']")).submit();

        //another wait statement
        Thread.sleep(2000);

        //capture the result and store the variable
        String value = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

        //declaring array variable
        String[] arrayResult = value.split(" ");
        //print
        System.out.println("My search result is" + arrayResult[1]);

        //close it
        driver.quit();




    }//end method
}//end java class