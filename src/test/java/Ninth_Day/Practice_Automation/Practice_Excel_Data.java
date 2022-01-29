package Ninth_Day.Practice_Automation;

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
import org.bouncycastle.crypto.agreement.srp.SRP6Client;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Practice_Excel_Data {
    //declare the web driver outside the annotation
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;


    @BeforeSuite
    public void setTheDriver() {
        reports = new  ExtentReports("src/main/java/HTML_Report/City_Name.html",true);
        driver = Reusable_Actions.setDriver();
    }//end of precondition

    @Test
   public void City() throws BiffException, IOException, WriteException {
        // Step: 1
        Workbook readFile = Workbook.getWorkbook(new File("src/main/resources/Practice_BestBuy.xls"));
        Sheet readSheet = readFile.getSheet(0);
        WritableWorkbook writeFile= Workbook.createWorkbook(new File("src/main/resources/Practice_BestBuy_Results.xls"),readFile);
        WritableSheet writeSheet = writeFile.getSheet(0);
        int rowCount = writeSheet.getRows();
        //step 2
        for (int i = 1; i < rowCount; i++) {

            String city = writeSheet.getCell(0, i).getContents();
            System.out.println(" My City Name is " + city) ;
            logger = reports.startTest("My cities are");
            //navigate to google
            logger.log(LogStatus.INFO,"Navigate to google home page");
            driver.navigate().to("https://www.google.com");

            //enter sendKeys in search field
            Reusable_Actions_Loggers.sendKeysMethod(driver,"//*[@name ='q']",city,logger,"Search field");
            //submit to google search button
            Reusable_Actions_Loggers.submitMethod(driver,"//*[@name='btnK']",logger,"Google Search Button");
            //capture the result
            String results = Reusable_Actions_Loggers.getTextMethod(driver,"//*[@id='result-stats']",logger,"Search Result");
            String[] arrayResults = results.split(" ");
            Label label = new Label(1,i,arrayResults[1]);
            writeSheet.addCell(label);




            //end logger
            reports.endTest(logger);



        }//end of for loop

        writeFile.write();
        writeFile.close();






    }//end of test

    @AfterSuite
    public void CloseSession(){
        driver.quit();
        reports.flush();
    }







}// end of java class
