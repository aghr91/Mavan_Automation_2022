package Second_Day;

public class DynamicArray {

    public static void main(String[] args) {

        //create a String dynamic array for countries
        String[] countries = new String[6]; //set the limit/boundaries for array
        countries[0] ="usa";
        countries[1] ="Bangladesh";
        countries[2] ="Pakistan";
        countries[3] ="India";
        countries[4] ="Asia";
        countries[5] ="Canada";
        System.out.println("My country is " + countries[3]);



        //integer dynamic Array
        int[] houseNumber = new int[6];
        houseNumber[0] = 222;
        houseNumber[1] = 222;
        houseNumber[2] = 222;
        houseNumber[3] = 222;
        houseNumber[4] = 222;
        houseNumber[5] = 222;


        System.out.println("My HouseNumber is " + houseNumber[5]);

        System.out.println("My Country is " + countries[5] + " And House Number is " + houseNumber[4]);

    }// end of main Method
}//end of java class
