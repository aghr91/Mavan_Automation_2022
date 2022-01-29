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

public class PaymentAndPlaceHolder extends Reusable_Annotations{

    //declare a local logger to your pom class
    ExtentTest logger;
    public PaymentAndPlaceHolder(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//end of the constructor method31

    //define all the WebElement we need for this page per use case
    @FindBy(xpath = "//*[@name='creditCardNumber']")
    WebElement CreditCardNumber;

    @FindBy(xpath = "//select[contains(@id,'rvndd--expMonth')]")
    WebElement ExpireMonth;

    @FindBy(xpath = "//select[contains(@id,'rvndd--expYear')]")
    WebElement ExpireYear;

    @FindBy(xpath = "//*[@name='cvv']")
    WebElement SecurityCvv;

    @FindBy(xpath = "//*[contains(@name,'bluecoreCloseButton')]")
    WebElement AppearPopUp;

    @FindBy(xpath = "//*[text()='Place Order']")
    WebElement PlaceOrderSubmit;

    @FindBy(xpath = "//div[@id='rvn-note-NaN']")
    WebElement CaptureError;

    //Enter credit card number
    public void enterCreditCardNumber(String cardNumber){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,CreditCardNumber,cardNumber,logger,"Enter credit card number");
    }//end of Enter credit card number

     //Enter Expire Month
     public void SelectExpireMonth(String expMonth) {
         Reusable_Actions_Loggers_POM.clickMethod(driver,ExpireMonth,logger,"select Expire Month");
         // //declare local explicit wait
         WebDriverWait wait = new WebDriverWait(driver,10);
         try {
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ expMonth +"']"))).click();
         }catch (Exception e){
             System.out.println("Unable to select expire month " + e);
         }
     }//end of select Expire Month

    //Enter Expire year
    public void SelectExpireYear(String expYear) {
        Reusable_Actions_Loggers_POM.clickMethod(driver,ExpireYear,logger,"select Expire Year");
        // //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ expYear +"']"))).click();
        }catch (Exception e){
            System.out.println("Unable to select expire Year " + e);
        }
    }//end of select Expire year

    //Enter Cvv security code
    public void EnterCvv(String cvv){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,SecurityCvv,cvv,logger,"Enter Cvv security code");
    }//end of  Cvv security code

    //pop up appear
    public void setAppearPopUp(){
        Reusable_Actions_Loggers_POM.click_popUp(driver,AppearPopUp,logger,"pop up appear");
    }//end 2nd pop up

    //click on Place Order
    public void clickOnPlaceOrder(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,PlaceOrderSubmit,logger,"Place Order");
    }//end of click on Place Order

   //Capturing invalid card error message
    public void errorMessage(){
        String PaymentError = Reusable_Actions_Loggers_POM.getTextMethod(driver,CaptureError,logger,"Capturing invalid card error message");
    }//end of Capturing invalid card error message






//end of capture text



}//end of class PaymentAndPlaceHolder
