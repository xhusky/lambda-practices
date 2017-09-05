package com.github.xhusky;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.UnaryOperator;

/**
 * This guy is lazy, nothing left.
 *
 * @author Think Wong
 */
public class FunctionPractices {

    public static void main(String[] args) {

        /**
         *       +----------+
         * T --> | Function | --> R
         *       +----------+
         */
        Function<Integer, Integer> add5 = x -> x + 5;
        System.out.println(add5.apply(10));

        Function<Integer, String> toString = x -> "" + x;
        System.out.println(toString.apply(100));

        /**
         *       +----------+
         * -X->  | Supplier | --> T
         *       +----------+
         */
        Supplier<String> whoAreYou = () -> "I'm TR";
        System.out.println(whoAreYou.get());

        ThreadLocal<Integer> pages = ThreadLocal.withInitial(() -> 100);

        /**
         *       +----------+
         * T --> | Consumer | -X->
         *       +----------+
         */
        Consumer<String> sayHi = System.out::println;
        sayHi.accept("Hi~");

        /**
         *       +-----------+
         * T --> | Predicate | --> boolean
         *       +-----------+
         */
        Predicate<Integer> atLeast5 = x -> x > 5;
        System.out.println(atLeast5.test(10));

        /**
         *           +------------+
         * (T,U) --> | BiConsumer | -X->
         *           +------------+
         */
        BiConsumer<String, String> printFullName = (x, y) -> System.out.println(x + " " + y);
        printFullName.accept("Think", "Wong");

        /**
         *           +------------+
         * (T,U) --> | BiFunction | --> R
         *           +------------+
         */
        BiFunction<String, String, String> fullName = (x, y) -> x + " " + y;
        System.out.println(fullName.apply("Think", "Wong"));

        /**
         *           +----------------+
         * (T,T) --> | BinaryOperator | --> T
         *           +----------------+
         */
        BinaryOperator<Integer> add = (x, y) -> x + y;
        System.out.println(add.apply(4, 5));

        /**
         *           +-----------+
         * (T,U) --> | Predicate | --> boolean
         *           +-----------+
         */
        BiPredicate<Integer, Integer> asc = (x, y) -> x <= y;
        System.out.println(asc.test(100, 200));


        /**
         *       +-----------------+
         * -X->  | BooleanSupplier | --> boolean
         *       +-----------------+
         */
        BooleanSupplier isTrue = () -> true;
        System.out.println(isTrue.getAsBoolean());


        /**
         *                      +----------------------+
         * (double, double) --> | DoubleBinaryOperator | --> double
         *                      +----------------------+
         */
        DoubleBinaryOperator doubleAdd = (x, y) -> x + y;
        System.out.println(doubleAdd.applyAsDouble(10.23D, 11.51D));

        /**
         *            +----------------+
         * double --> | DoubleConsumer | -X->
         *            +----------------+
         */
        DoubleConsumer price = x -> System.out.println("price is " + x);
        price.accept(4.50D);

        /**
         *            +----------------+
         * double --> | DoubleFunction | --> R
         *            +----------------+
         */
        DoubleFunction<String> priceToString = x -> "Price is " + x;
        System.out.println(priceToString.apply(19.00D));

        /**
         *            +-----------------+
         * double --> | DoublePredicate | --> boolean
         *            +-----------------+
         */
        DoublePredicate expensive = x -> x > 12.5D;
        System.out.println(expensive.test(18.50D));

        /**
         *      +----------------+
         * -X-> | DoubleSupplier | --> double
         *      +----------------+
         */
        DoubleSupplier doublePrice = () -> 12.50D;
        System.out.println(doublePrice.getAsDouble());

        /**
         *            +---------------------+
         * double --> | DoubleToIntFunction | --> int
         *            +---------------------+
         */
        DoubleToIntFunction roundToInt = x -> (int) Math.round(x);
        System.out.println(roundToInt.applyAsInt(15.3D));

        /**
         *            +---------------------+
         * double --> | DoubleToIntFunction | --> long
         *            +---------------------+
         */
        DoubleToLongFunction roundToLong = x -> (long) Math.round(x);
        System.out.println(roundToLong.applyAsLong(15.3D));

        /**
         *            +---------------------+
         * double --> | DoubleUnaryOperator | --> double
         *            +---------------------+
         */
        DoubleUnaryOperator multiply10 = x -> x * 10;
        System.out.println(multiply10.applyAsDouble(12.5D));

        /**
         *                +-------------------+
         * (T,double) --> | ObjDoubleConsumer | -X->
         *                +-------------------+
         */
        ObjDoubleConsumer<String> sayPrice = (o, x) -> System.out.println(o + " " + x);
        sayPrice.accept("Price is", 12.5D);

        /**
         *           +-------------------+
         * (T,U) --> | ToDoubleBiFunction | --> double
         *           +-------------------+
         */
        ToDoubleBiFunction<Integer, Long> toDouble = (x, y) -> x + y;
        System.out.println(toDouble.applyAsDouble(10, 200L));

        /**
         *       +---------------+
         * T --> | UnaryOperator | --> T
         *       +---------------+
         */
        UnaryOperator<String> toUpper = String::toUpperCase;
        System.out.println(toUpper.apply("abc"));

    }
}
