package All_Assignment;

import All_Reusable_Methods.Reusable_Actions;
import All_Reusable_Methods.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Express_HTML_HomeWork {
    //set the web driver outside the method
    WebDriver driver;
    //declare the extent reports and test outside So it will be reusable among all annotation
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void setTheDriver() {
        driver = Reusable_Actions.setDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/Express_Results.html", true);
    }//end before suite

    @Test
    public void Express_Html() throws BiffException, IOException, WriteException, InterruptedException {
        // Step: 1
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/Express_HTML.xls"));
        Sheet readableSheet = readableFile.getSheet(0);
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/Express_HTML_Results.xls"), readableFile);
        WritableSheet writableSheet = writableFile.getSheet(0);
        int rowCount = writableSheet.getRows();

        logger = reports.startTest(" Express Website logging ");

        //using for loop
        for (int i = 1; i < rowCount; i++) {

            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String address = writableSheet.getCell(6, i).getContents();
            String zipCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();
            String cardNumber = writableSheet.getCell(10, i).getContents();
            String expMonth = writableSheet.getCell(11, i).getContents();
            String expYear = writableSheet.getCell(12, i).getContents();
            String cvv = writableSheet.getCell(13, i).getContents();
            String errorMessage = writableSheet.getCell(14, i).getContents();


            //navigate to Express web page
            logger.log(LogStatus.INFO, "Navigate to Express home page");
            driver.navigate().to("https://www.express.com");
            driver.manage().deleteAllCookies();

            //verify express page title
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Men's & Women's Clothing")) {
                System.out.println("Title Matches");
            } else {
                System.out.println("Title does not match.Actual title is " + actualTitle);
            }//end of verify page title

            //mouse hover on women tabs
            Reusable_Actions_Loggers.mouseHover(driver, "//*[text()='Women']", logger, "Women's tab");
            //click on dress link
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Dresses']", logger, "Dresses link");
            //scroll page down
            Thread.sleep(2000);
            Reusable_Actions_Loggers.scrollMethod(driver, "0", "600");
            //click on second image
            Reusable_Actions_Loggers.clickByIndex(driver, "//*[@class='cdS1D9eKI7bXTMHp5xeAA']", 1, logger, "select second image");

            //again scroll page and click on specific size with some wait statement
            Reusable_Actions_Loggers.scrollMethod(driver, "0", "200");
            Thread.sleep(2000);
            //select different sizes
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='" + size + "']", logger, "click on Size");

            //click on Add to Bag
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Add to Bag']", logger, "Add to Bag");
            //click on View Bag
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='View Bag']", logger, "View Bag");

            //select quantity from dropdown
            Thread.sleep(2000);
            Reusable_Actions_Loggers.dropDownMenu(driver, "//*[@id='qdd-0-quantity']", logger, quantity, " quantity ");


            //remove pop up
             Reusable_Actions_Loggers.click_popUp(driver,"//*[contains(@name,'bluecoreCloseButton')]",logger,"remove pop up");


            //click on continue-to-checkout
            Reusable_Actions_Loggers.clickMethod(driver, "//*[@id='continue-to-checkout']", logger, "continue-to-checkout");

            //click on Checkout as Guest
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Checkout as Guest']", logger, "Checkout as Guest");

            //Enter First Name
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='firstname']", firstName, logger, "First Name");
            //Enter Second Name
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='lastname']", lastName, logger, "Last Name");
            //Enter Email Address
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='email']", email, logger, "Email Address");
            //Re Enter Confirm Email Address
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='confirmEmail']", email, logger, " Confirm Email Address");
            //Enter Phone Number
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='phone']", phoneNumber, logger, "Phone Number");

            //click on Continue button
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Continue']", logger, " Continue Button");

            //Shipping Address
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='shipping.line1']", address, logger, "Shipping Address");
            //Enter postal code
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='shipping.postalCode']", zipCode, logger, "postal code");
            //enter city
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='shipping.city']", city, logger, " city");
            //select state
            Reusable_Actions_Loggers.dropDownMenu(driver, "//*[@name='shipping.state']", logger, state, " state");
            //click on continue button
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Continue']", logger, "continue button");

            //Delivery Options
            Reusable_Actions_Loggers.clickMethod(driver, "//span[contains(text(),'Continue')]", logger, "continue button");




            //Enter credit card number
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='creditCardNumber']", cardNumber, logger, " credit card number");
            //Enter Expire Month
            Thread.sleep(2000);
            Reusable_Actions_Loggers.dropDownMenu(driver, "//select[contains(@id,'rvndd--expMonth')]", logger, expMonth, " Expire Month ");
            //Enter Expire Year
            Reusable_Actions_Loggers.dropDownMenu(driver, "//select[contains(@id,'rvndd--expYear')]", logger, expYear, " Expire Year ");


            //Enter Cvv security code
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='cvv']", cvv, logger, "Cvv security code");


            Reusable_Actions_Loggers.click_popUp(driver,"//*[contains(@name,'bluecoreCloseButton')]",logger,"remove pop up");

            //click on Place Order
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Place Order']", logger, "Place Order");
            Thread.sleep(3000);
            //capture the result

            String errorResults = Reusable_Actions_Loggers.getTextMethod(driver, "//div[@id='rvn-note-NaN']", logger, "errorMessage");
            System.out.println("the error message is " + errorResults);

            // storing the values to the writable Excel sheet
            Label label = new Label(14, i, errorResults);
            //I need to write back to the writable sheet
            writableSheet.addCell(label);




            //driver.manage().deleteAllCookies();
            break;

        }//end of for loop

        //end logger
        reports.endTest(logger);


        //writing back to the writable file to see
        writableFile.write();
        writableFile.close();


    }//end of test

    @AfterSuite
    public void CloseSession() {
        reports.flush();
        //driver.quit();

    }//end of after suite


}//end of java class
