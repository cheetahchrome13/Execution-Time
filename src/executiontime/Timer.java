
package executiontime;

import java.util.ArrayList;

/**
 * Class: Timer
 * Tasks: 1) Determines time taken to find primes within a set value
 * @author Justin Mangan
 * Date 29 March 2018
 */

public class Timer {
    
    private static int start;
    private static int end;
    private static int incr;
    
    public static void executeTimer(int x, String label, boolean isNew){
        
        // ArrayList for counts
        ArrayList<Integer> counts = new ArrayList<>();
        int count = 0;
        
        // Call TableMaker to print table
        TableMaker.printTable(label, isNew);
        
        // Determines time lapsed executing method to find and count primes
        for (int i = start; i <= end; i += incr) {
            double startTime = System.currentTimeMillis();
            
            // Call to determine which method to call, get count
            count = getMethod(x, i);

            double endTime = System.currentTimeMillis();
            double executionTime = (endTime - startTime) / 1000;
            counts.add(count);
           
            // Call TableMaker to print time
            TableMaker.printTime(executionTime, start, i);           
        }
        // Call TableMaker to print table row and prime counts
        TableMaker.printTable("\nPrime count\t|");
        TableMaker.printCounts(counts);            
    }
    
    // Determine which method to call, return count
    public static int getMethod(int x, int i){
        int count = 0;
        switch(x){
            case 1:
                count = PrimeNumbers.getPrime1(i);
                break;
            case 2:
                count = PrimeNumbers.getPrime2(i);
                break;
            case 3:
                count = PrimeNumbers.getPrime3(i);
                break;
            case 4:
                count = PrimeNumbers.getPrime4(i);
                break;    
            default:
                break;
        }
        return count;
    }
    
    // Getters/Setters
    /**
     * @return the start
     */
    public static int getStart() {
        return start;
    }

    /**
     * @param aStart the start to set
     */
    public static void setStart(int aStart) {
        start = aStart;
    }

    /**
     * @return the end
     */
    public static int getEnd() {
        return end;
    }

    /**
     * @param aEnd the end to set
     */
    public static void setEnd(int aEnd) {
        end = aEnd;
    }

    /**
     * @return the increment
     */
    public static int getIncr() {
        return incr;
    }

    /**
     * @param aIncr the increment to set
     */
    public static void setIncr(int aIncr) {
        incr = aIncr;
    }
}
