package ru.avdeev.lesson6.animals;

public class Animal {

    protected String name;
    private int runDistance;
    private int swimDistance;

    private static int refCount = 0;

    public Animal(String name, int runDistance, int swimDistance) {
        this.name = name;
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        refCount++;
    }

    public void run(int distance) {
        System.out.printf("%s run %d m.\n", name, Math.min(distance, runDistance));
    }

    public void swim(int distance) {
        System.out.printf("%s swim %d m.\n", name, Math.min(distance, swimDistance));
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    public void setSwimDistance(int swimDistance) {
        this.swimDistance = swimDistance;
    }

    public static int getRefCount() {
        return refCount;
    }
}
