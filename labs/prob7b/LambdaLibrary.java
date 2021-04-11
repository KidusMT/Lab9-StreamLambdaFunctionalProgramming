package labs.prob7b;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author KidusMT
 * Date: 4/9/2021
 * StdID: 612361
 */
public class LambdaLibrary {

    public static TriFunction<List<Employee>, Double, Character, Stream<String>> SPECIAL_EMPLOYEE_FILTER = (emps, sAmount, startChar) ->
            emps.stream().filter(e -> e.salary > sAmount)
                    .filter(e -> e.lastName.charAt(0) > startChar)
                    .map(e -> e.firstName + " " + e.lastName).sorted();
}
