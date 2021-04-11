package labs.prob2;

import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 2. You have a Stream of Integers called myIntStream and you need to output both the
 *  maximum and minimum values. Write compact code that efficiently accomplishes this.
 *
 * @author KidusMT
 * Date: 4/8/2021
 * StdID: 612361
 */
public class Main {

    public static void main(String[] args) {
        Stream<Integer> myIntStream = Stream.of(1, 2, 3, 4, 5);

        // this is the BEST solution. Has methods for: count, min, max, sum and so on...
        IntSummaryStatistics intsum = myIntStream.collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Max: " + intsum.getMax() + " Min: " + intsum.getMin());


        // We have to uncomment one at the same time. Since the stream will be consumed when calling "get()"
        // 1) for the maximum value
//        Optional<Integer> max = myIntStream.max(Integer::compareTo);
//        System.out.println("maximum: " + max.get());


        // 2) for the minimum value
//        Optional<Integer> min = myIntStream.min(Integer::compareTo);
//        System.out.println("minimum: " + min.get());

    }
}
