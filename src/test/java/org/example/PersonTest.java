package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    //arrange
    //act
    //assert

    Person p;
    Person p2;

    @BeforeEach
    void setUp() {
        p = new Person("Moeder1", "Janssen", 'f', 35);
        p2 = new Person("Moeder1", "van", "Kooten", 'f', 35);

    }

    @Test
    void shouldGetName() {
        //arrange
        //act
        String output = p.getName();
        //assert
        assertEquals("Moeder1", output);
    }

    @Test
    void shouldSetName() {
        //arrange
        //act
        p.setName("TestMoeder");
        String output = p.getName();
        //assert
        assertEquals("TestMoeder", output);
    }

    @Test
    void shouldGetLastName() {
        //arrange
        //act
        String output = p.getLastName();
        //assert
        assertEquals("Janssen", output);
    }

    @Test
    void shouldSetLastName() {
        //arrange
        //act
        p.setLastName("TestJanssen");
        String output = p.getLastName();
        //assert
        assertEquals("TestJanssen", output);
    }

    @Test
    void shouldGetMiddleName() {
        //arrange
        //act
        String output = p2.getMiddleName();
        //assert
        assertEquals("van", output);
    }

    @Test
    void shouldSetMiddleName() {
        //arrange
        //act
        p.setMiddleName("de");
        String output = p.getMiddleName();
        //assert
        assertEquals("de", output);
    }

    @Test
    void shouldGetSex() {
        //arrange
        //act
        char output = p.getSex();
        //assert
        assertEquals("f", output);
    }

    @Test
    void shouldSetSex() {
        //arrange
        //act
        p.setSex('M');
        char output = p.getSex();
        //assert
        assertEquals('M', output);
    }

    @Test
    void shouldGetAge() {
        //arrange
        //act
        int output = p.getAge();
        //assert
        assertEquals(35, output);
    }

    @Test
    void shouldSetAge() {
        //arrange
        //act
        p.setAge(40);
        int output = p.getAge();
        //assert
        assertEquals(40, output);
    }

    @Test
    void shouldAddOneParentWhichShouldBeFatherAndShouldAlsoAddChildToFather() {
        //arrange
        Person parent1 = new Person("Vader1", "Janssen", 'M', 55);
        List<Person> children = Arrays.asList(p);
        //act
        p.addParent(parent1, p);

        Person outputFather = p.getFather();
        List<Person> outputChildren = parent1.getChildren();


        //assert
        assertEquals(parent1, outputFather);
        assertArrayEquals(children.toArray(), outputChildren.toArray());
    }

    @Test
    void shouldAddOneParentAndShouldBeMotherAndShouldAlsoAddChildToMother() {
        //arrange
        Person parent2 = new Person("Moeder1", "Janssen", 'F', 60);
        List<Person> children = Arrays.asList(p);
        //act
        p.addParent(parent2, p);

        Person output = p.getMother();
        List<Person> outputChildren = parent2.getChildren();
        //assert
        assertEquals(parent2, output);
        assertArrayEquals(children.toArray(), outputChildren.toArray());
    }

    @Test
    void shouldAddTwoParentsAndShouldAddChildToBothParents() {
        //arrange
        Person parent1 = new Person("Vader1", "Janssen", 'M', 55);
        Person parent2 = new Person("Moeder1", "Janssen", 'F', 60);
        List<Person> children = Arrays.asList(p);

        //act
        p.addParents(parent1, parent2, p);

        Person outputFather = p.getFather();
        Person outputMother = p.getMother();
        List<Person> outputChildrenFather = parent1.getChildren();
        List<Person> outputChildrenMother = parent2.getChildren();


        //assert
        // Ik had eerst voor alle asserts een aparte methode, maar heb het allemaal tegelijk in 1 test methode getest op deze manier.
        assertEquals(parent1, outputFather);
        assertEquals(parent2, outputMother);
        assertArrayEquals(children.toArray(), outputChildrenFather.toArray());
        assertArrayEquals(children.toArray(), outputChildrenMother.toArray());

    }

    @Test
    void shouldGetMother() {
        //arrange
        Person parent2 = new Person("Moeder1", "Janssen", 'F', 60);

        //act
        p.addParent(parent2, p);

        Person output = p.getMother();

        //assert
        assertEquals(parent2, output);

    }

    @Test
    void shouldGetFather() {
        //arrange
        Person parent1 = new Person("Vader1", "Janssen", 'M', 55);

        //act
        p.addParent(parent1, p);

        Person output = p.getFather();

        //assert
        assertEquals(parent1, output);
    }

    @Test
    void setMother() {
        //arrange
        Person parent2 = new Person("Moeder1", "Janssen", 'F', 60);

        //act
        p.setMother(parent2);

        Person output = p.getMother();

        //assert
        assertEquals(parent2, output);
    }

    @Test
    void shouldSetFather() {

        //arrange
        Person parent1 = new Person("Vader1", "Janssen", 'M', 55);

        //act
        p.setFather(parent1);

        Person output = p.getFather();

        //assert
        assertEquals(parent1, output);
    }

    @Test
    void shouldAddChildToPersonAndShouldAddPersonAsParentToChild() {
        //arrange
        Person child1 = new Person("Kind1", "Janssen", 'M', 10);
        List<Person> children = Arrays.asList(child1);

        //act
        p.addChild(child1);

        Person outputParent = child1.getMother();
        List<Person> outputChildren = p.getChildren();


        //assert
        assertEquals(p, outputParent);
        assertArrayEquals(children.toArray(), outputChildren.toArray());
    }

    @Test
    void shouldAddChildOnlyIfChildHasUniqueName() {
        //arrange
        Person child1 = new Person("Kind1", "Janssen", 'M', 10);
        Person child2 = new Person("Kind1", "Janssen", 'M', 10);
        List<Person> children = Arrays.asList(child1);

        //act
        p.addChild(child1);
        p.addChild(child2);

        List<Person> outputChildren = p.getChildren();


        //assert
        assertArrayEquals(children.toArray(), outputChildren.toArray());
    }

    @Test
    void shouldGetChildren() {
        //arrange
        Person child1 = new Person("Kind1", "Janssen", 'M', 10);
        List<Person> children = Arrays.asList(child1);

        //act
        p.addChild(child1);

        List<Person> outputChildren = p.getChildren();


        //assert
        assertArrayEquals(children.toArray(), outputChildren.toArray());
    }

    @Test
    void shouldSetChildren() {
        //arrange
        Person child1 = new Person("Kind1", "Janssen", 'M', 10);
        List<Person> children = Arrays.asList(child1);

        //act
        p.setChildren(children);

        List<Person> outputChildren = p.getChildren();


        //assert
        assertArrayEquals(children.toArray(), outputChildren.toArray());
    }


    @Test
    void shouldAddSiblingAndAlsoToSibling() {
        //arrange
        Person sibling1 = new Person("Broer1", "Janssen", 'M', 8);
        List<Person> siblingsFromPerson = Arrays.asList(sibling1);
        List<Person> siblingsFromSibling = Arrays.asList(p);


        //act
       p.addSibling(sibling1);

        List<Person> outputSiblingsFromPerson = p.getSiblings();
        List<Person> outputSiblingsFromSibling = sibling1.getSiblings();


        //assert
        assertArrayEquals(siblingsFromPerson.toArray(), outputSiblingsFromPerson.toArray());
        assertArrayEquals(siblingsFromSibling.toArray(), outputSiblingsFromSibling.toArray());
    }

    @Test
    void shouldGetSiblings() {
        //arrange
        Person sibling1 = new Person("Broer1", "Janssen", 'M', 8);
        List<Person> siblings = Arrays.asList(sibling1);


        //act
        p.addSibling(sibling1);

        List<Person> outputSiblings = p.getSiblings();


        //assert
        assertArrayEquals(siblings.toArray(), outputSiblings.toArray());
    }

    @Test
    void shouldSetSiblings() {
        //arrange
        Person sibling1 = new Person("Broer1", "Janssen", 'M', 8);
        List<Person> siblings = Arrays.asList(sibling1);


        //act
        p.setSiblings(siblings);

        List<Person> outputSiblings = p.getSiblings();


        //assert
        assertArrayEquals(siblings.toArray(), outputSiblings.toArray());

    }

    @Test
    void shouldAddPetAndShouldAddOwnerToPet() {
        //arrange
        Pet pet1 = new Pet("Hond1", 5, "Golden Retriever");
        List<Pet> pets = Arrays.asList(pet1);

        //act
        p.addPet(pet1);

        List<Pet> outputPets = p.getPets();


        //assert
        assertArrayEquals(pets.toArray(), outputPets.toArray());
    }


    @Test
    void shouldSetPets() {
        //arrange
        Pet pet1 = new Pet("Hond1", 5, "Golden Retriever");
        List<Pet> pets = Arrays.asList(pet1);


        //act
        p.setPets(pets);

        List<Pet> outputPets = p.getPets();


        //assert
        assertArrayEquals(pets.toArray(), outputPets.toArray());
    }

    @Test
    void shouldGetPets() {
        //arrange
        Pet pet1 = new Pet("Hond1", 5, "Golden Retriever");
        List<Pet> pets = Arrays.asList(pet1);


        //act
        p.addPet(pet1);

        List<Pet> outputPets = p.getPets();


        //assert
        assertArrayEquals(pets.toArray(), outputPets.toArray());
    }

    @Test
    void shouldNotAddPartnerIfPersonDoesHavePartner() {
        //arrange
        Person partner1 = new Person("Partner1", "Janssen", 'M', 30);
        Person partner2 = new Person("Partner2", "Janssen", 'M', 28);

        //act
        p.addPartner(partner1);
        p.addPartner(partner2);

        Person output = p.getPartner();


        //assert
        assertEquals(partner1, output);
    }

    @Test
    void getPartner() {
        //arrange
        Person partner1 = new Person("Partner1", "Janssen", 'M', 30);

        //act
        p.addPartner(partner1);

        Person outputPartner = p.getPartner();


        //assert
        assertEquals(partner1, outputPartner);
    }

    @Test
    void setPartner() {
        //arrange
        Person partner1 = new Person("Partner1", "Janssen", 'M', 30);

        //act
        p.setPartner(partner1);

        Person outputPartner = p.getPartner();

        //assert
        assertEquals(partner1, outputPartner);
    }

    @Test
    void shouldAddPartnerAndChildrenToThisPartner() {
        //arrange
        Person partner1 = new Person("Partner1", "Janssen", 'M', 30);
        Person child1 = new Person("Child1", "Janssen", 'F', 7);
        List<Person> children = Arrays.asList(child1);

        //act
        p.addChild(child1);
        p.addPartner(partner1);

        Person outputPartner = p.getPartner();
        List<Person> partnerChildren = partner1.getChildren();


        //assert
        assertEquals(partner1, outputPartner);
        assertArrayEquals(children.toArray(), partnerChildren.toArray());
    }


    @Test
    void PersonAndPartnerShouldHaveNullAsPartnerAfterBreakUp() {
        //arrange
        Person partner1 = new Person("Partner1", "Janssen", 'M', 30);

        //act
        p.breakUp(partner1);



        Person outputPersonPartner = p.getPartner();
        Person outputPartnerPerson = partner1.getPartner();

        //assert
        assertEquals(null, outputPersonPartner);
        assertEquals(null, outputPartnerPerson);

    }

    @Test
    void shouldGetAllGrandchildren() {
        //arrange
        Person child1 = new Person("Kind1", "Janssen", 'M', 10);
        Person grandchild1 = new Person("Kleinkind1", "Janssen", 'M', 5);
        Person grandchild2 = new Person("Kleindkidn2", "Janssen", 'F', 6);

        List<Person> grandchildren = Arrays.asList(grandchild1, grandchild2);

        //act
        p.addChild(child1);
        child1.addChild(grandchild1);
        child1.addChild(grandchild2);


        List<Person> outputgrandChildren = p.getGrandchildren();


        //assert
        assertArrayEquals(grandchildren.toArray(), outputgrandChildren.toArray());

    }

    @Test
    void shouldGetAllPetsGrandchildren() {
        //arrange
        Person child1 = new Person("Kind1", "Janssen", 'M', 10);
        Person grandchild1 = new Person("Kleinkind1", "Janssen", 'M', 5);
        Person grandchild2 = new Person("Kleindkidn2", "Janssen", 'F', 6);
        Pet pet1 = new Pet("Gato1", 4, "Kat");
        Pet pet2 = new Pet("Gato2", 2, "Kat");
        Pet pet3 = new Pet("Hond1", 5, "Hond");
        Pet pet4 = new Pet("Hond2", 1, "Hond");

        //volgorde is van belang - gaat eerst de pets van grandchild 1 af en daarna de pets van grandchild2.
        List<Pet> grandchildrenPets = Arrays.asList(pet1, pet3, pet2, pet4);

        //act
        p.addChild(child1);
        child1.addChild(grandchild1);
        child1.addChild(grandchild2);
        grandchild1.addPet(pet1);
        grandchild1.addPet(pet3);
        grandchild2.addPet(pet2);
        grandchild2.addPet(pet4);


        List<Pet> outputPetsGrandchildren = p.getPetsGrandchildren();


        //assert
        assertArrayEquals(grandchildrenPets.toArray(), outputPetsGrandchildren.toArray());
    }

    @Test
    void shouldGetNiecesNotNephews() {

        //arrange
        Person brother = new Person("Broer1", "Janssen", 'M', 30);
        Person sister = new Person("Zus1", "Janssen", 'F', 25);
        Person niece1 = new Person("Kind1Broer", "Janssen", 'F', 10);
        Person nephew1 = new Person("Kind2Broer", "Janssen", 'm', 8);
        Person niece2 = new Person("Kind3Broer", "Janssen", 'f', 6);
        Person niece3 = new Person("Kind1Zus", "Janssen", 'f', 5);
        Person nephew2 = new Person("Kind2Zus", "Janssen", 'm', 3);
        Person niece4 = new Person("Kind3Zus", "Janssen", 'f', 1);

        List<Person> nieces = Arrays.asList(niece1, niece2, niece3, niece4);

        //act
        p.addSibling(brother);
        p.addSibling(sister);
        brother.addChild(niece1);
        brother.addChild(nephew1);
        brother.addChild(niece2);
        sister.addChild(niece3);
        sister.addChild(nephew2);
        sister.addChild(niece4);


        List<Person> outputNieces = p.getNieces();


        //assert
        assertArrayEquals(nieces.toArray(), outputNieces.toArray());
    }


}