package labs.prob8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author KidusMT
 * Date: 4/11/2021
 * StdID: 612361
 */
public class PuttingIntoPractice {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        System.out.println("Query 1: ----------------------------------------------");
        // Query 1: Find all transactions from year 2011 and sort them by value (small to high).
        transactions.stream()
                .filter(t -> t.getYear() >= 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        System.out.println("Query 2:----------------------------------------------");
        // Query 2: What are all the unique cities where the traders work?
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("Query 3:----------------------------------------------");
        // Query 3: Find all traders from Cambridge and sort them by name.
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(tr -> tr.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        System.out.println("Query 4:----------------------------------------------");
        // Query 4: Return a string of all traders names sorted alphabetically.
        transactions.stream()
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .map(Trader::getName)
                .forEach(System.out::println);

        System.out.println("Query 5:----------------------------------------------");
        // Query 5: Are there any trader based in Milan?
        Optional<String> trader = transactions.stream()
                .filter(tr -> tr.getTrader().getCity().equals("Milan"))
                .map(transaction -> transaction.getTrader().getName())
                .findAny();
        System.out.println("Trader living in Milan is: " + trader.orElse("No trader found"));

        System.out.println("Query 6:----------------------------------------------");
        // Query 6: Update all transactions so that the traders from Milan are set to Cambridge.
        List<Trader> traderStream = transactions.stream()
                .map(Transaction::getTrader)
                .filter(tr -> tr.getCity().equals("Milan"))
                .collect(Collectors.toList());
        System.out.println("Found traders BEFORE setting their city to Cambridge.");
        traderStream.stream()
                .forEach(System.out::println);
        System.out.println("Changed the city name for Milan Traders to Cambridge.\n");
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(tr -> tr.getCity().equals("Milan"))
                .forEach(s -> s.setCity("Cambridge"));

        Optional<String> optionalTrader = transactions.stream()
                .map(Transaction::getTrader)
                .filter(tr -> tr.getCity().equals("Milan"))
                .map(Trader::getName)
                .findAny();
        System.out.println("Found traders after update is: " + optionalTrader.orElse("No trader found in Milan AFTER update."));

        System.out.println("Query 7:----------------------------------------------");
        // Query 7: What's the highest value in all the transactions?
        IntSummaryStatistics summaryStatistics = transactions.stream()
                .collect(Collectors.summarizingInt(Transaction::getValue));

        System.out.println("Highest value in all the transactions is: " + summaryStatistics.getMax());
    }
}
