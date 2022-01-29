package All_Reusable_Methods;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Reusable_Actions_Loggers_POM {
    //create a reusable method for WebDriver and chrome options
    public static WebDriver setDriver(){
        //setup chrome driver
        WebDriverManager.chromedriver().setup();
        //declare and define the chrome options
        ChromeOptions options = new ChromeOptions();
        //declare all the arguments you need
        //to maximize my driver
        options.addArguments("start-maximized");
        //options.addArguments("fullscreen"); //for mac users
        //set as incognito mode
        options.addArguments("incognito");
        //popUP remove
        //options.addArguments("disable-popup");
        //set as headless(running the driver on background)
        //options.addArguments("headless");
        //define the web driver you are using
        WebDriver driver = new ChromeDriver(options);
        return  driver;
    }//end of webdriver method

    //method to hover on any web element
    public static void mouseHover(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Hovering on element " + elementName);
        logger.log(LogStatus.INFO,"Hovering on element " + elementName);
        try {
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.visibilityOf((xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to hover on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of hover method


    //creating void click method for any web element
    public static void clickMethod(WebDriver driver, WebElement xpath, ExtentTest logger,String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Clicking on element " + elementName);
        logger.log(LogStatus.INFO,"Clicking on element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOf((xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to click on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of click method

    //creating void submit method for any web element
    public static void submitMethod(WebDriver driver, WebElement xpath, ExtentTest logger,String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Submitting on element " + elementName);
        logger.log(LogStatus.INFO,"Submitting on element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOf((xpath))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to submit on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of submit method


    //creating void sendkeys method for any web element
    public static void sendKeysMethod(WebDriver driver, WebElement xpath, String userData, ExtentTest logger,String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Typing on element " + elementName);
        logger.log(LogStatus.INFO,"Typing on element " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf((xpath)));
            //clear first
            element.clear();
            //enter user data
            element.sendKeys(userData);
        } catch (Exception e) {
            System.out.println("Unable to type on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to type on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of click sendKeysMethod

    //creating return getText method for any text web element
    public static String getTextMethod(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName){
        //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Capturing text on element " + elementName);
        //declare a global variable to capture the text so I can return it
        String result = null;
        logger.log(LogStatus.INFO,"Capturing text on element " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf((xpath)));
            //capture text
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }
        return result;
    }//end of click getTextMethod

    //method to capture screenshot when logger fails
    public static void getScreenShot(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots/";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occured while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

//
    public static String getDateTime() {
        SimpleDateFormat sdfDateTime;
        String strDateTime;
        sdfDateTime = new SimpleDateFormat("yyyyMMdd'_'HHmmss'_'SSS");
        Date now = new Date();
        strDateTime = sdfDateTime.format(now);
        return strDateTime;
    }//


    //method to Mouseclick on an element
    public static void mouseClick(WebDriver driver,WebElement locator, ExtentTest logger,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Mouse clicking a value on element " + elementName);

            logger.log(LogStatus.INFO,"Mouse clicking a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.visibilityOf((locator)));
            actions.moveToElement(element).perform();
        } catch (Exception err) {
            System.out.println("Unable to mouse click element " + elementName + " " + err);
            logger.log(LogStatus.FAIL,"Unable to mouse click element " + elementName + " " + err);
            getScreenShot(driver,elementName,logger);



        }
    }//end of Mouse click method

    //method for type and submit
    public static void typeAndSubmit(WebDriver driver,WebElement locator, String userInput,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            System.out.println("Entering a value on element " + elementName);
            logger.log(LogStatus.INFO,"Entering a value on element " + elementName);
            WebElement element = wait.until(ExpectedConditions.visibilityOf((locator)));
            element.clear();
            element.sendKeys(userInput);
            Thread.sleep(1000);
            element.sendKeys(Keys.ENTER); //this is another way to submit to an element using key event
        } catch (Exception err) {
            System.out.println("Unable to enter on element " + elementName + " " + err);
            logger.log(LogStatus.FAIL,"Unable to enter on element " + elementName + " " + err);
            getScreenShot(driver,elementName,logger);



        }
    }//end of type and submit method

    // create click by index method

    public static void clickByMultiLinks(WebDriver driver, List<WebElement> locator,int indexNumber, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,8);
        try{
            System.out.println("Clicking on element ");
            logger.log(LogStatus.INFO,"Clicking on element");

           wait.until(ExpectedConditions.visibilityOf(locator.get(indexNumber))).click();

        } catch (Exception err) {
            System.out.println("Unable to click on element " + err);
            logger.log(LogStatus.FAIL,"Unable to click on element " + err);
            getScreenShot(driver,elementName,logger);


        }
    }//end of click by multi links


    public static void clickByIndex(WebDriver driver,List<WebElement> locator,int indexNumber,ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,9);
        try{
            System.out.println("Clicking on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking on element" + elementName);

            wait.until(ExpectedConditions.visibilityOfAllElements(locator)).get(indexNumber).click();

        } catch (Exception err) {
            System.out.println("Unable to click on element " + err);
            logger.log(LogStatus.FAIL,"Unable to click on element " + err);
            getScreenShot(driver,elementName,logger);


        }
    }//end of click by index method

    // method to select from drop down menu
    public static void dropDownMenu (WebDriver driver, WebElement locator,ExtentTest logger, String dropDownOption, String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);

        try {
            System.out.println("selecting " + elementName);
            logger.log(LogStatus.INFO,"select value from dropdown " + elementName);

            WebElement dropDown = wait.until(ExpectedConditions.visibilityOf((locator)));
            Select selectDropDown = new Select(dropDown);
            selectDropDown.selectByVisibleText(dropDownOption);
            //selectDropDown.deselectByIndex(10);

        }catch (Exception e){
            System.out.println("Unable to select from dropdown" + elementName + "Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to select from dropdown " + elementName + "Error:" + e);
            getScreenShot(driver,elementName,logger);

        }//end Exception

    }//end dropdown
    //create javaScript for scroll page

    public static void scrollMethod(WebDriver driver, String x, String y,ExtentTest logger) {
        System.out.println(" scroll the page ");
        logger.log(LogStatus.INFO, "Scroll the Page");
        try {

            JavascriptExecutor Ajse = (JavascriptExecutor) driver;

            Ajse.executeScript("scroll(" + x + "," + y + ")");
        } catch (Exception e) {
            System.out.println("Unable to  scroll page ");
        }

    }//end of scroll method


    //remove popUp from page
    public static void click_popUp(WebDriver driver, WebElement locator,ExtentTest logger,String elementName){
        //define explicit wait
        WebDriverWait wait = new WebDriverWait(driver,7);
        try{
            System.out.println("Clicking on element " + elementName);
            logger.log(LogStatus.INFO,"Clicking on element " + elementName);
            wait.until(ExpectedConditions.visibilityOf((locator))).click();

        }catch (Exception err){
            System.out.println("Pop up didn't appear. proceeding to next step ");
            logger.log(LogStatus.PASS,"Pop up didn't appear. proceeding to next step " );
            getScreenShot(driver,elementName,logger);

        }//end of exception

    }//end of click Popup method







}//end of java class
