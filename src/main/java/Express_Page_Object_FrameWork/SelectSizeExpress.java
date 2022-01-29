package Express_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Actions_Loggers_POM;
import All_Reusable_Methods.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectSizeExpress extends Reusable_Annotations {
    //declare a local logger to your pom class
    ExtentTest logger;
    public SelectSizeExpress (WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//end of the constructor method

    //define all the WebElement we need for this page per use case
    @FindBy(xpath ="//*[text()='Add to Bag']")
    WebElement AddToBag;

    @FindBy(xpath = "//*[text()='View Bag']")
    WebElement ViewBag;



    //select different sizes

    //declare local explicit wait
    public void ClickOnSize(String size) {
    WebDriverWait wait = new WebDriverWait(driver,15);
        logger.log(LogStatus.INFO,"select different sizes");
        try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ size +"']"))).click();
    }catch (Exception e){
        System.out.println("Unable to select Birth Month " + e);
        logger.log(LogStatus.FAIL,"Unable to select Birth Month " + e);

    }
}//end of select different sizes

     //click on Add to Bag
    public void ClickOnAddToBag(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,AddToBag,logger,"Add to Bag");
    }//end of add to bag

    //click on View Bag
    public void ClickOnViewBag(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,ViewBag,logger,"View Bag");

    }//end of view bag








}//end of class SelectSizeExpress
