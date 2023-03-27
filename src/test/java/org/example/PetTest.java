package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    Pet pet;

    @BeforeEach
    void setUp() {
        pet = new Pet("Gato", 4, "zwarte kat");
    }

    // arrange vaak leeg - omdat al bij de setup een nieuwe Pet wordt aangemaakt.
    @Test
    void shouldGetName() {

        //arrange
        //act
        String output = pet.getName();
        //assert
        assertEquals("Gato", output);
    }

    @Test
    void shouldSetName() {
        //arrange
        //act
        pet.setName("Gato2");
        String output = pet.getName();
        //assert
        assertEquals("Gato2", output);
    }

    @Test
    void shouldGetAge() {
        //arrange
        //act
        int output = pet.getAge();
        //assert
        assertEquals(4, output);
    }

    @Test
    void shouldSetAge() {
        //arrange
        //act
        pet.setAge(8);
        int output = pet.getAge();
        //assert
        assertEquals(8, output);
    }

    @Test
    void shouldGetSpecies() {
        //arrange
        String output = pet.getSpecies();
        //assert
        assertEquals("zwarte kat", output);
    }

    @Test
    void shouldSetSpecies() {
        //arrange

        //act
        pet.setSpecies("Cyperse kat");
        String output = pet.getSpecies();
        //assert
        assertEquals("Cyperse kat", output);
    }

    @Test
    void shouldSetOwner() {
        //arrange
        Person p = new Person("Kees", "Janssen", 'M', 30);
        //act
        pet.setOwner(p);
        Person output = pet.getOwner();
        //assert
        assertEquals(p, output);
    }

    @Test
    void shouldGetOwner() {
        //arrange
        Person p = new Person("Kees", "Janssen", 'M', 30);
        pet.setOwner(p);
        //act
        Person output = pet.getOwner();
        //assert
        assertEquals(p, output);
    }

}