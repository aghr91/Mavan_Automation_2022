package Ninth_Day.Practice_Automation;

public class Practice_Split_Example {

    public static void main(String[] args) {

        //create a single string
        String message = "Welcome to Automation Class to learn java";
        ////Declare the Spring array to  split message to print out only class
        String[] splitMassage = message.split(" ");
        //print
        System.out.println(" The Tittle is " +splitMassage[6]);

    }//end of main method
}//end of java class
