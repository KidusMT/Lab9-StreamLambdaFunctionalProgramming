package labs.prob10;

import labs.prob7b.TriFunction;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author KidusMT
 * Date: 4/11/2021
 * StdID: 612361
 */
class Human {
    String name;
    int age;
    String gender;

    public Human(String name) {
        this.name = name;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Human [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }
}

public class ConstructorReference {
    public static void main(String[] args) {
        Human[] list = {new Human("Joe", 35, "Male"),
                new Human("Jane", 45, "Female"),
                new Human("John", 30, "Male")};

        System.out.println("Query 1 :-----------------------------------------");
        // Query 1  : Print only Female canditates names
        Arrays.stream(list)
                .filter(h -> h.getGender().equals("Female"))
                .forEach(System.out::println);

        System.out.println("Query 2 :-----------------------------------------");
        // Query 2 : Create an object by choosing suitable Interface to the specified constructors(Totally 3 constructors)
        // using fourth type of Method Reference ClassName::new. Then print the object status
        Function<String, Human> createHumanWithOneArg = Human::new;
        Human human1 = createHumanWithOneArg.apply("John");
        System.out.println("human1: " + human1);

        BiFunction<String, Integer, Human> createHumanWithTwoArgs = Human::new;
        Human human2 = createHumanWithTwoArgs.apply("John", 25);
        System.out.println("human2: " + human2);

        TriFunction<String, Integer, String, Human> createHumanWithThreeArgs = Human::new;
        Human human3 = createHumanWithThreeArgs.apply("John", 25, "Male");
        System.out.println("human3: " + human3);

        System.out.println("Query 3 :-----------------------------------------");
        // Query 3 : Count the male candidates whose age is more than 30
        long count = Arrays.stream(list)
                .filter(h -> h.getGender().equals("Male"))
                .filter(h -> h.getAge() > 30)
                .count();
        System.out.println("Candidates counted: " + count);

    }

}
