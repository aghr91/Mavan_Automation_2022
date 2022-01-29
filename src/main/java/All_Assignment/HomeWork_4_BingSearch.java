package All_Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeWork_4_BingSearch {
    public static void main(String[] args) throws InterruptedException {

        //create String dynamic array
        String[] hobby = new String[6];//set limit/boundaries for array
        hobby[0] = "cricket";
        hobby[1] = "football";
        hobby[2] = "traveling";
        hobby[3] = "reading books";
        hobby[4] = "gossiping";
        hobby[5] = "swimming";

        //set the property of the chromedriver we are using
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //declare and define the chrome options
        ChromeOptions options = new ChromeOptions();
        //declare all the arguments we need
        //to maximize my driver
        options.addArguments("start-maximized");
        //set as incognito mode
        options.addArguments("incognito");
        //set as headless(running the driver on background)
        //options.addArguments("headless");
        //define the web driver you are using
        WebDriver driver = new ChromeDriver(options);


        for (int i = 0; i < hobby.length; i++){

            //simply open the bing website
            driver.navigate().to("https://www.bing.com");

            //anytime when you go to a new page you should put some wait statement
            Thread.sleep(2000);

            //searching for cars on bing search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobby[i]);

            //hit submit on bing search button
            driver.findElement(By.xpath("//*[@id='search_icon']")).click();

            //another wait statement since when we came a new page
            Thread.sleep(2000);


            //capture the search result and store as variable
            String value = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

            //declaring the array variable to split the result
            String[] arrayNumber = value.split(" ");

            //now print the search number only
            System.out.println(" My Hobby is " + hobby[i] + " And Search number is " + arrayNumber[0]);




        }//end for loop

        driver.quit();


    }//end main method
}//end of java class
