package All_Assignment;

public class HomeWork_2 {
    public static void main(String[] args) {
        ////create a dynamic array for 4 different States, iterate through the values but only print when
        // State is either Ney work or California

        String[] states = new String[5];
        states[0] = "New York";
        states[1] = "New Jersey";
        states[2] = "Pennsylvania";
        states[3] = "California";
        states[4] = "Florida";

        // using for loop and conditional statement
        for (int i = 0; i < states.length; i++){

            //if (states[i]=="New York"){
            if (states[i].toLowerCase().equals("new york")){
                System.out.println("The city that never sleep is " + states[i]);
            }
            //else if (states[i]== "California"){
            else if (states[i].toUpperCase().equals("CALIFORNIA")){
                System.out.println(" And the Golden State of USA is " + states[i]);
            }//end of condition

        }//end of for loop


    }//end of main method
}//end of java
