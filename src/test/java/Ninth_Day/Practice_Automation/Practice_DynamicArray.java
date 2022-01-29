package Ninth_Day.Practice_Automation;

public class Practice_DynamicArray {

    public static void main(String[] args) {

        //crate a dynamic array for countries using String
        String[] countries = new String[6];
        countries[0] = "USA";
        countries[1] = "Li";
        countries[2] = "Canada";
        countries[3] = "Bangladesh";
        countries[4] = "Japan";
        countries[5] = "India";

        // crate integer variable using dynamic array

        int[] lineNumber = new int[6];
        lineNumber[0]= 333;
        lineNumber[1]= 4444;
        lineNumber[2]= 55;
        lineNumber[3]= 666;
        lineNumber[4]= 33376;
        lineNumber[5]= 2345;

        //print third countries name and fifth line number
        System.out.println("My countries name is " + countries[2] + " and line number is " + lineNumber[4]);

    }//end of main method
}//end of java class
