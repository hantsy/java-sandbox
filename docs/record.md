# Record

Java 14 introduce a new keyword `record`  to bring Kotlin `data class` like feature in Java.

Before Java 14, a simple POJO for storing data could like this.

```java
class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.age;
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }

}
```



The  `Person` class consists of constructor, fields, getters, setter, `equals`, `hashCodes` and `toString` method.

Use `record` in Java 14, it can be simplified as.

```java
public record RecordPerson( String name, int age) {}
```

You  can add an alternative constructor, or add additional checking to the default constructor.

```java
public record RecordPerson( String name, int age) {
	public RecordPerson{
		if(age <= 0) {
			throw new IllegalArgumentException(
                "The age of a person must be positive");
		}
	}
	public RecordPerson(String name){
		this(name, 20);
	}
}
```

You can access the name and age like this.

```java
RecordPerson person14 = new RecordPerson("Person in Java 14", 15);

System.out.println("Person in Java 14:\n" + person14);

System.out.println("Person'name in Java 14:\n" + person14.name());
System.out.println("Person'age in Java 14:\n" + person14.age());
```

Test the `equals` method.

```java
RecordPerson person14Copy = new RecordPerson(person14.name(), person14.age());
System.out.println("Person.equals in Java 14:\n" + person14Copy.equals(person14));
```


> You should use an extra `--enable-preview` parameter to compile and run this application.

There are some limitations in  a `record` class.  

* A `record` class can not extend other classes.
* And it can not be inherited by other classes. 
* And all fields in a `record`  imply `final`, that means once a `record` is instantiated, all fields can not be changed.

Use `javap` to decompile the *RecordPerson.class*  file.  

```java

#javap  com.example.demo.RecordPerson
Compiled from "RecordPerson.java"
public final class com.example.demo.RecordPerson extends java.lang.Record {
  public com.example.demo.RecordPerson(java.lang.String, int);
  public com.example.demo.RecordPerson(java.lang.String);
  public java.lang.String toString();
  public final int hashCode();
  public final boolean equals(java.lang.Object);
  public java.lang.String name();
  public int age();
}
   
```

As you see it is declared as `final` and extends `java.lang.Record`.

A `record` class is  useful to transfer data between layers in multi-layered enterprise applications, aka  it a good match with the DTO(Data Transfer Object) pattern.  