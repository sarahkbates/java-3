package lambda_streams;

import java.util.Arrays;
import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;

import static java.lang.Math.sqrt;

class Numbers {
    static List<Integer> nums = Arrays.asList(10,100,1000,5,50,500,3,30,300,7,70,700,1,10,100,25,250,2500);

    public static void main(String[] args) {
        //Part I :complete the static class methods that have been set up in this Numbers class java file.  Use streams to compute the results wheever possible.
        System.out.println(nums);
        System.out.println(isOdd(3));
        System.out.println(isEven(13));
        System.out.println(isPrime(3));
        System.out.println(added(nums));
        System.out.println(subtracted(nums));
        System.out.println(multiplied(nums));
        System.out.println(divided(nums));
        System.out.println(findMax(nums));
        System.out.println(findMin(nums));
        compare(nums);
        System.out.println(append(2398));


        //Part II - refactor all of the class methods to accept lambda expressions. You can put the lambda functions directly inside the method calls, or defined them first, then pass them into the methods. give them the same names as the static methods, but add the word 'lambda' in front of every lambda function:
        /* e.g.

        added(() -> {});

        OR

        lambdaAdd = () -> {};
        added(lambdaAdd);

        isOdd(() -> {});

        OR

        lambdaOdd = () -> {};
        isOdd(lambdaOdd);
        etc...

        */

        Processor<Integer, Boolean> lambdaIsOdd = (Integer i) -> i % 2 != 0;
        Processor<Integer, Boolean> lambdaIsEven = (Integer i) -> i % 2 == 0;
        Processor<Integer, Boolean> lambdaIsPrime = (Integer i) -> {
            boolean result = true;
            for (int x = 2; x <= sqrt(i); x++){
                if ((i % x) == 0){
                    result = false;
                    break;
                } else{
                    x++;
                }
            }
            return result;
        };

    }

    Processor<List<Integer>, Integer> lambdaAdded = (numbers) -> {
        int sum = 0;
        for (int i : numbers){
            sum += i;
        }
        return sum;
    };

    Processor<List<Integer>, Integer> lambdaSubtracted = (numbers) -> {
        int remainder = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++){
            remainder -= numbers.get(i);
        }
        return remainder;
    };

    Processor<List<Integer>, BigInteger> lambdaMultiplied = (numbers) -> {
        BigInteger product = BigInteger.valueOf(numbers.get(0));
        for (int i = 1; i < numbers.size(); i++){
            product = product.multiply(BigInteger.valueOf(numbers.get(i)));
        }
        return product;
    };

    Processor<List<Integer>, Double> lambdaDivided = (numbers) -> {
        double product = numbers.get(0);
        for (int i = 1; i<numbers.size(); i++) {
            product /= numbers.get(i);
        }
        return product;
    };

    Processor<List<Integer>, Integer> lambdaFindMax = (numbers) -> {
        int maxValue = Integer.MIN_VALUE;
        for(int i: numbers) {
            if(maxValue < i) {
                maxValue = i;
            }
        }
        return maxValue;
    };

    Processor<List<Integer>, Integer> lambdaFindMin = (numbers) -> {
        int minValue = Integer.MAX_VALUE;
        for(int i: numbers) {
            if (minValue > i) {
                minValue = i;
            }
        }
        return minValue;
    };

    Processor<List<Integer>, Integer> lambdaCompare = (numbers) -> {
        int j = 1;
        int compareValue = 0;
        for(int i=0; i<numbers.size()-1; i++) {
            compareValue = Integer.compare(numbers.get(i), numbers.get(j));
            System.out.println(numbers.get(i) + " compared to " + numbers.get(j) + ": " + compareValue);
            j++;
        }
        return compareValue;
    };

    Processor<Integer, Integer> lambdaAppend = (n) -> {
        ArrayList<Integer> newNums = new ArrayList<Integer>(nums);
        newNums.add(n);
        return n;
    };

    System.out.println(lambdaIsOdd.process(26));
    System.out.println(lambdaIsEven.process(26));
    System.out.println(lambdaIsPrime.process(10));
    System.out.println(lambdaAdded.process(nums));
    System.out.println(lambdaSubtracted.process(nums));
    System.out.println(lambdaMultiplied.process(nums));
    System.out.println(lambdaDivided.process(nums));
    System.out.println(lambdaFindMax.process(nums));
    System.out.println(lambdaFindMin.process(nums));
    lambdaCompare.process(nums);
    System.out.println(lambdaAppend.process(986));



interface Processor <T, R>{
    R process(T arg);
}

    static boolean isOdd(int i) {
        //determine if the value at the index i is odd.  return true if yes, return false if  no.
        return i % 2 != 0;
    }

    static boolean isEven(int i) {
        //determine if the value at the index i is even.  return true if yes, return false if  no.
        return i % 2 == 0;
    }

    static boolean isPrime(int i) {
         //determine if the value at the index i is a prime number.  return true if yes, return false if no.
         boolean result = true;
         for (int x = 2; x <= sqrt(i); x++){
             if((i % x) == 0){
                 result = false;
                 break;
             } else {
                 x++;
             }
         }
         return result;
    }

    static int added(List<Integer> numbers) {
        //add all the elements in the list.  return the sum.  
        int sum = 0;
        for(int i : numbers){
            sum += i;
        }
        return sum;
    }

    static int subtracted(List<Integer> numbers) {
        //subtract all the elements in the list. return the remainder.
        int remainder = numbers.get(0);
        for(int i = 1; i<numbers.size(); i++) {
            remainder -= numbers.get(i);
        }
        return remainder;
    }

    static BigInteger multiplied(List<Integer> numbers) {
        //multiply all the elements in the list. and return the product.
        BigInteger product = BigInteger.valueOf(numbers.get(0));
        for (int i = 1; i<numbers.size(); i++) {
            product= product.multiply(BigInteger.valueOf(numbers.get(i)));
        }
        return product;
    }

    static double divided(List<Integer> numbers) {
        //multiply all the elements in the list. and return the product.
        double product = numbers.get(0);
        for (int i = 1; i<numbers.size(); i++) {
            product /= numbers.get(i);
        }
        return product;
    }

    static int findMax(List<Integer> numbers) {
         //return the maximum value in the list.
         int maxValue = Integer.MIN_VALUE;
        for(int i: numbers) {
            if(maxValue < i) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    static int findMin(List<Integer> numbers) {
        //return the minimum value in the list.
        int minValue = Integer.MAX_VALUE;
        for(int i: numbers) {
            if (minValue > i) {
                minValue = i;
            }
        }
        return minValue;
    }

    static int compare(List<Integer> numbers) {
        //compare the values stored in the array at index position i and j.  
        //if the value at i is greater, return 1.  if the value at j is greater, return -1.  if the two values are equal, return 0.
        int j = 1;
        int compareValue = 0;
        for(int i=0; i<numbers.size()-1; i++) {
            compareValue = Integer.compare(numbers.get(i), numbers.get(j));
            System.out.println(numbers.get(i) + " compared to " + numbers.get(j) + ": " + compareValue);
            j++;
        }
        return compareValue;
    }

    static int append(int n) {
        //add a new value to the values list. return that value after adding it to the list.
        ArrayList<Integer> newNums = new ArrayList<Integer>(nums);
        newNums.add(n);
        return n;
    }

}

