package Seventh_Day;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Mortgage_Select_Command {
    public static void main(String[] args) throws InterruptedException {
        //webdriver manager to open by driver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //start maximized
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //options.addArguments("headless");
        //set the driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgage calc
        driver.navigate().to("https://www.mortgagecalculator.org");
        //driver.manage().window().fullscreen();
        Thread.sleep(2500);

        //scroll to the window of loan view
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //scroll to the view by pixels
        jse.executeScript("scroll(0,450)");

        //clear and type your new home value
        WebElement homeVal = driver.findElement(By.xpath("//*[contains(@name,'homevalue')]"));
        homeVal.clear(); //clear any preset values on the home value field
        homeVal.sendKeys("350000"); //enter my new data on the home value field

        //select my new start month let say november
        WebElement startMonth = driver.findElement(By.xpath("//*[contains(@name,'start_month')]"));
        //select command can only be used when the dropdown element is under 'Select' tag
        Select sMonthDropDown = new Select(startMonth);
       // select by visible text
        sMonthDropDown.selectByVisibleText("Nov");
        //sMonthDropDown.deselectByIndex(10);

        //if the dropdown tag is not under select than I need to click on the dropdown and click on the value
       // startMonth.click();
        //click on value
        //driver.findElement(By.xpath("//*[text()='Sep']")).click();





    }//end of main method
}//end of java class
