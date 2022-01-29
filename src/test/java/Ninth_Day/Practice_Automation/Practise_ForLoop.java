package Ninth_Day.Practice_Automation;

public class Practise_ForLoop {

    public static void main(String[] args) {

        //iterate all borough using for loop

        String[] borough;
        borough = new String[6];
        borough[0] = "Brooklyn";
        borough[1] = "Staten Island";
        borough[2] = "Manhattan";
        borough[3] = "queens";
        borough[4] = "Bronx";
        borough[5] = "LI";

        // using for loop condition for iterate all boroughs
        for (int i=0; i < borough.length;i++){
            System.out.println( "My current borough is " +borough[i] );

        }//end of for loop


    }//end of main method
}//end of java class
