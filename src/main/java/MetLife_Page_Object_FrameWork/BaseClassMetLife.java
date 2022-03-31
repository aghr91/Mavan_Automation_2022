package MetLife_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Annotations;
import Hulu_Page_Object_FrameWork.HomePageHulu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClassMetLife extends Reusable_Annotations {
    public BaseClassMetLife(WebDriver driver){
        PageFactory.initElements(driver,this);
    }//end of constructor class

    //create static reference for MetLife home page
    public static HomePage_MetLife homePageMetLife(){
        HomePage_MetLife homePageMetLife= new HomePage_MetLife(driver);
        return homePageMetLife;
    }//end of  BaseClassHulu

    //create static reference for MetLife home page
    public static PolicyFinderPage_MetLife policyFinderPageMetLife(){
        PolicyFinderPage_MetLife policyFinderPageMetLife= new PolicyFinderPage_MetLife(driver);
        return policyFinderPageMetLife;
    }//end of  BaseClassHulu






}//end of class BaseClass_MetLife
