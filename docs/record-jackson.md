# Serialize and De-Serialize  Record with Jackson 2.12

Jackson 2.12 added serialization an deserialization of `Record` typed object.

An example :

```java
var person = new RecordPerson("Java", 25);
ObjectMapper mapper = new ObjectMapper();
try {
    var json = mapper.writeValueAsString(person);
    System.out.println("person json: " + json);

    var decodedPerson = mapper.readValue(json, RecordPerson.class);
    System.out.println("person object: " + decodedPerson);
} catch (JsonProcessingException e) {
    e.printStackTrace();
}
```

