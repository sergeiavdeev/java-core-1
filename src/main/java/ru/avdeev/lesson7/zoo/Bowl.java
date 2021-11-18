package ru.avdeev.lesson7.zoo;

public class Bowl {

    private int foodCount;

    public Bowl(int foodCount) {
        this.foodCount = foodCount;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public int getFood(int count) {

        int reallyFoodCount = Math.min(foodCount, count);
        foodCount -= reallyFoodCount;
        return reallyFoodCount;
    }

    @Override
    public String toString() {
        return String.format("The bowl has %d food.", foodCount);
    }
}
