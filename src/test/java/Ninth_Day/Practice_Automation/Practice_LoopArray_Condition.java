package Ninth_Day.Practice_Automation;

import java.util.Locale;

public class Practice_LoopArray_Condition {
    public static void main(String[] args) {
        //create a dynamic array for 4 different cities, iterate through the values but only print when
           //city is either Brooklyn or Queens
        String[] cities = new String[4];
           cities[0] = "Brooklyn";
           cities[1] = "Manhattan";
           cities[2] = "Queens";
           cities[3] = "Bronx";
        for (int i=0; i< cities.length; i++){
            //two if conditions
            if(cities[i].toLowerCase().equals("brooklyn")){
                System.out.println( "City is " + cities[i]);
            } else if (cities[i].toUpperCase().equals("QUEENS")){
                System.out.println("My city is " +cities[i]);
            }//end of condition
        }//end of loop
    }//end of main

}//end of java
