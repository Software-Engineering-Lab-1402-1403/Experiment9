package com.unittest.codecoverage.respository;

import com.unittest.codecoverage.models.Gender;
import com.unittest.codecoverage.models.Person;
import com.unittest.codecoverage.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PersonRepositoryTest {
    PersonRepository repository = new PersonRepository();

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

    @Test
    public void testDelete_shouldThrowNullPointerExceptionWhenStringIsNull() {
        assertThatThrownBy(() -> repository.delete(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("name can't be null");

        repository.delete("salam");
    }

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

    @Test
    public void testGet_shouldThrowNullPointerExceptionWhenPersonIsNull() {
        assertThatThrownBy(() -> repository.get(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("name can't be null");


        repository.get("person");
    }
}
