package Ninth_Day.Practice_Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_GoogleArray_Search {
    public static void main(String[] args) throws InterruptedException {

        //create string dynamic array
        String[] Countries = new String[4];
        Countries[0]= "USA";
        Countries[1]= "Bangladesh";
        Countries[2]= "Turkey";
        Countries[3]= "Indonesia";

        //set the property
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //define the webdriver
        WebDriver driver = new ChromeDriver();
         for(int i=0;i<Countries.length; i++){

             //open the google website
             driver.navigate().to("http://www.google.com");
             //maximize the google page
             driver.manage().window().maximize();
             //wait statement
             Thread.sleep(3000);
             //search for cars
             driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Countries[i]");
             //hit submit
             driver.findElement(By.xpath("//*[@value='Google Search']")).submit();
             //wait statement
             Thread.sleep(2000);
             //capture the results and store
             String value = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
             //declaring as array variable to split the result
             String[] arrayResult = value.split(" " );
             //print the search number only
             System.out.println("My search result is" + "countries[i]" + "and result is" + arrayResult[1]);



         }//end of for loop
        //close the drive
        driver.quit();





    }//end of main



}//end of java method





