
package executiontime;

import java.util.*;

/**
 * Class: PrimeNumbers
 * Tasks: 1) Provides 4 different methods of finding primes, returns prime count
 * @author Justin Mangan
 * Date 29 March 2018
 */
 
public class PrimeNumbers { 
    // First formula for finding primes (Listing 22.5)
    public static int getPrime1(int n) {
        int count = 0;
        int number = 2;
        while (number <= n) {
            boolean isPrime = true;
            for (int divisor = 2; divisor <= (int) (Math.sqrt(number)); divisor++) {
                if (number % divisor == 0) {
                    isPrime = false; 
                    break;
                }
            }
            if (isPrime) {
                count++;
            }
            number++;
        }
        return count;
    }
    
    // Second formula for finding primes (Listing 22.6)
    public static int getPrime2(int n) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        int count = 0;
        int number = 2;
        int squareRoot = 1;
        while (number <= n) {
            boolean isPrime = true;
            if (squareRoot * squareRoot < number){
                squareRoot++;
            }
            for (int k = 0; k < list.size() && list.get(k) <= squareRoot; k++) {
                if (number % list.get(k) == 0) {
                isPrime = false;
                break;
                }     
            }
            if (isPrime) {
                count++; 
                list.add(number);
            }
            number++;
        }
        return count;
    }
    
    // Third formula for finding primes (Listing 22.7)
    public static int getPrime3(int n) {        
        boolean[] primes = new boolean[n + 1];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }
        for (int k = 2; k <= n / k; k++) {
            if (primes[k]) {
                for (int i = k; i <= n / k; i++) {
                    primes[k * i] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }
    
    // Fourth formula for finding primes (using BitSet for max efficiency)
    public static int getPrime4(int n) {
        /* Code to save primes to an ArrayList. ArrayList could be private 
            static class field w/ getters/setters */
//        int max = (int) (1.25506 * n / Math.log(n));
//        ArrayList<Integer> primes = new ArrayList<Integer>(max);
//        if (n >= 2)
//            result.add(2);

        int size = (n - 1) / 2;
        BitSet bits = new BitSet(size);

        int i = 0;
        while (i < size) {
            int p = 3 + (2 * i);
//            primes.add(p);

            for (int j = i + p; j < size; j += p)
                bits.set(j);

            i = bits.nextClearBit(i + 1);         
        }
        int count = (size + 1) - bits.cardinality();
        return count;
    }
}
