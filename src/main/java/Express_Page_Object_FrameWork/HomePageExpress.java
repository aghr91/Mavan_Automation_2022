package Express_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Actions_Loggers_POM;
import All_Reusable_Methods.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageExpress extends Reusable_Annotations{

    //declare a local logger to your pom class
    ExtentTest logger;
    public HomePageExpress(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//end of the constructor method

    //define all the WebElement we need for this page per use case
    @FindBy(xpath = "//*[text()='Women']")
    WebElement WomenTab;

    @FindBy(xpath ="//*[text()='Dresses']")
    WebElement DressLink;

    //Hover on Women Tab
    public void HoverOnWomenTab(){
        Reusable_Actions_Loggers_POM.mouseHover(driver,WomenTab,logger,"Hover on Women Tab");
    }//end click on select button

    //click on Dress link
    public void ClickONDressLink(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,DressLink,logger,"Dress link");

    }//end of dress link




}//end of class HomePageExpress
