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

public class CheckoutAndQuantity extends Reusable_Annotations{
    //declare a local logger to your pom class
    ExtentTest logger;
    public CheckoutAndQuantity (WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//end of the constructor method


    //define all the WebElement we need for this page per use case
    @FindBy(xpath = "//*[@id='qdd-0-quantity']")
    WebElement QuantitySelect;

    @FindBy(xpath = "//*[contains(@name,'bluecoreCloseButton')]")
    WebElement RemovePopup;

    @FindBy(xpath = "//*[@id='continue-to-checkout']")
    WebElement Checkout;

    @FindBy(xpath = "//*[text()='Checkout as Guest']")
    WebElement checkOutGuest;

    //select Quantity from dropDown
    public void SelectQuantityDropDown(String quantity) {
        Reusable_Actions_Loggers_POM.clickMethod(driver,QuantitySelect,logger,"select Quantity");
        // //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ quantity +"']"))).click();
        }catch (Exception e){
            System.out.println("Unable to select Quantity" + e);
        }
    }//end of select Quantity

    //remove pop up
    public void PopupAppear (){
        Reusable_Actions_Loggers_POM.click_popUp(driver,RemovePopup,logger,"PopupAppear");
    }//end of popUp

    //click on continue-to-checkout
    public void clickOnContinue(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,Checkout,logger,"continue-to-checkout");
    }//end of click on continue-to-checkout

    //click on Checkout as Guest
    public void clickOnGuest(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,checkOutGuest,logger,"Checkout as Guest");

    }//end of Checkout as Guest






}//end of class CheckoutAndQuantity
