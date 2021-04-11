package labs.prob6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 6. Implement a method
 * public Set<String> union(List<Set<String>> sets)
 * by creating a stream pipeline that transforms a list of sets (of type String) into the union
 * of those sets. Make use of the reduce method for streams.
 * <p>
 * Example: The union method should transform the list [{“A”, “B”}, {“D”}, {“1”, “3”,“5”}]
 * to the set {“A”, “B”, “D”, “1”, “3”, “5”}.
 *
 * @author KidusMT
 * Date: 4/8/2021
 * StdID: 612361
 */
public class Main {

    public static void main(String[] args) {
        Main a = new Main();
        System.out.println(a.union(List.of(
                new HashSet<>(Arrays.asList("A", "B")),
                new HashSet<>(Arrays.asList("D")),
                new HashSet<>(Arrays.asList("1", "3", "5")))).stream().collect(Collectors.toList()));

    }

    public Set<String> union(List<Set<String>> sets) {
//        return sets.stream().reduce(new HashSet<>(), (strings, strings2) -> new HashSet<String>(strings.addAll(strings2)));//Arrays.asList(strings2.stream().toArray()))
//        return sets.stream().reduce(new HashSet<>(), (strings, strings2) ->
//                new HashSet<String>(Collections.addAll(Arrays.asList(strings.toArray()), Arrays.asList(strings2.toArray()))));//Arrays.asList(strings2.stream().toArray()))
        return sets.stream().reduce(new HashSet<>(), (strings, strings2) ->
                            new HashSet<>() {{
                                addAll(strings);
                                addAll(strings2);
                }});
        // we can also use flatmap
    }
}
