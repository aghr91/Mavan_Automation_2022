package Ninth_Day.Practice_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice_FindElements {
    public static void main(String[] args) throws InterruptedException {
      //set the property
      System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
      //set the Chromeoptions
        ChromeOptions options = new ChromeOptions();
        //
        options.addArguments("start-maximizing");
        //
        options.addArguments("incognito");
        //
        WebDriver driver = new ChromeDriver(options);
        //navigate the yahoo
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(3000);
        //searching for search on google field
        driver.findElement(By.xpath("//*[@class='_yb_2j8v6']")).sendKeys("cars");

        //hit submit button
        driver.findElement(By.xpath("//*[@value='Search']")).submit();
        //click on new link using findElements
        driver.findElements(By.xpath("//*[contains(@class,'_yb_1rhax')]"));









    }//end of main method
}//end of java
