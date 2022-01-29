package All_Assignment;

import All_Reusable_Methods.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestNG_HomeWork {
    //declare the web driver outside the annotation methods So it can be called on all the methods
    WebDriver driver;

    @BeforeSuite
    public void SetTheDriver() {
        driver = Reusable_Actions.setDriver();
    }//end of preCondition

    @Test(priority = 1)
    public void HuluPage() throws InterruptedException {
        ArrayList<String > emails = new ArrayList<>();
        emails.add("ufthossain732392@gmail.com");
        emails.add("uftaghr91@gmail.com");

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
        year.add("2001");
        year.add("2000");

        ArrayList<String > gender = new ArrayList<>();
        gender.add("Female");
        gender.add("Male");


        for(int i = 0; i < emails.size(); i++) {
            //navigating to hulu page
            driver.navigate().to("https://www.hulu.com");

            //verify the UPS page title
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Stream TV and Movies")) {
                System.out.println("Title Matches");
            } else {
                System.out.println("Title does not match.Actual title is " + actualTitle);
            }//end of verify page title

            //scroll the page
            Reusable_Actions.scrollMethod(driver,"0","3000");

            //click the select button
            Reusable_Actions.clickMethod(driver, "//*[text()='SELECT']", "select button");

            //enter email in search field
            Reusable_Actions.sendKeysMethod(driver, "//*[@id='email']", emails.get(i), "enter email");

            //enter password in search box
            Reusable_Actions.sendKeysMethod(driver, "//*[@id ='password']", passWord.get(i), "enter password");

            //enter name in search box
            Reusable_Actions.sendKeysMethod(driver, "//*[@id='firstName']", name.get(i), "enter name");

            //Click on actual Month
            System.out.println("select month" );
            Reusable_Actions.clickMethod(driver, "//*[contains(@class,'field__month')]","Select Month");
            Reusable_Actions.clickMethod(driver, "//*[text()='"+ month.get(i) +"']","Actual Month");

            //select Day from drop down
            Reusable_Actions.clickMethod(driver, "//*[contains(text(),'Day')]","Select Day");
            Reusable_Actions.clickMethod(driver, "//*[text()='"+ day.get(i) +"']","Actual Day");

            //select year from drop down
            Reusable_Actions.clickMethod(driver, "//*[contains(text(),'Year')]","select year");
            Reusable_Actions.clickMethod(driver, "//*[text()='"+ year.get(i) +"']","Actual Year");

            //select gender from box
            Reusable_Actions.clickMethod(driver, "//*[contains(text(),'Select')]","Select Gender");
            Reusable_Actions.clickMethod(driver, "//*[text()='"+ gender.get(i) +"']","Actual Gender");


            //click on continue button
            Reusable_Actions.clickMethod(driver, "//*[contains(text(),'CONTINUE')]", "Continue");


            //capture the subscription amount
            Thread.sleep(2000);
            String fee = Reusable_Actions.getTextMethod(driver, "//*[@class='ledger__price']", "Subscription Amount");
            System.out.println("capture the subscription amount " + fee);

            //also capture the total due today
            String due = Reusable_Actions.getTextMethod(driver, "//*[@class='ledger__summary']", "Total due today");
            System.out.println("capture the Total due amount is " + due);

            //delete all cookies

            driver.manage().deleteAllCookies();


        }//end of for loop
        }//end test 1

    @Test(dependsOnMethods = "HuluPage")
    public void LoginPage() throws InterruptedException {
        //navigating to hulu page Again
        System.out.println("navigate the hulu page again");
        driver.navigate().to("https://www.hulu.com");
        //Thread.sleep(3000);


        //click on login button

        Reusable_Actions.clickMethod(driver,"//*[contains(text(),'LOG IN')]","login button"); // @id='_next']

        //enter email for log in
        Reusable_Actions.sendKeysMethod(driver,"//*[@id='email_id']","hossain732392@gmail.com","email log in");
        //enter Password for log in
        Reusable_Actions.sendKeysMethod(driver,"//*[@id='password_id']","732345Ar@","passWord enter");

        //click on again login button
        Reusable_Actions.clickMethod(driver,"//button[contains(text(),'LOG IN')]","again log in");

        //capture user name
        String userName = Reusable_Actions.getTextMethod(driver, "//*[text()='Rabu']", "user name");
        System.out.println("capture the Total due amount is " + userName);


    }//end test 2


     @AfterSuite
    public void EndSession(){

        driver.quit();
    }//end of session




}//end of TestNG_HomeWork