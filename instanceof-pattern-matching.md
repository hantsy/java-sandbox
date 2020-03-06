# InstanceOf Pattern Matching

Assume we have the following classes.

```java
class Animal{
}

class Cat extends Animal{

    public String name() {
        return "Ketty";
    }
    
    @Override
    public String toString() {
        return "Cat{" + '}';
    }

}

class Dog extends Animal{
    
    public String name() {
        return "Kael";
    }

    @Override
    public String toString() {
        return "Dog{" + '}';
    }  
}
```



When creating a `Cat` like this.

```java
Animal animal = new Cat();
```

And we want to detect if it is a  `Cat`,  in the preivious Java, we could have to code like this.

```java
if(animal instanceof Cat){
    Cat cat= (Cat) cat;
    System.out.println("it is a cat:" + cat.name());
}
```

Here we used a line of code to cast  the `animal` object instance to type `Cat`.

In Java 14, it smply becomes:

```java
if(animal instanceof Cat cat){
	System.out.println("it is a cat:" + cat.name());
}
```        
