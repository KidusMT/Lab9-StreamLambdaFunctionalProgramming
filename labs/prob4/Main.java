package labs.prob4;

import java.util.stream.IntStream;

/**
 * 4. Implement a method
 * public static void printSquares(int num)
 * which creates an IntStream using the iterate method. The method prints to the console the first
 * num squares. For instance, if num = 4, then your method would output 1, 4, 9, 16. Note: You
 * will need to come up with a function to be used in the second argument of iterate.
 *
 * @author KidusMT
 * Date: 4/8/2021
 * StdID: 612361
 */
public class Main {

    public static void main(String[] args) {
        printSquares(4);
    }

    public static void printSquares(int num) {

        IntStream.iterate(1, i -> i + 1) // generates: 1, 2, 3, 4
                .map(i -> i * i)              // will multiple itself by itself and gets the square value for each items
                .limit(num)                   // will limit the generation for "num" number of values
                .forEach(System.out::println);// prints each value

        //IntStream.iterate(1, i -> i <= Math.pow(num, 2), i -> i * 2).forEach(System.out::println);
    }
}
