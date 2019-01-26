
package executiontime;

/**
 * Project: Execution Time
 * Tasks: 1) Determines time taken to find primes within a set value for 3 values
 *           using 4 different methods
 *        2) Prints results in a formatted table
 * @author Justin Mangan
 * Date 29 March 2018
 */

public class TestTimer {

    /**
     * @param args the command line arguments
     * Note: all other class methods and class fields in package must be static
     *     in order for main (static context) to access their methods and fields
     */
    
    public static void main(String[] args) {
        // Values for prime search
        Timer.setStart(8_000_000);
        Timer.setEnd(18_000_000);
        Timer.setIncr(2_000_000);

        // Call to Timer for each prime formula
        Timer.executeTimer(1, "\nListing 22.5\t|", true);
        Timer.executeTimer(2, "\nListing 22.6\t|", false);
        Timer.executeTimer(3, "\nListing 22.7\t|", false);
        Timer.executeTimer(4, "\nBitSet Sieve\t|", false);
        System.out.println("\n");
    }
}
