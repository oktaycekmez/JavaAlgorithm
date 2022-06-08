package org.barons.prime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Oktay CEKMEZ
 * Date: 8.06.2022
 * Time: 13:15
 */
public class Prime {
    private static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    //greatest common denominator
    private static int gcd(List<Integer> input) {
        int result = input.get(0);
        for (int i = 1; i < input.size(); i++) result = gcd(result, input.get(i));
        return result;
    }


    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
    //least common multiple
    private static int lcm(List<Integer> input) {
        int result = input.get(0);
        for (int i = 1; i < input.size(); i++) result = lcm(result, input.get(i));
        return result;
    }

    public static Map<Integer, Integer> getPrimeFactors(int number) {
        int absNumber = Math.abs(number);

        Map<Integer, Integer> primeFactorsMap = new HashMap<Integer, Integer>();

        for (int factor = 2; factor <= absNumber; factor++) {
            while (absNumber % factor == 0) {
                Integer power = primeFactorsMap.get(factor);
                if (power == null) {
                    primeFactorsMap.put(factor, 1 );
                }else {
                    primeFactorsMap.put(factor, ++power);
                }
                absNumber /= factor;
            }
        }

        return primeFactorsMap;
    }

    public static boolean isPrime(int number) {
        // Even numbers
        if(number == 1){
            return false;
        }
        if (number % 2 == 0) {
            return number == 2;
        }
        // Odd numbers
        int limit = (int)Math.sqrt(number);
        for (int i = 3; i <= limit; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(5));
    }

}
