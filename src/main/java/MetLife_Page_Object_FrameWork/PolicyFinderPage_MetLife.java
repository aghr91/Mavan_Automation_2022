package MetLife_Page_Object_FrameWork;

import All_Reusable_Methods.Reusable_Actions_Loggers_POM;
import All_Reusable_Methods.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PolicyFinderPage_MetLife extends Reusable_Annotations {
    //declare a local logger to your POM
    ExtentTest logger;
    public PolicyFinderPage_MetLife(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;

    }//end of constructor method

    //define all webElements we need per this case per use case
    @FindBy(xpath = "//label[@for='firstNamePf pc_sol_nom_sol']")
    WebElement clickFirstBox;

    @FindBy(xpath = "//input[@data-required='true']")
    WebElement EnterName;

    @FindBy(xpath =  "//label[@for='lastNamePf']")
    WebElement ClickSecondBox;

    @FindBy(xpath =   "//*[@id='lastNamePf']")
    WebElement SecondName;

    @FindBy(xpath =   "//input[@id='birthMonthPf']")
    WebElement BirthMonth;

    @FindBy(xpath =  "//input[@id='birthDayPf']")
    WebElement BirthDay;


    @FindBy(xpath =  "//input[@id='birthYearPf']")
    WebElement BirthYear;


    @FindBy(xpath = "//label[contains(text(),'Last 4 of SSN: (if known)')]")
    WebElement SSNBox;

    @FindBy(xpath = "//*[@id='ssnPf']")
    WebElement SSNNumber;

    //scroll page
    @FindBy(xpath = "//div[contains(text(),'Additional Information')]")
    WebElement scrollDown;

    @FindBy(xpath = "//select[@id='insuredLastResidenceStatePf']")
    WebElement clickState;

    // Boolean method
    @FindBy(xpath = "//*[@role='presentation']")
    WebElement robot;
//'form-field-container form-user-grp'
    @FindBy(xpath = "//button[@id='btnMainSearchPfSubmit']")
    WebElement submit;


    @FindBy(xpath = "//*[@class='contact-us__contact-form__sub-header normal']")
    WebElement CaptureText;


    //click on first on box

    public void setClickFirstBox(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,clickFirstBox,logger," click on firstName box");

    }//end of  setClickFirstBox

    //enter First Name
    public void EnterFirstName(String FirstName){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,EnterName,FirstName,logger," enter First Name");

    }//end of enter First Name

    //click on lastname on box
    public void setClickSecondBox(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,ClickSecondBox,logger," click on lastname box");

    }// end of click on lastname on box
    //enter Second Name
    public void EnterSecondName(String LastName){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,SecondName,LastName,logger," enter Second Name ");
    }// end of enter Second Name


    //enter birthday month
    public void EnterBirthMonth(String Month){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,BirthMonth,Month,logger," enter birth month");
    }// end of enter birthday month


    //enter birthday
    public void EnterBirthDay(String Day){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,BirthDay,Day,logger," enter birthday ");
    }// end of enter birthday


    //enter birth Year
    public void EnterBirthYear(String Year){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,BirthYear,Year,logger," enter birthYear ");
    }// end of enter birth Year

    //click on SSN box
    public void ClickSSNBox(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,SSNBox,logger," click on SSN box");
    }//end of click on SSN box

    // enter SSN Number
    public void EnterSSNNumber(String SSN){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,SSNNumber,SSN,logger,"  enter SSN Number");
    }// end of  enter SSN Number

    //scroll down
    public void SelectScroll(){
        Reusable_Actions_Loggers_POM.SelectScrollMethod(driver,scrollDown,logger);
    }//

    //select state from dropDown
    public void SelectState(String State) {
        Reusable_Actions_Loggers_POM.clickMethod(driver,clickState,logger,"select State");
         //declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='"+ State +"']"))).click();
        }catch (Exception e){
            System.out.println("Unable to select State " + e);
        }
    }//end of select State
    public void robotButton(){

        Reusable_Actions_Loggers_POM.clickMethod(driver,robot,logger," click on robot button");
    }
/*
    // verify check box
    public void SelectBoolean(){
        Reusable_Actions_Loggers_POM.click_BooleanMethod(driver,Boolean,logger,"select boolean");
    }//*/

    // click on submit button
    public void clickOnSubmit(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,submit,logger,"  click on submit button");
    }//end of  click on submit button

    // capture text
    public void CaptureNoMatch(){
        String CheckMatch= Reusable_Actions_Loggers_POM.getTextMethod(driver,CaptureText,logger," Capture Text No Match ");
        System.out.println("capture the subscription amount " + CheckMatch);
    }//end of capture the subscription amount








}//end of PolicyFinderPage_MetLife
