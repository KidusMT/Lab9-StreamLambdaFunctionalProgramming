package labs.prob5;

import java.util.Arrays;
import java.util.stream.Stream;


/**
 * 5. Create a method
 * Stream<String> streamSection(Stream<String> stream, int m, int n) which extracts a
 * substream from the input stream stream consisting of all elements from position m to position n,
 * inclusive; you must use only Stream operations to do this. You can assume 0 <= m <= n.
 *
 * @author KidusMT
 * Date: 4/8/2021
 * StdID: 612361
 */
public class Section {

    public static Stream<String> streamSection(Stream<String> stream, int from, int to) {
        // Implement the code
        if (from <= 0 || to <= 0) return Stream.of("'m' and 'n' should be greater than 0 value.");
        if (from > to) return Stream.of("'m' should be lower or equal to 'n'.");
        else return stream.skip(from - 1) // we're telling the stream to skip elements from list of streams
                .limit((to+1) - from);               // limiting oue list to this index since we have

    }

    public static void main(String[] args) {
        // Make three calls for the streamSection() method with different inputs
        // use nextStream() method to supply the Stream input as a first argument in streamSection() method
        streamSection(nextStream(), 3, 5).forEach(System.out::println);
    }

    //support method for the main method -- for testing
    private static Stream<String> nextStream() {
        return Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii").stream();
    }
}
