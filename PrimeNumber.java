import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


public class PrimeNumber {

     /**
     * Java 8 / Lambda approach to generate Prime number.
     * Prime always start to look from number 1.
     * @param series Number of how many Prime number should be generated
     * @return List holding resulting Prime number.
     */
    public static List<Integer> generate(int series) {
        Set<Integer> set = new TreeSet<>();
        return Stream.iterate(1, i -> ++i)
                .filter(i -> i %2 != 0)
                .filter(i -> {
                    set.add(i);
                    return 0 == set.stream()
                            .filter(p -> p != 1)
                            .filter(p -> !Objects.equals(p, i))
                            .filter(p -> i % p == 0)
                            .count();
                })
                .limit(series)
                .collect(toList());
    }

    public static void main(String[] args) {
        List<Integer> generate = PrimeNumber.generate(20);
        System.out.println(generate);
    }
}