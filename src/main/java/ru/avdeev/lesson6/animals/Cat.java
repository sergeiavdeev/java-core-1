package ru.avdeev.lesson6.animals;

public class Cat extends Animal{

    private static final int MAX_RUN = 250;
    private static final int MAX_SWIM = 0;

    private static int refCount = 0;

    public Cat(String name) {
        super(name, MAX_RUN, MAX_SWIM);
        refCount++;
    }

    public static int getRefCount() {
        return refCount;
    }
}
