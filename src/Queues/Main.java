package Queues;

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        Cat kitty = new Cat("Kitty", "Kitty White", "Male", 1, System.currentTimeMillis());
        Dog puppy = new Dog("Puppy", "Puppy Brown", "Female", 2, System.currentTimeMillis());
        Dog pups = new Dog("Pups", "Pups Black", "Male", 3, System.currentTimeMillis() + 1);

        shelter.enqueue(kitty);
        shelter.enqueue(puppy);
        shelter.enqueue(pups);

        System.out.println("Initial Shelter State:");
        shelter.printShelterList();

        Animal adoptedCat = shelter.dequeueCat();
        System.out.println("\nAfter adopting a cat:");
        shelter.printShelterList();

        Animal adoptedAny = shelter.dequeueAny();
        System.out.println("\nAfter adopting any animal:");
        shelter.printShelterList();

        Animal adoptedDog = shelter.dequeueDog();
        System.out.println("\nAfter adopting a dog:");
        shelter.printShelterList();

        System.out.println("\nDequeueCat: " + adoptedCat.getName() + " (" + adoptedCat.getBreed() + ", " + adoptedCat.getGender() + ", " + adoptedCat.getAge() + " years old)");
        System.out.println("DequeueAny: " + adoptedAny.getName() + " (" + adoptedAny.getBreed() + ", " + adoptedAny.getGender() + ", " + adoptedAny.getAge() + " years old)");
        System.out.println("DequeueDog: " + adoptedDog.getName() + " (" + adoptedDog.getBreed() + ", " + adoptedDog.getGender() + ", " + adoptedDog.getAge() + " years old)");
    }
}
