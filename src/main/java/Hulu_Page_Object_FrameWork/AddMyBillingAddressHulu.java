package Hulu_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Actions;
import All_Reusable_Methods.Reusable_Actions_Loggers_POM;
import All_Reusable_Methods.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang.ObjectUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddMyBillingAddressHulu extends Reusable_Annotations{

    //declare a local logger to your pom class
    ExtentTest logger;
    public AddMyBillingAddressHulu(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//end of the constructor method

    //define all the WebElement we need for this page per use case
    @FindBy(xpath = "//*[@class='ledger__price']")
    WebElement CaptureSubscriptionFee;

    @FindBy(xpath ="//*[@class='ledger__summary']" )
    WebElement DueAmount;

    //capture the subscription amount

    public void SubscriptionAmount(){
        String TotalAmount= Reusable_Actions_Loggers_POM.getTextMethod(driver,CaptureSubscriptionFee,logger,"  Subscription Amount ");
        System.out.println("capture the subscription amount " + TotalAmount);
    }//end of capture the subscription amount



    //also capture the total due today
    public void TotalDueAmount(){
        String dueAmount = Reusable_Actions_Loggers_POM.getTextMethod(driver,DueAmount,logger,"Total due today");
        System.out.println("capture the Total due amount is " + dueAmount);
    }//end of total due today





}//end of class AddMyBillingAddressHulu
