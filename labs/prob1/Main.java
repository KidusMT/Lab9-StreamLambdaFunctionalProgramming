package labs.prob1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1. You have a Stream of Strings called stringStream consisting of the values “Bill”,
 * “Thomas”, and “Mary”. Write the one line of code necessary to print this stream to the
 * console so that the output looks like this:
 *                  Bill, Thomas, Mary
 *
 * @author KidusMT
 * Date: 4/8/2021
 * StdID: 612361
 */
public class Main {

    public static void main(String[] args) {
        Stream<String> stringStream = Arrays.stream(new String[]{"Bill", "Thomas", "Mary"});
//        System.out.println(stringStream.reduce("", (s, s2) -> s+""+s2+", "));    // output-> Bill, Thomas, Mary,

        // The correct answer is below
        System.out.println(stringStream.collect(Collectors.joining(", ")));// output -> Bill, Thomas, Mary
    }
}
