package Hulu_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Annotations;
import USPS_Page_Object.Homepage;
import USPS_Page_Object.SendMailAndPackages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClassHulu extends Reusable_Annotations {
    public BaseClassHulu(WebDriver driver){
        PageFactory.initElements(driver,this);
    }//end of constructor class

    //create static reference for Hulu home page
    public static HomePageHulu homePageHulu(){
        HomePageHulu homePageHulu= new HomePageHulu(driver);
        return homePageHulu;
    }//end of  BaseClassHulu


    //create static reference for create an account section
    public static CreateAccountHulu createAccountHulu(){
        CreateAccountHulu createAccountHulu = new CreateAccountHulu(driver);
        return  createAccountHulu;
    }//end of create account

    //create static reference for add billing address
    public static AddMyBillingAddressHulu addMyBillingAddressHulu (){
        AddMyBillingAddressHulu addMyBillingAddressHulu = new AddMyBillingAddressHulu(driver);
        return  addMyBillingAddressHulu;
    }//end of create account









}//end of BaseClassHulu
