package com.github.xhusky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This guy is lazy, nothing left.
 *
 * @author Think Wong
 */
public class StreamPractices {

    public static void main(String[] args) {

        Stream.of("one", "two", "three", "four", "five")
            .filter(str -> str.length() > 3);

        Stream.of("one", "two", "three", "four", "five")
            .map(String::toUpperCase);

        Stream.of("1", "2", "3", "4", "5")
            .mapToInt(Integer::valueOf);

        Stream.of("1", "2", "3", "4", "5")
            .mapToLong(Long::valueOf);

        Stream.of("1.1", "2.2", "3.3", "4.4", "5.5")
            .mapToDouble(Double::valueOf).forEach(System.out::println);

        Stream.of(Arrays.asList("one", "two"), Arrays.asList("three", "four", "five"))
            .flatMap(list -> list.stream());

        Stream.of("one", "two", "three", "four", "five")
            .forEach(str -> {
                System.out.println(str.toUpperCase());
            });

        Stream.of("one", "two", "three", "four", "four")
            .distinct();

        Stream.of("one", "two", "three", "four", "five")
            .sorted()
            .peek(e -> System.out.println("Peek value: " + e))
            .sorted(Comparator.reverseOrder())
            .peek(e -> System.out.println("Peek value: " + e))
            .count();

        Stream.of("one", "two", "three", "four", "five")
            .forEachOrdered(str -> {
                System.out.println(str.toUpperCase());
            });

        Stream.of("one", "two", "three", "four", "five")
            .parallel()
            .forEach(System.out::println);

        Stream.of("one", "two", "three", "four", "five")
            .parallel()
            .forEachOrdered(System.out::println);

        Stream.of("one", "two", "three", "four", "five")
            .collect(Collectors.toSet());

        Stream.of("one", "two", "three", "four", "five")
            .parallel()
            .collect(
                () -> new ArrayList<>(),
                (list, item) -> list.add(item),
                (one, two) -> one.addAll(two)
            ).forEach(System.out::println);

        Stream.of("one", "two", "three", "four", "five")
            .skip(2)
            .peek(e -> System.out.println("After limit value: " + e))
            .collect(Collectors.toList());

        Stream.of(1, 2, 3, 4)
            .reduce(0, (acc, element) -> acc + element);

        Stream.of(1, 2, 3, 4)
            .reduce((acc, element) -> acc + element)
            .ifPresent(System.out::println);

        // 并行时（parallelStream）才会启用第三个参数
        Arrays.asList(1, 2, 3, 4, 5, 6).parallelStream()
            .reduce(0,
                (sum, p) -> {
                    System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                    return sum += p;
                },
                (sum1, sum2) -> {
                    System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                    return sum1 + sum2;
                });

        Stream.of(1, 2, 3, 4)
            .min(Comparator.naturalOrder());

        System.out.println(Stream.of(1, 2, 3, 4)
            .count());
        ;

        Stream.of("one", "two", "three", "four", "five")
            .toArray();

        Stream.of("one", "two", "three", "four", "five")
            .toArray(String[]::new);

        Stream.of("one", "two", "three", "four", "five")
            .toArray(size -> new String[size]);

        Stream.of("one", "two", "three", "four", "five")
            .anyMatch(str -> str.contains("tw"));

        Stream.of("one", "two", "four")
            .allMatch(str -> str.contains("o"));

        Stream.of("one", "two", "three", "four", "five")
            .noneMatch(str -> str.contains("six"));

        Stream.of("one", "two", "three", "four", "five")
            .findFirst().ifPresent(System.out::println);

        Stream.of("one", "two", "three", "four", "five", "six")
            .parallel()
            .findAny().ifPresent(System.out::println);
    }
}




































