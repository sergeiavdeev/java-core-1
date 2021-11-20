package ru.avdeev.lesson8.core;

public class Settings {

    public int fieldSize = 3;
    public int winLength = 3;
    public Mode mode = Mode.HUMAN_VS_AI;

    @Override
    public String toString() {
        return String.format("Размер: %d\nДлина победы: %d\nРежим: %s", fieldSize, winLength, mode);
    }
}
