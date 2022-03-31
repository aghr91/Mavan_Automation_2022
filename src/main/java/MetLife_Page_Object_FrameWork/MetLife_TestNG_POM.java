package MetLife_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Actions;
import All_Reusable_Methods.Reusable_Actions_Loggers_POM;
import All_Reusable_Methods.Reusable_Annotations;
import Best_buy_Page_Object_frameWork.BaseClassBestBuy;
import Best_buy_Page_Object_frameWork.BestBuy_TestNG_POM;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MetLife_TestNG_POM extends Reusable_Annotations {

    @Test
    public void MetLife_WebSite_Testing() throws InterruptedException {


        ArrayList<String> FirstName = new ArrayList<>();
        FirstName.add("Alamgir");

        ArrayList<String> LastName = new ArrayList<>();
        LastName.add("Hossain");

        ArrayList<String> Month= new ArrayList<>();
        Month.add("07");

        ArrayList<String> Day = new ArrayList<>();
        Day.add("22");

        ArrayList<String> Year = new ArrayList<>();
        Year.add("2000");

        ArrayList<String> SSN = new ArrayList<>();
        SSN.add("3343");

        ArrayList<String> State = new ArrayList<>();
        State.add("NY");

        for(int i = 0; i<FirstName.size();i++) {

            //navigating to hulu page
            logger.log(LogStatus.INFO, "Navigating to MetLife home page");
            driver.navigate().to("https://www.metlife.com");

            //verify the  page title
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Insurance And Employee Benefits | MetLife")) {
                System.out.println("Title Matches");
            } else {
                System.out.println("Title does not match.Actual title is " + actualTitle);
            }//end of verify page title


            // Mouse hover on support link
           BaseClassMetLife.homePageMetLife().HoverOnSupportLink();
            Thread.sleep(1000);

            // click on find an insurance policy
            BaseClassMetLife.homePageMetLife().clickOnInsurancePolicy();
            Thread.sleep(1000);

            //scroll the page
            Reusable_Actions_Loggers_POM.scrollMethod(driver, "0", "500",logger);
            System.out.println("scroll the page");
            Thread.sleep(2000);

            //click on first name box
            BaseClassMetLife.policyFinderPageMetLife().setClickFirstBox();

            //enter First Name
            BaseClassMetLife.policyFinderPageMetLife().EnterFirstName(FirstName.get(i));
            Thread.sleep(1000);

            //click on lastname box
            BaseClassMetLife.policyFinderPageMetLife().setClickSecondBox();

            //enter Second Name
            BaseClassMetLife.policyFinderPageMetLife().EnterSecondName(LastName.get(i));

            //enter birth month
            BaseClassMetLife.policyFinderPageMetLife(). EnterBirthMonth(Month.get(i));
            Thread.sleep(1000);

            //enter birthday
            BaseClassMetLife.policyFinderPageMetLife().EnterBirthDay(Day.get(i));

            //enter birth Year
            BaseClassMetLife.policyFinderPageMetLife().EnterBirthYear(Year.get(i));
            Thread.sleep(1000);

            //click on SSN box
            BaseClassMetLife.policyFinderPageMetLife().ClickSSNBox();
            //enter SSN number
            BaseClassMetLife.policyFinderPageMetLife().EnterSSNNumber(SSN.get(i));


           // scroll down
            BaseClassMetLife.policyFinderPageMetLife().SelectScroll();
            Thread.sleep(1000);

            //select state from dropDown
            BaseClassMetLife.policyFinderPageMetLife().SelectState(State.get(i));

            // verify check box
            BaseClassMetLife.policyFinderPageMetLife().robotButton();
            Thread.sleep(2000);

            // click on submit button
            BaseClassMetLife.policyFinderPageMetLife().clickOnSubmit();
            Thread.sleep(1500);

            //capture text
            BaseClassMetLife.policyFinderPageMetLife().CaptureNoMatch();


            


            driver.manage().deleteAllCookies();
        }//end of for loop


    }//end of @Test












}//end of class MetLife_TestNG_POM
