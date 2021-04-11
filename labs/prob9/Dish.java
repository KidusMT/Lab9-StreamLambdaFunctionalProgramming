package labs.prob9;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author KidusMT
 * Date: 4/11/2021
 * StdID: 612361
 */
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                           new Dish("beef", false, 700, Dish.Type.MEAT),
                           new Dish("chicken", false, 400, Dish.Type.MEAT),
                           new Dish("french fries", true, 530, Dish.Type.OTHER),
                           new Dish("rice", true, 350, Dish.Type.OTHER),
                           new Dish("season fruit", true, 120, Dish.Type.OTHER),
                           new Dish("pizza", true, 550, Dish.Type.OTHER),
                           new Dish("prawns", false, 400, Dish.Type.FISH),
                           new Dish("salmon", false, 450, Dish.Type.FISH));

    // a. Is there any Vegetarian meal available ( return type boolean)
    public static final Function<List<Dish>, Boolean> VEGETARIAN_MEAL_AVAILABLE =
            (dishes) -> dishes.stream().anyMatch(Dish::isVegetarian);

    public static boolean isVegetableMealAvailable(List<Dish> dishes){
        return dishes.stream().anyMatch(Dish::isVegetarian);
    }

    // b) Is there any healthy menu have calories less than 1000 ( return type boolean)
    public static final BiFunction<List<Dish>, Integer, Boolean> HEALTHY_MEAL_WITH_CALORIE_LESS_THAN =
            (dishes, calAmount) -> dishes.stream().anyMatch(dish -> dish.calories < calAmount);

    public static boolean isThereHealthyMealWithCalorieLessThan(List<Dish> dishes, Integer calAmount){
        return dishes.stream().anyMatch(dish -> dish.calories < calAmount);
    }

    // c) Is there any unhealthy menu have calories greater than 1000 ( return type boolean)
    public static final BiFunction<List<Dish>, Integer, Boolean> UNHEALTHY_MEAL_WITH_CALORIE_MORE_THAN =
            (dishes, calAmount) -> dishes.stream().anyMatch(dish -> dish.calories > calAmount);

    public static boolean isThereUnHealthyMealWithCalorieLessThan(List<Dish> dishes, Integer calAmount){
        return dishes.stream().anyMatch(dish -> dish.calories > calAmount);
    }

    // d) find and return the first item for the type of MEAT( return type Optional<Dish>)
    public static final Supplier<Optional<Dish>> FIND_MEAT_MENU_ITEM =
            () -> menu.stream().filter(dish -> dish.type.equals(Type.MEAT)).findFirst();

    public static Optional<Dish> firstMeatItemFromMenu(List<Dish> dishes){
        return dishes.stream().filter(dish -> dish.type.equals(Type.MEAT)).findFirst();
    }


    // e) calculateTotalCalories() in the menu using reduce. (return int)
    public static int calculateTotalCalories(List<Dish> dishes){
        return dishes.stream().map(dish -> dish.calories).reduce(0, (calorie1, calorie2) -> calorie1 + calorie2);
    }

    // f) calculateTotalCaloriesMethodReference()in the menu using MethodReferences. (return int)
    public static int calculateTotalCaloriesMethodReference(List<Dish> dishes){
        return dishes.stream().map(Dish::getCalories).reduce(0, Integer::sum);
    }

    // g) Implement a main method to test
    public static void main(String[] args) {
        // a. Is there any Vegetarian meal available ( return type boolean)
        System.out.println("a) -------------------------------------------------------------------");
        System.out.println("Is there any Vegetarian meal available: " + isVegetableMealAvailable(menu));
        System.out.println("Is there any Vegetarian meal available: " + Dish.VEGETARIAN_MEAL_AVAILABLE.apply(menu));

        // b) Is there any healthy menu have calories less than 1000 ( return type boolean)
        System.out.println("b) -------------------------------------------------------------------");
        String quesB = "Is there any healthy menu have calories less than 1000: ";
        System.out.println(quesB + isThereHealthyMealWithCalorieLessThan(menu, 1000));
        System.out.println(quesB + Dish.HEALTHY_MEAL_WITH_CALORIE_LESS_THAN.apply(menu,1000));

        // c) Is there any unhealthy menu have calories greater than 1000 ( return type boolean)
        System.out.println("c) -------------------------------------------------------------------");
        String quesC = "Is there any unhealthy menu have calories greater than 1000: ";
        System.out.println(quesC + isThereUnHealthyMealWithCalorieLessThan(menu, 1000));
        System.out.println(quesC + Dish.UNHEALTHY_MEAL_WITH_CALORIE_MORE_THAN.apply(menu,1000));

        // d) find and return the first item for the type of MEAT( return type Optional<Dish>)
        System.out.println("d) -------------------------------------------------------------------");
        String quesD = "First item for the type of MEAT: ";
        System.out.println(quesD + firstMeatItemFromMenu(menu));
        System.out.println(quesD + Dish.FIND_MEAT_MENU_ITEM.get());

        // e) calculateTotalCalories() in the menu using reduce. (return int)
        System.out.println("e) -------------------------------------------------------------------");
        String quesE = "calculateTotalCalories(): ";
        System.out.println(quesE + calculateTotalCalories(menu));

        // f) calculateTotalCaloriesMethodReference()in the menu using MethodReferences. (return int)
        System.out.println("f) -------------------------------------------------------------------");
        String quesF = "calculateTotalCaloriesMethodReference(): ";
        System.out.println(quesF + calculateTotalCaloriesMethodReference(menu));

    }

}