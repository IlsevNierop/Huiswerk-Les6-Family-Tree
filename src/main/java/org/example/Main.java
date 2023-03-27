package org.example;

public class Main {
    public static void main(String[] args) {
        Person p = new Person ("Ilse", "van", "Nierop", 'F', 35);
        Pet pet1 = new Pet("Gato", 4, "zwarte kat");


        Person p1 = new Person ("Fred", "van", "Nierop", 'M', 63);
        Person p2 = new Person ("Lena", "Garcia van Nierop", 'F', 2);
        p2.addPet(pet1);

        Person p3 = new Person ("Wessel", "van Nierop", 'M', 31);
        Person p4 = new Person ("Louie", "van Nierop", 'M', 3);
        Person p5 = new Person ("Dani", "Garcia Anton", 'M', 40);
        Pet pet2 = new Pet("HondLouie", 6, "Golden Retriever");
        p.addParents(p1);
        p3.addChild(p4);
        p3.addParents(p1);
        p4.addPet(pet2);
        p.addSibling(p3);

        System.out.println(p.getFather().getName());
        p2.addParents(p);

        System.out.println(p2.getMother().getName());
        p1.getPetsGrandchildren();

        p.getChildren();

        p.getNieces();





    }
}