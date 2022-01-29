package Express_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Actions_Loggers_POM;
import All_Reusable_Methods.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Page_Object_Express_Test extends Reusable_Annotations {

    @Test
    public void Express_WebSite_Testing() throws BiffException, IOException, WriteException, InterruptedException {
        // Step: 1
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/Express_FrameWork.xls"));
        Sheet readableSheet = readableFile.getSheet(0);
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/Express_FrameWork_Results.xls"), readableFile);
        WritableSheet writableSheet = writableFile.getSheet(0);
        int rowCount = writableSheet.getRows();

        //First test
//test

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


            //verify express page title
            String actualTitle = driver.getTitle();
            if (actualTitle.equals("Men's & Women's Clothing")) {
                System.out.println("Title Matches");
            } else {
                System.out.println("Title does not match.Actual title is " + actualTitle);
            }//end of verify page title

            //mouse hover on women tabs
            BaseClassExpress.homePageExpress().HoverOnWomenTab();

             //click on dress link
            BaseClassExpress.homePageExpress().ClickONDressLink();

            //scroll page down
            Reusable_Actions_Loggers_POM.scrollMethod(driver,"0","600",logger);
            Thread.sleep(2000);

            //click on second image
            BaseClassExpress.seeAllOffersExpress().ClickSecondImage(1);
            Thread.sleep(1000);

            //again scroll page and click on specific size with some wait statement
            Reusable_Actions_Loggers_POM.scrollMethod(driver,"0","200",logger);

            //select different sizes
            BaseClassExpress.selectSizeExpress().ClickOnSize(size);

            //click on Add to Bag
            BaseClassExpress.selectSizeExpress().ClickOnAddToBag();

            //click on View Bag
            BaseClassExpress.selectSizeExpress().ClickOnViewBag();

            //select quantity from dropdown
            BaseClassExpress.checkoutAndQuantity().SelectQuantityDropDown(quantity);

            //remove pop up
            //BaseClassExpress.checkoutAndQuantity().PopupAppear();

            //click on continue-to-checkout
            BaseClassExpress.checkoutAndQuantity().clickOnContinue();

            //click on Checkout as Guest
            BaseClassExpress.checkoutAndQuantity().clickOnGuest();

            //Enter First Name
            BaseClassExpress.contactAndBillingInformation().enterFirstname(firstName);

            //Enter Second Name
            BaseClassExpress.contactAndBillingInformation().enterLastname(lastName);

            //Enter Email Address
            BaseClassExpress.contactAndBillingInformation().enterEmail(email);

             //Re Enter Confirm Email Address
            BaseClassExpress.contactAndBillingInformation().ReconfirmEmail(email);

            //Enter Phone Number
            BaseClassExpress.contactAndBillingInformation().enterPhoneNumber(phoneNumber);

            //click on Continue button
            BaseClassExpress.contactAndBillingInformation().clickContinueButton();

            //Shipping Address
            BaseClassExpress.contactAndBillingInformation().enterAddress(address);

            //Enter postal code
            BaseClassExpress.contactAndBillingInformation().enterZipcode(zipCode);

            //enter city
            BaseClassExpress.contactAndBillingInformation().enterCity(city);

            //select state
            BaseClassExpress.contactAndBillingInformation().enterState(state);

              //click on continue button
            BaseClassExpress.contactAndBillingInformation().clickContinue();

            //Delivery Options
            BaseClassExpress.contactAndBillingInformation().DeliveryContinue();

            //Enter credit card number
            BaseClassExpress.paymentAndPlaceHolder().enterCreditCardNumber(cardNumber);

            //Enter Expire Month
            BaseClassExpress.paymentAndPlaceHolder().SelectExpireMonth(expMonth);

            //Enter Expire Year
            BaseClassExpress.paymentAndPlaceHolder().SelectExpireYear(expYear);

            //Enter Cvv security code
            BaseClassExpress.paymentAndPlaceHolder().EnterCvv(cvv);

            //again remove pop up
           // BaseClassExpress.paymentAndPlaceHolder().setAppearPopUp();

            //click on Place Order
            BaseClassExpress.paymentAndPlaceHolder().clickOnPlaceOrder();
            Thread.sleep(2000);

             //capture the result
            BaseClassExpress.paymentAndPlaceHolder().errorMessage();





            //end of capture result


            // storing the values to the writable Excel sheet
            Label label = new Label(14, i,errorMessage);
            //I need to write back to the writable sheet
            writableSheet.addCell(label);





            driver.manage().deleteAllCookies();
            break;
        }//end of for loop

        //writing back to the writable file to see
        writableFile.write();
        writableFile.close();

    }//end of @test class






}//end of class Page_Object_Express
