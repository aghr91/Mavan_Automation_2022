package All_Reusable_Methods;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class Abstract_Class {
   public static WebDriver driver;
   public static ExtentReports reports;
   public static ExtentTest logger;

    @BeforeSuite
    public void setTheDriverAndReport(){
        driver = Reusable_Actions_Loggers.setDriver();
        reports= new ExtentReports("src/main/java/HTML_Report/Automation_Result"+ Reusable_Actions_Loggers_POM.getDateTime()+".html",true);
    }//end of before suite

    @BeforeMethod
  public void Test_Reports(Method methodName){
        logger = reports.startTest(methodName.getName());
    }//end of before method


    @AfterMethod
    public void endTestMethod(){
        reports.endTest(logger);
    }//end of after method


    @AfterSuite
    public void endSession(){
        reports.flush();
        driver.quit();
    }//end of after suite



}//end of abstract class
