
package executiontime;

import java.util.ArrayList;

/**
 * Class: TableMaker
 * Tasks: 1) Prints results in a formatted table
 * @author Justin Mangan
 * Date 29 March 2018
 */

public class TableMaker {
    
    private static int start = Timer.getStart();
    private static int end = Timer.getEnd();
    private static int incr = Timer.getIncr();
    
    // Print table headings, elements, and label
    public static void printTable(String label, boolean isNew){       
        if(isNew){
            System.out.printf("\033[31m%60S%n", "execution time");
            for(int i = 0; i < 108; i++){
            System.out.print(i == 16 ? "|" : "-");
            }    
            System.out.print("\nUpper Limit\t|");
            for (int n = start; n <= end; n += incr) {
                System.out.printf("%,15d", n);
            }
        }
        System.out.println();
        for(int i = 0; i < 108; i++){
            System.out.print(i == 16 ? "|" : "-");
        }    
        System.out.print(label);
    }
    
    // Overloaded method
    public static void printTable(String label){
        System.out.println();
        for(int i = 0; i < 108; i++){
            System.out.print(i == 16 ? "|" : "-");
        }    
        System.out.printf("\033[1m%s\033[0m", label);
    }
    
    // Print time for each execution
    public static void printTime(double executionTime, int start, int i){
        if(i == start) {
            System.out.printf("\033[31m%12.3f%c\033[0m", executionTime, 's');
        }
        else{         
            System.out.printf("\033[31m%14.3f%c\033[0m", executionTime, 's');
        }
    }
    
    // Print counts
    public static <E> void printCounts(ArrayList<E> counts){
        int i = 0;
        for(E count : counts){
            if(i == 0){
                System.out.printf("\033[1m%13d\033[0m", count);
            }
            else{
                System.out.printf("\033[1m%15d\033[0m", count); 
            }
            i++;
        }
    }
}
