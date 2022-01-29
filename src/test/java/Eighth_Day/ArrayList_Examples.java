package Eighth_Day;

import java.util.ArrayList;

public class ArrayList_Examples {
    public static void main(String[] args) {
       //array list is a  resizable array which means we don't need to add length to add more array values
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        //
        ArrayList<Integer> streetNumber = new ArrayList<>();
        streetNumber.add(444);
        streetNumber.add(466);
        streetNumber.add(469);

        //print
        System.out.println("My third city is " +cities.get(2) + " And Street Number is " +streetNumber.get(1));


    }//end of main method
}//end of java class
