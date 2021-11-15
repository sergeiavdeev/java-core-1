package ru.avdeev.lesson6;

import ru.avdeev.lesson6.animals.Animal;
import ru.avdeev.lesson6.animals.Cat;
import ru.avdeev.lesson6.animals.Dog;

import java.util.Random;

public class HomeWorkApp {

    public static void main(String[] args) {

        Random random = new Random();

        Animal[] animals = {
                new Cat("Cat1"),
                new Dog("Dog1"),
                new Dog("Dog2"),
                new Cat("Cat2"),
                new Cat("Cat3"),
                new Dog("Cat3"),
                new Cat("Cat4")
        };

        //Болеет
        animals[3].setRunDistance(0);
        animals[3].setSwimDistance(0);

        for (Animal animal : animals) {

            int runDistance = random.nextInt(800);
            int swimDistance = random.nextInt(800);

            animal.run(runDistance);
            animal.swim(swimDistance);
        }

        System.out.printf("Animals: %d, Cats: %d, Dogs: %d\n",
                Animal.getRefCount(),
                Cat.getRefCount(),
                Dog.getRefCount());
    }
}
