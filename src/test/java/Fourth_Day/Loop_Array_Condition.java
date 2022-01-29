package Fourth_Day;

public class Loop_Array_Condition {
    public static void main(String[] args) {
        //create a dynamic array 4 different cities, iterate through the values but only print when city is brooklyn or queens
        String[] cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Manhattan";
        cities[2] = "Bronx";
        cities[3] = "Queens";

       /* int i = 0;
        while (i < cities.length) {
            //two if conditions
            //when you are not sure if the value is in upper case , lower case or mixed case
            if (cities[i].toLowerCase().equals("brooklyn")) {
                System.out.println("City is " + cities[i]);
            } else if (cities[i].toUpperCase().equals("QUEENS")) {
                System.out.println("City is " + cities[i]);
            }//end of conditions

            i++;


        }//end While loop*/

        // using for loop for same condition
        for (int i = 0; i < cities.length;i++){
            //two if condition
            if (cities[i]== "Brooklyn"){
                System.out.println("The City is " +cities[i]);
            }else if (cities[i]== "Manhattan")
                System.out.println(" And also other city is " +cities[i]);
        }//end for loop


    }// end main method
}//java class
