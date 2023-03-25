package org.example;

import java.util.ArrayList;
import java.util.List;

public class Person {

    // get grandchildren methode
    // get pets from grandchildren methode - moet nog returnen - nu alleen sout
    // get all nieces from person methode - moet nog returnen (en check de setsex methode)
    // Voeg een partner toe aan de Person en implementeer deze partner door de gehele applicatie inclusief getter & setter en benodigde methodes.


    private String name;
    private String middleName;
    private String lastName;
    private char sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings = new ArrayList<Person>();
    private List<Person> children = new ArrayList<Person>();
    private List<Pet> pets = new ArrayList<Pet>();

    public Person(String name, String lastName, char sex, int age) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    public Person(String name, String middleName, String lastName, char sex, int age) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.sex = sex;
        this.age = age;
    }

    private boolean hasUniqueName(Person person, List<Person> persons) {
        if (persons.isEmpty()) {
            return true;
        }
        for (Person p : persons) {
            if (p.getName().equalsIgnoreCase(person.getName())) {
                return false;
            }
        }
        return true;
    }

    public void addSibling(Person sibling) {
        if (hasUniqueName(sibling, siblings)) {
            siblings.add(sibling);
            sibling.addSibling(this);
        }
    }

    public void addChild(Person child) {
        if (hasUniqueName(child, children)) {
            children.add(child);
            child.addParents(this);
        }
    }

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setOwner(this);
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void addParents(Person p) {
        if (p.getSex() == 'F' || p.getSex() == 'f' || p.getSex() == 'V' || p.getSex() == 'v') {
            this.mother = p;
        } else {
            this.father = p;
        }
        p.addChild(this);
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getSex() {
        return sex;
    }

    // check hoe goed op te lossen bij 'verkeerde' invoer
    public void setSex(char sex) {
        if (this.sex != 'F' || this.sex != 'M'){
            this.sex = 'X';
        }
        else {
            this.sex = sex;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    // nu print statement, maar moet returnen
    public void getPetsGrandChildren() {
        for (Person c : children){
            for (Person child : c.getChildren()){
                for (Pet pet : child.getPets()){
                    System.out.println(child.getName() + " is a grandchild of " + this.name + " and has the following pets: ");
                    System.out.println(pet.getName());
                }

            }
        }

    }

    // nu print statement, maar moet returnen
    public void getNieces() {
        for (Person s : siblings){
            for (Person childSibling : s.getChildren()){
                if (childSibling.getSex() == 'F' || childSibling.getSex() == 'f' || childSibling.getSex() == 'V' || childSibling.getSex() == 'v'){
                    System.out.println(childSibling.getName() + " is a niece of " + this.name);
                }
            }
        }

    }
}


