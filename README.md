# Experiment 9

## Get Code Coverage Status

### Json-Sample

Here is json-sample project code coverage result:

![img.png](screenshots/json1.png)
![img.png](screenshots/json2.png)
![img.png](screenshots/json3.png)

### CodeCoverageProject

In the pictures below we do the same thing for the second project.

![img.png](screenshots/code1.png)
![img.png](screenshots/code2.png)

Using the details here, we can improve test  coverage easily:

![img.png](screenshots/code3.png)

## Improve Test Coverage

### PersonRepository Class

As we can see in the previous pictures, PersonRepository class test coverage percentage is 0%.

We add 4 methods to test all of this class methods.

#### 1- Insert

Using this code block we test all functionalities of repository.insert() method. If the input person is null, it should throw a NullPointerException. If not, it will return the person.

```java
@Test
    public void testInsert_shouldThrowNullPointerExceptionWhenPersonIsNull() {
        assertThatThrownBy(() -> repository.insert(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("person can't be null");

        Person person = new Person();
        person.setName("Name");
        person.setAge(21);
        person.setGender(Gender.M);

        Person p = repository.insert(person);

        assertEquals(person, p);
    }
```

#### 2- Delete

Using this code block we test all functionalities of repository.delete().

```java
@Test
    public void testDelete_shouldThrowNullPointerExceptionWhenStringIsNull() {
        assertThatThrownBy(() -> repository.delete(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("name can't be null");

        repository.delete("salam");
    }
```

#### 3- Update

Using this code block we test all functionalities of repository.update().

```java
@Test
    public void testUpdate_shouldThrowNullPointerExceptionWhenPersonIsNull() {
        assertThatThrownBy(() -> repository.update(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("person can't be null");

        Person person = new Person();
        person.setName("Name");
        person.setAge(21);
        person.setGender(Gender.M);

        repository.update(person);
    }
```

#### 4- Get

Using this code block we test all functionalities of repository.get().

```java
@Test
    public void testGet_shouldThrowNullPointerExceptionWhenPersonIsNull() {
        assertThatThrownBy(() -> repository.get(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("name can't be null");


        repository.get("person");
    }
```

#### Improvement

Using these tests we improved this directory test coverage from 0% to 100%.

![img.png](screenshots/repo_improve.png)

### PersonService Class

As we can see in the previous pictures, PersonRepository class test coverage percentage is 40% of Methods and 33% of Lines.

![img.png](screenshots/personBefore.png)

We add 1 methods to test get method of this class.

#### 1- Get

```java
@Test
    public void testGet() {
        List<String> expectedErrors = Lists.newArrayList("Name is required");
        String expectedMessage = String.join(";", expectedErrors);

        assertThatThrownBy(() -> service.get(null))
                .isInstanceOf(PersonException.class)
                .hasFieldOrPropertyWithValue("errors", expectedErrors)
                .hasMessage(expectedMessage);


        assertNull(service.get("salam"));
    }
```

#### Improvement

After running this test the percentage of this is 60% on Methods and 50% on lines.

![img.png](screenshots/personNew.png)
