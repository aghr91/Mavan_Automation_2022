package All_Assignment;

public class HomeWork_1 {

    public static void main(String[] args) {
        //using dynamic array for Zipcodes
        String[] zipcode = new String[5];
        zipcode[0] = "11235";
        zipcode[1] = "11228";
        zipcode[2] = "11230";
        zipcode[3] = "11234";
        zipcode[4] = "11238";

        // using dynamic array for street Number

        int[] streetNumber = new int[6];
        streetNumber[0]= 333;
        streetNumber[1]= 4444;
        streetNumber[2]= 55;
        streetNumber[3]= 666;
        streetNumber[4]= 33376;
        streetNumber[5]= 2345;

        //iterate all zipcodes and street number using for loop condition

        for (int i = 0; i< zipcode.length;i++){
            System.out.println(" My zipcode is " + zipcode[i] + " And Street number is " + streetNumber[i]);

        }//end of for loop



        //declare and define initial start point
        int i=0;
        //define while loop with your end point (condition)
        while(i< zipcode.length){
            System.out.println("My Street number is " + streetNumber[i] +  " And zipcode is " + zipcode[i]);



            i=i+1;



        }//end of While loop



    }//end of main method


}//end of java class



