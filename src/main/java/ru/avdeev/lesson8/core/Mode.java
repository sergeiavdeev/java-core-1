package ru.avdeev.lesson8.core;

public enum Mode {
    HUMAN_VS_AI("Человек vs Комп"),
    HUMAN_VS_HUMAN("Человек vs Человек");

    private final String title;

    Mode(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}
