# New `toList` method in `Stream`

In Java 16 there is a new `toList` added the `Stream` interface.

```java
IntStream.range(1, 100)
	.mapToObj(i ->  "Hello, #"+ i)
	.collect(Collectors.toList())
	.forEach(System.out::println);
	
IntStream.range(1, 100)
	.mapToObj(i ->  "Hello, #"+ i)
	
	// since Java 16, use `toList` to replace `.collect(Collectors.toList())`
	.toList()
	.forEach(System.out::println);	
```