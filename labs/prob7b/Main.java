package labs.prob7b;

/**
 * b. Turn your lambda/stream pipeline from part (a) into a Lambda Library element,
 * following the steps in the slides. First, create a class LambdaLibrary; this class
 * will contain only public static final lambda expressions. Then, identify the
 * parameters that need to be passed in so that your lambda/stream pipeline can
 * operate properly. Finally, think of a function-style interface (Function,
 * BiFunction, TriFunction, etc) that can be used to accommodate your parameters
 * and then name your pipeline, with the function-type interface as its type (as in the
 * slide example). Call your Library element in the main method instead of creating
 * the pipeline there, as you did in part (a).
 *
 * @author KidusMT
 * Date: 4/9/2021
 * StdID: 612361
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(new Employee("Joe", "Davis", 120000),
                new Employee("John", "Sims", 110000),
                new Employee("Joe", "Stevens", 200000),
                new Employee("Andrew", "Reardon", 80000),
                new Employee("Joe", "Cummings", 760000),
                new Employee("Steven", "Walters", 135000),
                new Employee("Thomas", "Blake", 111000),
                new Employee("Alice", "Richards", 101000),
                new Employee("Donald", "Trump", 100000));

        System.out.print(LambdaLibrary.SPECIAL_EMPLOYEE_FILTER.apply(list, 100_000.0, 'M')
                .collect(Collectors.joining(", ")));
    }

}
