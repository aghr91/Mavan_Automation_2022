package Ninth_Day.Practice_Automation;

import All_Reusable_Methods.Reusable_Actions;
import All_Reusable_Methods.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Practice_HTML_TestNG_mlcalc {
    //set the web driver outside the method
    WebDriver driver;
    //declare the extent reports and test outside So it will be reusable among all annotation
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void setTheDriver() {
        driver = Reusable_Actions.setDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/Mortgage_Calculator.html", true);
    }//end before suite

    @Test
    public void Mortgage_Calculator() {
        logger = reports.startTest("Mortgage Loan");
        //navigate to usps
        logger.log(LogStatus.INFO, "Navigate to mlcalc home page");
        driver.navigate().to("https://www.mlcalc.com");

        //Purchase price
        Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@id='ma']", "4000388", logger, "purchase price");
        //Down Payment
        Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@id='dp']", "40", logger, "Down Payment");
        //Show advanced options
        Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Show advanced options']", logger, "Show advanced options");
        //select month
        Reusable_Actions_Loggers.dropDownMenu(driver, "//*[@name='sm']", logger, "May", "select month");
        //select year
        Reusable_Actions_Loggers.dropDownMenu(driver, "//*[@name='sy']", logger, "2023", "select year");

        // click Calculate
        Reusable_Actions_Loggers.clickMethod(driver, "//*[@value='Calculate']", logger, "Calculate");
        //Monthly payment
        String mPayment = Reusable_Actions_Loggers.getTextMethod(driver, "//*[text()='Monthly payment']", logger, "Monthly payment");
        System.out.println("Monthly payment is " + mPayment);


        //end the logger
        reports.endTest(logger);

    }//end of test

    @AfterSuite
    public void closeDriver() {
        driver.quit();
        reports.flush();
    }


}//end of HTML_TestNG_mlcalc
