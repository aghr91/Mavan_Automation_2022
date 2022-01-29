package Ninth_Day.Practice_Automation;

import java.util.ArrayList;

public class Practice_ArrayList {

    public static void main(String[] args) {

        //create String array list for countries
        ArrayList<String> country = new ArrayList<>();
        country.add("Bangladesh");
        country.add("USA");
        country.add("Canada");
        country.add("Japan");

        //create integer array list for house number
        ArrayList<Integer> houseNumber = new ArrayList<>();
        houseNumber.add(223);
        houseNumber.add(444);
        houseNumber.add(5555);
        houseNumber.add(777);

        //print the second country name and third house number
        System.out.println("The country name is " + country.get(1) + " And house  number is " + houseNumber.get(2));
    }//end of main method

}//
