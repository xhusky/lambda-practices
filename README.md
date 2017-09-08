# lambda-practices

**函数接口**

```
      +----------+
T --> | Function | --> R
      +----------+
```
```
      +----------+
-X->  | Supplier | --> T
      +----------+
```
```
      +----------+
T --> | Consumer | -X->
      +----------+
```
```
      +-----------+
T --> | Predicate | --> boolean
      +-----------+
```
```
          +------------+
(T,U) --> | BiConsumer | -X->
          +------------+
```
```
          +------------+
(T,U) --> | BiFunction | --> R
          +------------+
```
```
          +----------------+
(T,T) --> | BinaryOperator | --> T
          +----------------+
```
```
          +-----------+
(T,U) --> | Predicate | --> boolean
          +-----------+
```
```
      +-----------------+
-X->  | BooleanSupplier | --> boolean
      +-----------------+
```
```
                     +----------------------+
(double, double) --> | DoubleBinaryOperator | --> double
                     +----------------------+
```
```
           +----------------+
double --> | DoubleConsumer | -X->
           +----------------+
```
```
           +----------------+
double --> | DoubleFunction | --> R
           +----------------+
```
```
           +-----------------+
double --> | DoublePredicate | --> boolean
           +-----------------+
```
```
     +----------------+
-X-> | DoubleSupplier | --> double
     +----------------+
```
```
           +---------------------+
double --> | DoubleToIntFunction | --> int
           +---------------------+
```
```
           +---------------------+
double --> | DoubleToIntFunction | --> long
           +---------------------+
```
```
           +---------------------+
double --> | DoubleUnaryOperator | --> double
           +---------------------+
```
```
               +-------------------+
(T,double) --> | ObjDoubleConsumer | -X->
               +-------------------+
```
```
          +-------------------+
(T,U) --> | ToDoubleBiFunction | --> double
          +-------------------+
```
```
      +---------------+
T --> | UnaryOperator | --> T
      +---------------+
```

**Stream API**

**`Stream<T> filter(Predicate<? super T> predicate);`**

```java
Stream.of("one", "two", "three", "four", "five")
            .filter(str -> str.length() > 3);
```
```            
Stream<String>                Stream<String> 
  +-------+                                  
  | one   |                                  
  +-------+                                  
  | two   |                                  
  +-------+                     +-------+    
  | three |     filter()        | three |    
  +-------+  --------------->   +-------+    
  | four  |  str.length() > 3   | four  |    
  +-------+                     +-------+    
  | five  |                     | five  |    
  +-------+                     +-------+          
```

**`<R> Stream<R> map(Function<? super T, ? extends R> mapper);`**

```java
Stream.of("one", "two", "three", "four", "five")
            .map(String::toUpperCase);
```
```
Stream<String>                Stream<String>
  +-------+                     +-------+   
  | one   |                     | ONE   |   
  +-------+                     +-------+   
  | two   |                     | TWO   |   
  +-------+                     +-------+   
  | three |       map()         | THREE |   
  +-------+  --------------->   +-------+   
  | four  |    toUpperCase      | FOUR  |   
  +-------+                     +-------+   
  | five  |                     | FIVE  |   
  +-------+                     +-------+   
```

**`IntStream mapToInt(ToIntFunction<? super T> mapper);`**

**`LongStream mapToLong(ToLongFunction<? super T> mapper);`**

**`DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper);`**

**`<R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);`**

**`IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);`**

**`LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper);`**

**`DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper);`**

**`Stream<T> distinct();`**

```java
Stream.of("one", "two", "three", "four", "four")
            .distinct();
```
```
Stream<String>                Stream<String>
  +-------+                                
  | one   |                                
  +-------+                     +-------+  
  | two   |                     | one   |  
  +-------+                     +-------+  
  | three |     distinct()      | two   |  
  +-------+  --------------->   +-------+  
  | four  |                     | three |  
  +-------+                     +-------+  
  | four  |                     | four  |  
  +-------+                     +-------+  
```

**`Stream<T> sorted();`**

**`Stream<T> sorted(Comparator<? super T> comparator);`**

**`Stream<T> peek(Consumer<? super T> action);`**

**`Stream<T> limit(long maxSize);`**

```java
Stream.of("one", "two", "three", "four", "five")
            .limit(4);
```

```
Stream<String>                Stream<String>
  +-------+                                
  | one   |                                
  +-------+                     +-------+  
  | two   |                     | one   |  
  +-------+                     +-------+  
  | three |       limit()       | two   |  
  +-------+  --------------->   +-------+  
  | four  |                     | three |  
  +-------+                     +-------+  
  | five  |                     | four  |  
  +-------+                     +-------+  
```

**`Stream<T> skip(long n);`**

```java
Stream.of("one", "two", "three", "four", "five")
            .skip(2);
```
```
Stream<String>                Stream<String>
  +-------+                                
  | one   |                                
  +-------+                      
  | two   |                       
  +-------+                     +-------+  
  | three |       skip()        | three |  
  +-------+  --------------->   +-------+  
  | four  |                     | four  |  
  +-------+                     +-------+  
  | five  |                     | five  |  
  +-------+                     +-------+  
```

**`void forEach(Consumer<? super T> action);`**

**`void forEachOrdered(Consumer<? super T> action);`**

**`Object[] toArray();`**

**`<A> A[] toArray(IntFunction<A[]> generator);`**

**`T reduce(T identity, BinaryOperator<T> accumulator);`**

**`Optional<T> reduce(BinaryOperator<T> accumulator);`**

**`<U> U reduce(U identity,
                BiFunction<U, ? super T, U> accumulator,
                BinaryOperator<U> combiner);`**

**`<R> R collect(Supplier<R> supplier,
                BiConsumer<R, ? super T> accumulator,
                BiConsumer<R, R> combiner);`**

**`<R, A> R collect(Collector<? super T, A, R> collector);`**

**`Optional<T> min(Comparator<? super T> comparator);`**

**`Optional<T> max(Comparator<? super T> comparator);`**

**`long count();`**

**`boolean anyMatch(Predicate<? super T> predicate);`**

**`boolean allMatch(Predicate<? super T> predicate);`**

**`boolean noneMatch(Predicate<? super T> predicate);`**

**`Optional<T> findFirst();`**

**`Optional<T> findAny();`**
