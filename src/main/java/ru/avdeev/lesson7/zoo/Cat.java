package ru.avdeev.lesson7.zoo;

public class Cat {

    private final String name;
    private final int appetite;
    private boolean isHungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isHungry = true;
    }

    public void eat(Bowl bowl) {

        if (bowl.getFoodCount() > appetite) {
            System.out.printf("The cat %s ate %d food.\n", name, bowl.getFood(appetite));
            isHungry = false;
        } else {
            System.out.printf("The cat %s not ate.\n", name);
        }
    }

    @Override
    public String toString() {
        return String.format("The cat %s %s hungry. His appetite: %d",
                name, (isHungry ? "is" : "is not"), appetite);
    }
}
