package com.github.xhusky;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * This guy is lazy, nothing left.
 *
 * @author Think Wong
 */
public class StreamPractices {

    private static List<String> strings = new ArrayList<>();
    private static List<String> numStrings = new ArrayList<>();
    private static List<Integer> integers = new ArrayList<>();
    static {
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.add("five");

        numStrings.add("100");
        numStrings.add("200");
        numStrings.add("300");
        numStrings.add("400");
        numStrings.add("500");
        numStrings.add("500");


        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
    }

    public static void main(String[] args) {

        Stream<String> filterStream = strings.stream()
            .filter(str -> str.length() > 3);

        Stream<String> mapStream = strings.stream()
            .map(String::toUpperCase);

        IntStream mapToIntStream = numStrings.stream()
            .mapToInt(Integer::valueOf);

        Stream<String> flatMapStream = Stream.of(numStrings, strings)
            .flatMap(Collection::stream);

        Stream<String> distinctStream = Stream.of("1", "1", "0")
            .distinct(); // [1, 0]

        Stream<Integer> sortedStream1 = Stream.of(10, 120, 8)
            .sorted();

        Stream<Integer> sortedStream2 = Stream.of(10, 120, 8)
            .sorted(Comparator.naturalOrder());


        // peek
        Stream.of("one", "two", "three", "four")
            .filter(e -> e.length() > 3)
            .peek(e -> System.out.println("Filtered value: " + e))
            .map(String::toUpperCase)
            .peek(e -> System.out.println("Mapped value: " + e))
            .collect(Collectors.toList());


        // limit
        Stream.of("one", "two", "three", "four")
            .limit(2)
            .peek(e -> System.out.println("After limit value: " + e))
            .collect(Collectors.toList());

        // reduce
        Stream.of(1, 2, 3, 4)
            .reduce(0, (acc, element) -> acc + element);

        Stream.of(1, 2, 3, 4)
            .reduce((acc, element) -> acc + element)
            .ifPresent(System.out::println);

        // 并行时（parallelStream）才会启用第三个参数
        integers.parallelStream()
            .reduce(0,
                (sum, p) -> {
                    System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                    return sum += p;
                },
                (sum1, sum2) -> {
                    System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                    return sum1 + sum2;
                });

    }
}
