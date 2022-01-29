package Hulu_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Actions_Loggers_POM;
import All_Reusable_Methods.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountHulu extends Reusable_Annotations{
    //declare a local logger to your pom class
    ExtentTest logger;
    public CreateAccountHulu(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//end of the constructor method

    //define all the WebElement we need for this page per use case
    @FindBy(xpath = "//*[@id='email']")
    WebElement EmailInput;

    @FindBy(xpath = "//*[@id ='password']")
    WebElement PasswordInput;

    @FindBy(xpath = "//*[@id='firstName']")
    WebElement firstNameInput;

    @FindBy(xpath = "//*[contains(@class,'field__month')]")
    WebElement BirthMonthSelect;

    @FindBy(xpath = "//*[contains(text(),'Day')]")
    WebElement BirthDaySelect;

    @FindBy(xpath = "//*[contains(text(),'Year')]")
    WebElement BirthYearSelect;


    @FindBy(xpath = "//*[contains(text(),'Select')]")
    WebElement GenderSelect;

    @FindBy(xpath = "//*[contains(text(),'CONTINUE')]")
    WebElement ContinueButton;



    //enter email address
    public void InputEmail(String emails){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,EmailInput,emails,logger,"Enter Email Address");
    }//end of enter email address

    //enter password
    public void InputPassword(String passWord){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,PasswordInput,passWord,logger,"Enter PassWord");
    }//end of enter passWord

    //enter first name
    public void InputFirstName(String name) {
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,firstNameInput,name,logger,"enter First Name");
    }//end of enter first name

    //select birth month from dropDown
    public void SelectBirthMonth(String month) {
        Reusable_Actions_Loggers_POM.clickMethod(driver,BirthMonthSelect,logger,"select birth month");
        // //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        logger.log(LogStatus.INFO,"select birth month from dropDown");
        try {
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ month +"']"))).click();
        }catch (Exception e){
            System.out.println("Unable to select Birth Month " + e);
            logger.log(LogStatus.FAIL,"Unable to select Birth Month " + e);

        }
    }//end of select birthMonth

    //select birthDay from dropDown
    public void SelectBirthDay(String day) {
        Reusable_Actions_Loggers_POM.clickMethod(driver,BirthDaySelect,logger,"select birthDay");
        // //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        try {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ day +"']"))).click();
        }catch (Exception e){
            System.out.println("Unable to select Birth Day " + e);
        }
    }//end of select birthDay


    //select birth year from dropDown
    public void SelectBirthYear(String year) {
        Reusable_Actions_Loggers_POM.clickMethod(driver,BirthYearSelect,logger,"select birth Year");
        // //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ year +"']"))).click();
        }catch (Exception e){
            System.out.println("Unable to select Birth Day " + e);
        }
    }//end of select birth Year



    //select Gender from dropDown
    public void SelectGender(String gender) {
        Reusable_Actions_Loggers_POM.clickMethod(driver,GenderSelect,logger,"select Gender");
        // //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
              wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ gender +"']"))).click();
        }catch (Exception e){
            System.out.println("Unable to select Gender " + e);
        }
    }//end of select Gender



    //click on continue button
    public void clickOnContinue(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,ContinueButton,logger," continue button");
    }//end of click continue button














}//end of class CreateAccountHulu
