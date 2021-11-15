package ru.avdeev.lesson6.animals;

public class Dog extends Animal{

    private static final int MAX_RUN = 200;
    private static final int MAX_SWIM = 150;

    private static int refCount = 0;

    public Dog(String name) {
        super(name, MAX_RUN, MAX_SWIM);
        refCount++;
    }

    public static int getRefCount() {
        return refCount;
    }
}
