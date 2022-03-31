package MetLife_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Actions_Loggers_POM;
import All_Reusable_Methods.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_MetLife extends Reusable_Annotations {

    //declare a local logger to your POM
    ExtentTest logger;
    public HomePage_MetLife(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;

    }//end of constructor method

    //define all webElements we need per this case per use case
    @FindBy(xpath = "//*[contains(text(),'SUPPORT')]")
    WebElement HoverSupport;

    @FindBy(xpath = "//*[text()='Find an Insurance Policy']")
    WebElement InsurancePolicy;


    // Mouse hover on support link
    public void HoverOnSupportLink(){
        Reusable_Actions_Loggers_POM.mouseHover(driver,HoverSupport,logger," Mouse hover on support link ");
    }//end of  Mouse hover on support link

    // click on find an insurance policy

    public void clickOnInsurancePolicy(){

        Reusable_Actions_Loggers_POM.clickMethod(driver,InsurancePolicy,logger," find an insurance policy");
    }//end of find an insurance policy




}//end of class HomePage_MetLife
