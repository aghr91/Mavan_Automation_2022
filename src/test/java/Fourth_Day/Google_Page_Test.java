package Fourth_Day;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Page_Test {
    public static void main(String[] args) throws InterruptedException {

       //Set the chrome driver property
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        //define the web driver we are using
        WebDriver driver = new ChromeDriver();

        //simply open the Google website
        driver.navigate().to("http://www.google.com");
        //maximize my browser
        driver.manage().window().maximize();
        //close driver
        //driver.close();





    }//end main method
}//end class
