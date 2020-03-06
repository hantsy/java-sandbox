# Immutable Collections

Generally creating an immutable collection could like:

```java
Set<String> set = new HashSet<>();
set.add("One");
set.add("Two");
set.add("Three");
set.add("Four");
Collections.unmodifiableSet(set);
```

If using Java 5, this can be simplified as:

```
Set<String> units = new HashSet<>(Arrays.asList(“One”, “Two”, “Three”, “Four”));
units = Collections.unmodifiableSet(units);
```

Or using Java 8 Stream API.

```
Stream.of("One", "Two", "Three", "Four")
	.collect(collectingAndThen(toSet(), Collections::unmodifiableSet));
```

Google Guava provides simple immutable collection utilities.

```
ImmutableSet.of("One", "Two", "Three", "Four");
```

Or create an immutable set from an existing set.

```
ImmutableSet.copyOf(set);
```

In Java 9, a static factory method `of` is introduced in `Set`, `List`, `Map` interface to create an instance quickly.

```java
Set<String> set = Set.of("One", "Two", "Three", "Four");

System.out.println("set::" + set);

List<String> list = List.of("One", "Two", "Three", "Four");

System.out.println("list::" + list);

Map<Integer, String> map = Map.of(1, "One", 2, "Two", 3, "Three", 4, "Four");

System.out.println("map::" + map);
```

In the background, they invoke a `ImmutableCollections` utility class. 

The collections instantiated by these factory methods have some specific characteristics:

- **Immutable**: Elements cannot be added or removed. Calling any mutator method will always cause `UnsupportedOperationException` to be thrown
- **No null Element Allowed**: Attempts to create them with null elements result in `NullPointerException`. In the case of List and Set, no elements can be null. In the case of a Map, neither keys nor values can be null.
- **Value-Based Instances**: If we create Lists with the same values, they may or may not refer to the same object on the heap.
- **Serialization**:  They are serializable if all elements are serializable.
- **Iteration Order**: The iteration order of elements is unspecified and is subject to change.

