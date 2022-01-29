package Fifth_Day;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleArray_Search {
    public static void main(String[] args) throws InterruptedException {
        //create String dynamic array
        String[] countries = new String[7];//set limit/boundaries for array

        countries[0] = "usa";
        countries[1] = "Afghanistan";
        countries[2] = "India";
        countries[3] = "Germany";
        countries[4] = "Canada";
        countries[5] = "Austria";
        countries[6] = "Turkey";
        //set the property of the chromedriver we are using
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //define the web driver you are using
        WebDriver driver = new ChromeDriver();

        //
        for (int i = 0; i < countries.length; i++){

            //simply open the Google website
            driver.navigate().to("https://www.google.com");

            //maximize my browser
            //driver.manage().window().fullscreen(); //for mac
            driver.manage().window().maximize(); //for windows

            //anytime when you go to a new page you should put some wait statement
            Thread.sleep(2000);

            //searching for cars on Google search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(countries[i]);

            //hit submit on Google search button
            driver.findElement(By.xpath("//*[@value='Google Search']")).submit();

            //another wait statement since when we came a new page
            Thread.sleep(2000);

            //capture the search result and store as variable
            String value = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

            //declaring the array variable to split the result
            String[] arrayResult = value.split(" ");

            //now print the search number only
            System.out.println(" My country name is " + "countries[i]" + " And Search Result is " + arrayResult[1]);

        }//end for loop
        driver.quit();


    }//end of main method
}//end of java class
