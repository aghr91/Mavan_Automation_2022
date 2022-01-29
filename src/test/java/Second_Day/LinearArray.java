package Second_Day;

public class LinearArray {
    public static void main(String[] args) {

        //define the variable first
        String[] cities, zipcode;

        //define the linear array for cities
        cities = new String[]{"Brooklyn","Manhattan" ,"Staten Island" , "Queens" , "Bronx"};

        //define the linear array for Zipcode
        zipcode = new String[]{"11235", "11228", "11218" , "11210", "11238"};

        //define the variable first
        int[] StreetNumber ;

        //declare the int Array for Street Number
        StreetNumber = new int[]{ 22,33,44,55,66};

        //Print the First cities and First Variable and also second zipcode

        System.out.println("My First city is " + cities[0] + " My First Street Number is " + StreetNumber[0] + " And my Zipcode is " + zipcode[1]);


    }//end of main method

}//end of java class
