package Express_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Actions_Loggers_POM;
import All_Reusable_Methods.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SeeAllOffersExpress extends Reusable_Annotations {
    //declare a local logger to your pom class
    ExtentTest logger;
    public SeeAllOffersExpress(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//end of the constructor method

    //define all the WebElement we need for this page per use case
   // @FindBy(xpath = "//*[@class='cdS1D9eKI7bXTMHp5xeAA']")
    @FindBy(xpath = "//*[@class='dNZkhrDUNNoiB2qFg8Mujw==']")
    //@FindBy(xpath = "//*[@class='_2fbIe3xmE78JEQRb26pdpQ']")
     List<WebElement> selectDress;
   // WebElement selectDress;

    //click on second image
    public void ClickSecondImage(int indexNumber){
        Reusable_Actions_Loggers_POM.clickByIndex(driver,selectDress,indexNumber,logger,"selectDress");

    }//end of click on second image




}//end of class SeeAllOffersExpress
