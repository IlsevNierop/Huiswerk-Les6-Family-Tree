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
    private Person partner;
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
            child.addParent(this, child);
        }
    }

    public void addPet(Pet pet) {
        pets.add(pet);
        pet.setOwner(this);
    }

    //Ben er hier even vanuit gegaan dat je altijd 1 vader en/of moeder hebt. Dit kan uiteraard meer zijn, maar is even te ingwikkeld om te implementeren.
    public void addParent(Person parent, Person child) {
        if (parent.getSex() == 'F' || parent.getSex() == 'f' || parent.getSex() == 'V' || parent.getSex() == 'v') {
            if (child.getMother() == null) {
                child.setMother(parent);
            }
        } else {
            if (child.getFather() == null) {
                child.setFather(parent);
            }
        }
        parent.addChild(child);
    }

    public void addParents(Person father, Person mother, Person child) {
        if (child.getMother() == null) {
            child.setMother(mother);
            mother.addChild(child);
        }
        if (child.getFather() == null) {
            child.setFather(father);
            father.addChild(child);
        }
    }

    public void addPartner(Person partner) {
        // Ik ga even uit van een monogame relatie - dus iemand kan maar 1 partner hebben.
        if (this.getPartner() == null) {
            this.setPartner(partner);
            // Als je iemands partner bent, hoeft dat niet te betekenen dat je ook de vader/moeder van de kinderen van die persoon bent.
            // Maar ik ben er hier even vanuit gegaan dat dat altijd wel zo is.
            // add every child of p1 to partner as child (and this partner as father or mother)
            for (Person child : children) {
                partner.addChild(child);
            }
            partner.addPartner(this);
        }
    }

    public void breakUp(Person partner) {
        if (this.getPartner() != null) {
            this.setPartner(null);
            partner.breakUp(this);
        }
    }


    public List<Pet> getPetsGrandchildren() {
        List<Pet> petsGrandchildren = new ArrayList<>();
        for (Person c : children) {
            for (Person child : c.getChildren()) {
                for (Pet pet : child.getPets()) {
                    petsGrandchildren.add(pet);
                }
            }
        }
        return petsGrandchildren;

    }

    public List<Person> getGrandchildren() {
        List<Person> grandchildren = new ArrayList<>();
        for (Person c : children) {
            for (Person child : c.getChildren()) {
                grandchildren.add(child);
            }
        }
        return grandchildren;
    }


    public List<Person> getNieces() {
        List<Person> nieces = new ArrayList<>();
        for (Person s : siblings) {
            for (Person childSibling : s.getChildren()) {
                if (childSibling.getSex() == 'F' || childSibling.getSex() == 'f' || childSibling.getSex() == 'V' || childSibling.getSex() == 'v') {
                    nieces.add(childSibling);
                }
            }
        }
        return nieces;

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

    public Person getPartner() {
        return partner;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
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

    // even uitgegaan van of male of female. X niet meegenomen in geslacht opties.
    public void setSex(char sex) {
        if (this.sex != 'F' || this.sex != 'f' || this.sex != 'V' || this.sex != 'v') {
            this.sex = 'M';
        } else {
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

}


