package ru.avdeev.lesson7;

import ru.avdeev.lesson7.zoo.Bowl;
import ru.avdeev.lesson7.zoo.Cat;

public class HomeWorkApp {

    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Barsik", 15),
                new Cat("Murzik", 20),
                new Cat("Tom", 10),
                new Cat("Murka", 7),
                new Cat("Mashka", 9),
        };

        Bowl bowl = new Bowl(50);

        for (Cat cat : cats) {
            cat.eat(bowl);
            System.out.println(cat);
        }
        System.out.println(bowl);
    }
}
