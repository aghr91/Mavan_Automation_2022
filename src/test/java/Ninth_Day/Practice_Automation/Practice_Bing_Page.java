package Ninth_Day.Practice_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_Bing_Page {
    public static void main(String[] args) throws InterruptedException {

        //defining dynamic array
        String[] zipcode = new String[6];
        zipcode [0] = "11235";
        zipcode [1] = "11210";
        zipcode [2] = "11228";
        zipcode [3] = "11218";
        zipcode [4] = "11564";
        zipcode [5] = "11313";

        //define the set property
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //set the web driver
        WebDriver driver = new ChromeDriver();

        //using for loop find zipcode
        for (int i = 0; i< zipcode.length;i++){

            //navigating the bing website
            driver.navigate().to("http://www.bing.com");
            System.out.println("Bing Page Should be Open");

            Thread.sleep(2000);
            //enter a keyword on search field
            driver.findElement(By.xpath("//*[@type ='search']")).sendKeys(zipcode[i]);

            //set the browser on maximize mode
            driver.manage().window().maximize();

            // click on search button to open new window
            driver.findElement(By.xpath("//*[@id='search_icon']")).click();

            //put also some time for wait statement
            Thread.sleep(2000);

            //capture the result using split massage
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

            String[] searchResult = result.split(" ");
            // print the statement
            System.out.println("My zipcode is " + zipcode[i] + " and search number is " + searchResult[0]);

        }//end of for loop
        // clos the whole session of driver
        driver.quit();


    }//end of java class
}//end of java class
