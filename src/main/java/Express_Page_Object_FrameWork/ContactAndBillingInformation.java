package Express_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Actions_Loggers_POM;
import All_Reusable_Methods.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactAndBillingInformation extends Reusable_Annotations{

    //declare a local logger to your pom class
    ExtentTest logger;
    public  ContactAndBillingInformation(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//end of the constructor method

    //define all the WebElement we need for this page per use case

    @FindBy(xpath = "//*[@name='firstname']")
    WebElement InputFirstName;

    @FindBy(xpath = "//*[@name='lastname']")
    WebElement InputLastname;

    @FindBy(xpath = "//*[@name='email']")
    WebElement InputEmail;

    @FindBy(xpath = "//*[@name='confirmEmail']")
    WebElement ConfirmEmail;

    @FindBy(xpath = "//*[@name='phone']")
    WebElement InputPhoneNumber;

    @FindBy(xpath = "//*[text()='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//*[@name='shipping.line1']")
    WebElement ShippingAddress;

    @FindBy(xpath = "//*[@name='shipping.postalCode']")
    WebElement postalCode;

    @FindBy(xpath = "//*[@name='shipping.city']")
    WebElement InputCity;

    @FindBy(xpath = "//*[@name='shipping.state']")
    WebElement SelectState;

    @FindBy(xpath = "//*[text()='Continue']")
    WebElement Continue;

    @FindBy(xpath = "//span[contains(text(),'Continue')]")
    WebElement againContinue;

    //Enter First Name
    public void enterFirstname(String firstName){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,InputFirstName,firstName,logger,"Enter First Name");
    }//end of enter first name

    //Enter last Name
    public void enterLastname(String lastName){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,InputLastname,lastName,logger,"Enter last Name");
    }//end of Enter last Name

    //Enter Email Address
    public void enterEmail(String email){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,InputEmail,email,logger,"Enter Email Address");
    }//end of Enter Email Address

    //Re Enter Confirm Email Address
    public void ReconfirmEmail(String email){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,ConfirmEmail,email,logger,"ReEnter Email Address");
    }//end of Re Enter Confirm Email Address

    //Enter Phone Number
    public void enterPhoneNumber(String phoneNumber){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,InputPhoneNumber,phoneNumber,logger,"Enter Phone Number");
    }//end of enter phone number

    //click on Continue button
    public void clickContinueButton(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,continueButton,logger,"Continue button");
    }//end of Continue button

    //Shipping Address
    public void enterAddress(String  address){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,ShippingAddress,address,logger,"Shipping Address");
    }//end of Shipping Address

     //Enter postal code
    public void enterZipcode(String zipCode){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,postalCode,zipCode,logger,"Enter postal code");
    }//end of Enter postal code

    //enter city
    public void enterCity(String city){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,InputCity,city,logger,"enter city");
    }//end of enter city

    //select State from dropDown
    public void enterState(String state) {
        Reusable_Actions_Loggers_POM.clickMethod(driver,SelectState,logger,"select State");
        // //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ state +"']")));
        }catch (Exception e){
            System.out.println("Unable to select State " + e);
        }
    }//end of select State

    //click on continue button
    public void clickContinue(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,Continue,logger,"Continue");
    }//end of continue

    //Delivery Options continue
    public void DeliveryContinue(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,againContinue,logger,"Delivery Options continue");
    }//end of Delivery Options continue










}//end of class ContactAndBillingInformation


