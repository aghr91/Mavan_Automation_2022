package Fourth_Day;

public class Split_Command {
    public static void main(String[] args) {
        //Create a single string
        String message = "My Name is Rabu";

        //Declare the Spring array to  split message to print out only Rabu
        String[] arrayMessage = message.split(" ");
        //print
        System.out.println(" Result is " + arrayMessage[3]);

    }//end main method
}//end of java class
