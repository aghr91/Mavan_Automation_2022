package Hulu_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Actions;
import All_Reusable_Methods.Reusable_Actions_Loggers_POM;
import All_Reusable_Methods.Reusable_Annotations;
import Express_Page_Object_FrameWork.BaseClassExpress;
import Hulu_Page_Object_FrameWork.BaseClassHulu;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Hulu_TestNG_POM extends Reusable_Annotations {

    @Test
    public void Hulu_WebSite_Testing() throws InterruptedException {

        ArrayList<String > emails = new ArrayList<>();
        emails.add("bzzthossain732392@gmail.com");
        emails.add("bzztaghr91@gmail.com");

        ArrayList<String > passWord = new ArrayList<>();
        passWord.add("732345Ar@");
        passWord.add("434345Du@");

        ArrayList<String > name = new ArrayList<>();
        name.add("Rabu");
        name.add("Hossain");

        ArrayList<String > month = new ArrayList<>();
        month.add("January");
        month.add("March");

        ArrayList<String > day = new ArrayList<>();
        day.add("5");
        day.add("10");

        ArrayList<String > year = new ArrayList<>();
        year.add("1996");
        year.add("1998");

        ArrayList<String > gender = new ArrayList<>();
        gender.add("Female");
        gender.add("Male");


        for(int i = 0; i<emails.size();i++) {


            //navigating to hulu page
            logger.log(LogStatus.INFO, "Navigating to Hulu home page");
            driver.navigate().to("https://www.hulu.com");

            //verify the  page title
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Stream TV and Movies")) {
                System.out.println("Title Matches");
            } else {
                System.out.println("Title does not match.Actual title is " + actualTitle);
            }//end of verify page title

            //scroll the page
            Reusable_Actions_Loggers_POM.scrollMethod(driver,"0","3000",logger);

            //click select button
            BaseClassHulu.homePageHulu().clickOnSelectButton();
            Thread.sleep(1000);

            //scroll the page
            Reusable_Actions_Loggers_POM.scrollMethod(driver,"0","800",logger);

            //enter email address
            BaseClassHulu.createAccountHulu().InputEmail(emails.get(i));


            //enter password
            BaseClassHulu.createAccountHulu().InputPassword(passWord.get(i));
            Thread.sleep(2000);

            //enter first name
            BaseClassHulu.createAccountHulu().InputFirstName(name.get(i));


            //select birthDay month from dropDown
            BaseClassHulu.createAccountHulu().SelectBirthMonth(month.get(i));
            Thread.sleep(2000);

            //select birthDay from dropDown
            BaseClassHulu.createAccountHulu().SelectBirthDay(day.get(i));
            Thread.sleep(2000);

            //select birth year from dropDown
            BaseClassHulu.createAccountHulu().SelectBirthYear(year.get(i));
            Thread.sleep(2000);

            //select Gender from dropDown
            BaseClassHulu.createAccountHulu().SelectGender(gender.get(i));
            Thread.sleep(2000);

            //click on continue button
            BaseClassHulu.createAccountHulu().clickOnContinue();
            Thread.sleep(2000);

            //capture text
             Thread.sleep(3000);

              //capture the subscription amount
            BaseClassHulu.addMyBillingAddressHulu().SubscriptionAmount();

             //also capture the total due today
            BaseClassHulu.addMyBillingAddressHulu().TotalDueAmount();





            //delete all cookies
            driver.manage().deleteAllCookies();
            //break;
        }//end of for loop




    }//end of test






    }//end of  class Hulu_TestNG_POM
