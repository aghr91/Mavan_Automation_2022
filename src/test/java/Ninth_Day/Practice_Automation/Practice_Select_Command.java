package Ninth_Day.Practice_Automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Practice_Select_Command {
    public static void main(String[] args) throws InterruptedException {
        //Web driver manager to open by chrome driver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-Maximized");
        options.addArguments("incognito");
        WebDriver driver = new ChromeDriver(options);

        //navigate the mortgage page using chrome browser
        driver.navigate().to("http://www.mortgagecalculator.org");
        Thread.sleep(2500);

        //scroll the page that I need
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement textValue = driver.findElement(By.xpath("//*[@class='left-cell']"));
        jse.executeScript("arguments[0].scrollIntoView(true);",textValue);
        //jse.executeScript("scroll(0,450)");
        System.out.println("Scroll the page down");

        // enter the price into home section after clear the amount
        WebElement homeVal = driver.findElement(By.xpath("//*[@class='right-cell']"));
        homeVal.clear();
        homeVal.sendKeys("500000");
        System.out.println("enter the new home value");
        Thread.sleep(1500);

        //select new start month
        WebElement sMonth = driver.findElement(By.xpath("//*[contains(@name,'start_month')]"));
        //select command when dropdown value only under the select tag
        //Select sMonthDropDown = new Select(sMonth);
       // sMonthDropDown.selectByVisibleText("Sep");

        //System.out.println("select month from dropDown");
        //if the dropdown tag is not under select than I need to click on the dropdown and click on the value
        sMonth.click();
        driver.findElement(By.xpath("//*[text()='Sep']")).click();
        System.out.println("select month from dropDown");


    }//end of main method
}//end of java class
