package Second_Day;

public class WhileLoop_Array {
    public static void main(String[] args) {

        String[] countries = new String[5];
        countries[0] = "Bangladesh";
        countries[1] = "USA";
        countries[2] = "Canada";
        countries[3] = "UK";
        countries[4] = "Dubai";

        int[] zipcode = new int[5];
        zipcode[0] = 11235;
        zipcode[1] = 11228;
        zipcode[2] = 11230;
        zipcode[3] = 11234;
        zipcode[4] = 11238;


        //declare and define initial start point
        int i=0;
        //define while loop with your end point (condition)
        while(i< countries.length){
            System.out.println("My Countries are " +countries[i] +  " My zipcode is " +zipcode[i]);



            i=i+1;


        }//end of while loop


    }//end of main


}//end of java class
