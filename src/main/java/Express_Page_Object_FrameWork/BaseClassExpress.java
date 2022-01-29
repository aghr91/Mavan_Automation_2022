package Express_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Annotations;
import Hulu_Page_Object_FrameWork.HomePageHulu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClassExpress extends Reusable_Annotations {
    public BaseClassExpress(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }//end of constructor class

    //create static reference for Express home page
    public static HomePageExpress homePageExpress() {
        HomePageExpress homePageExpress = new HomePageExpress(driver);
        return homePageExpress;
    }//end of   BaseClassExpress

    //create static reference express webpage for see all offers
    public static SeeAllOffersExpress seeAllOffersExpress() {
        SeeAllOffersExpress seeAllOffersExpress = new SeeAllOffersExpress(driver);
        return seeAllOffersExpress;
    }//end of   express webpage for see all offers

    //create static reference express webpage for select sizes
    public static SelectSizeExpress selectSizeExpress() {
        SelectSizeExpress selectSizeExpress = new SelectSizeExpress(driver);
        return selectSizeExpress;
    }//end of   express webpage for select sizes

    //create static reference express webpage for checkout And Quantity
    public static CheckoutAndQuantity checkoutAndQuantity() {
        CheckoutAndQuantity checkoutAndQuantity = new CheckoutAndQuantity(driver);
        return checkoutAndQuantity;
    }//end of   express webpage for checkout And Quantity

    //create static reference express webpage for contact And Billing Information
    public static ContactAndBillingInformation contactAndBillingInformation() {
        ContactAndBillingInformation contactAndBillingInformation = new ContactAndBillingInformation(driver);
        return contactAndBillingInformation;
    }//end of   express webpage for contact And Billing Information

    //create static reference express webpage for payment And PlaceHolder
    public static PaymentAndPlaceHolder paymentAndPlaceHolder() {
        PaymentAndPlaceHolder paymentAndPlaceHolder = new PaymentAndPlaceHolder(driver);
        return paymentAndPlaceHolder;
    }//end of   express webpage for  payment And PlaceHolder


}//end of class BaseClassExpress


