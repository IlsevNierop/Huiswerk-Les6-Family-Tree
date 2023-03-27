package org.example;

public class Main {
    public static void main(String[] args) {
        Person p = new Person ("Moeder1", "van", "Kooten", 'F', 35);
        Pet pet1 = new Pet("Gato", 4, "zwarte kat");


        Person p1 = new Person ("Opa1", "van", "Kooten", 'M', 63);
        Person p2 = new Person ("Kind1", "Janssen van Kooten", 'F', 2);
        p2.addPet(pet1);

        Person p3 = new Person ("Vader2", "van Kooten", 'M', 31);
        Person p4 = new Person ("Kind2", "van Kooten", 'M', 3);
        Person p5 = new Person ("Vader1", "Janssen Garcia", 'M', 40);
        Pet pet2 = new Pet("HondKind2", 6, "Golden Retriever");
        p.addParent(p1, p);
        p3.addChild(p4);
        p3.addParent(p1, p3);
        p4.addPet(pet2);
        p.addSibling(p3);
        p2.addParents(p, p5, p2);
        System.out.println("Vader: " + p2.getFather().getName() + " Moeder: " + p2.getMother().getName());

        System.out.println(p.getFather().getName());
        p2.addParent(p, p2);

        System.out.println(p2.getMother().getName());
        p1.getPetsGrandchildren();
        p1.getGrandchildren();

        p.getChildren();

        p.getNieces();





    }
}