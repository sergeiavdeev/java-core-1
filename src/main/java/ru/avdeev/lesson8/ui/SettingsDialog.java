package ru.avdeev.lesson8.ui;

import ru.avdeev.lesson8.core.Mode;
import ru.avdeev.lesson8.core.Settings;

import javax.swing.*;
import java.awt.*;

public class SettingsDialog extends JDialog {

    private final Settings settings;

    public SettingsDialog(GameFrame parent, Settings settings) {
        super(parent, true);
        this.settings = settings;

        setSize(350, 300);
        setLocationRelativeTo(parent);
        setResizable(false);
        setTitle("New game settings");
        setLayout(new GridLayout(10, 1));
        addGameMode();
        addFieldSize();
    }

    private void addGameMode() {
        add(new JLabel("Выбор режима игры:"));
        var humanVsAi = new JRadioButton("Человек vs Комп", true);
        var humanVsHuman = new JRadioButton("Человек vs Человек");

        humanVsAi.addActionListener(e -> settings.mode = Mode.HUMAN_VS_AI);
        humanVsHuman.addActionListener(e -> settings.mode = Mode.HUMAN_VS_HUMAN);

        ButtonGroup gameMode = new ButtonGroup();
        gameMode.add(humanVsAi);
        gameMode.add(humanVsHuman);
        add(humanVsAi);
        add(humanVsHuman);
    }

    private void addFieldSize() {
        var labelFieldSize = new JLabel("Размер поля: " + settings.fieldSize);
        var labelWinLength = new JLabel("Длина победы: " + settings.winLength);
        var sliderFieldSize = new JSlider(3, 10, settings.fieldSize);
        var sliderWinLength = new JSlider(3, 10, settings.winLength);
        sliderFieldSize.addChangeListener(e -> {
            settings.fieldSize = sliderFieldSize.getValue();
            labelFieldSize.setText("Размер поля: " + settings.fieldSize);
            sliderWinLength.setMaximum(settings.fieldSize);
            labelWinLength.setText("Длина победы: " + settings.winLength);
        });
        sliderWinLength.addChangeListener(e -> {
            settings.winLength = sliderWinLength.getValue();
            labelWinLength.setText("Длина победы: " + settings.winLength);
        });

        add(labelFieldSize);
        add(sliderFieldSize);
        add(labelWinLength);
        add(sliderWinLength);
    }
}
