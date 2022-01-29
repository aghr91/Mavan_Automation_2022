package Second_Day;

public class ForLoop_Array {
    public static void main(String[] args) {
        //create String dynamic array
        String[] borough = new String[7];//set limit/boundaries for array

        borough[0] = "Usa";
        borough[1] = "Bangladesh";
        borough[2] = "India";
        borough[3] = "pakistan";
        borough[4] = "canada";
        borough[5] = "Austria";
        borough[6] = "Iran";

        //
        for (int i = 0; i < borough.length; i++){
            System.out.println("Our Current Borough is " +borough[i]);
        }//end for loop

    }//end method
}//end java class
