package Queues;

import java.util.LinkedList;

public class AnimalShelter {
    private final LinkedList<Dog> dogs = new LinkedList<>();
    private final LinkedList<Cat> cats = new LinkedList<>();

    public void enqueue(Animal animal) {
        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            return null;
        } else if (dogs.isEmpty()) {
            return cats.pollFirst();
        } else if (cats.isEmpty()) {
            return dogs.pollFirst();
        }

        Dog oldestDog = dogs.peekFirst();
        Cat oldestCat = cats.peekFirst();

        if (oldestDog.getArrivalTime() < oldestCat.getArrivalTime()) {
            return dogs.pollFirst();
        } else {
            return cats.pollFirst();
        }
    }

    public Dog dequeueDog() {
        return dogs.pollFirst();
    }

    public Cat dequeueCat() {
        return cats.pollFirst();
    }

    public void printShelterList() {
        System.out.println("Animals in Shelter:");
        if (dogs.isEmpty() && cats.isEmpty()) {
            System.err.println("Shelter has no animals in it.");
        } else {
            for (Dog dog : dogs) {
                System.out.println("Dog Name: " + dog.getName() + ", Breed: " + dog.getBreed());
            }
            for (Cat cat : cats) {
                System.out.println("Cat Name: " + cat.getName() + ", Breed: " + cat.getBreed());
            }
        }
    }
}
