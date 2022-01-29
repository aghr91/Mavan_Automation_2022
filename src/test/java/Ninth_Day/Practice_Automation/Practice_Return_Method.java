package Ninth_Day.Practice_Automation;

public class Practice_Return_Method {
    public static void main(String[] args) {
        //define int variable
        int a = 2;
        int b = 3;
     //create int to store reusable method
        int value = Reusable_Method_Practice.addReturn(a,b);
        System.out.println( " My result is " + (value+200));

    }// end of main
}//end of java class
