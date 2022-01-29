package Hulu_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Actions_Loggers_POM;
import All_Reusable_Methods.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageHulu extends Reusable_Annotations{
    //constructor is helper method that allows you to identify objects in your pom
    //so later you can class those methods in your test class
    //because your pom class is not static
    //declare a local logger to your pom class
    ExtentTest logger;
    public HomePageHulu(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//end of the constructor method

    //define all the WebElement we need for this page per use case
    @FindBy(xpath = "//*[text()='SELECT']")
    WebElement SelectButton;

    //Method to click on select button
    public void clickOnSelectButton(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,SelectButton,logger,"Select Button");

    }//end click on select button









}// end of class HomePageHulu
