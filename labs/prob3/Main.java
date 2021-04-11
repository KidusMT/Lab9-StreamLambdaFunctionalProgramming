package labs.prob3;

import java.util.List;

/**
 * 3. Implement a given method requirement using Lambdas and streams in a Java 8 way.
 * public int countWords(List<String> words, char c, char d, int len)
 * which counts the number of words in the input list words that have length equal to len, that
 * contain the character c, and that do not contain the character d.
 *
 * @author KidusMT
 * Date: 4/8/2021
 * StdID: 612361
 */
public class Main {

    public static void main(String[] args) {
        List<String> names = List.of("Kidus", "Mamuye", "Tekeste");
        Main a = new Main();
        System.out.println(a.countWords(names, 'K', 'B', 5));
    }

    public int countWords(List<String> words, char c, char d, int len) {
        return (int) words.stream() // casted to "int" though its returning "long"
                .filter(s -> s.contains(Character.toString(c)))
                .filter(s -> !s.contains(Character.toString(d)))
                .filter(s -> s.length() == len)
                .count();
    }
}
