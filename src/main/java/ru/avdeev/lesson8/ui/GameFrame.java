package ru.avdeev.lesson8.ui;

import ru.avdeev.lesson8.core.Move;
import ru.avdeev.lesson8.core.Player;
import ru.avdeev.lesson8.core.Settings;
import ru.avdeev.lesson8.core.TicTacToeGame;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private final Settings settings = new Settings();
    private final SettingsDialog settingsDialog;

    private JPanel fieldPanel;

    private TicTacToeGame game;

    public GameFrame() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        createSettingsPanel();
        createFieldPanel();

        settingsDialog = new SettingsDialog(this, settings);

        setVisible(true);
    }

    private void createSettingsPanel() {

        var panel = new JPanel();
        var btnStart = new JButton("Новая игра");
        var btnSettings = new JButton("Настройки");

        btnStart.addActionListener(e -> startGame());
        btnSettings.addActionListener(e -> openSettingsWindow());

        panel.add(btnStart);
        panel.add(btnSettings);
        panel.setBackground(Color.GRAY);

        add(panel, BorderLayout.SOUTH);
    }

    private void createFieldPanel() {

        fieldPanel = new JPanel();
        fieldPanel.setLayout(new GridLayout(settings.fieldSize, settings.fieldSize));
        add(fieldPanel, BorderLayout.CENTER);
        startGame();
    }

    private void startGame() {
        System.out.println("Start game");
        fieldPanel.setVisible(false);
        fieldPanel.removeAll();
        fieldPanel.setLayout(new GridLayout(settings.fieldSize, settings.fieldSize));
        int x = 0;
        int y = 0;
        for (int i = 0; i < settings.fieldSize * settings.fieldSize; i++) {
            fieldPanel.add(new GameButton("", x, y));
            x++;
            if (x > settings.fieldSize - 1) {
                x = 0;
                y++;
            }
        }
        fieldPanel.setVisible(true);

        game = new TicTacToeGame(settings);
    }

    private void gameOver() {
        fieldPanel.setVisible(false);
        fieldPanel.removeAll();
        fieldPanel.setLayout(new GridLayout(2, 1));
        JLabel label = new JLabel("Игра окончена");
        label.setFont(new Font("Arial", Font.PLAIN, fieldPanel.getHeight() / 8));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        String winnerText = "Ничья!";
        if (game.getWinner() != Player.EMPTY) {
            winnerText = "Победил: " + game.getWinner();
        }
        JLabel label1 = new JLabel(winnerText);
        label1.setFont(new Font("Arial", Font.PLAIN, fieldPanel.getHeight() / 8));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        fieldPanel.add(label, BorderLayout.CENTER);
        fieldPanel.add(label1, BorderLayout.CENTER);
        fieldPanel.setVisible(true);
    }

    private void openSettingsWindow() {
        settingsDialog.setVisible(true);
        System.out.println(settings);
        startGame();
    }

    private void showStepAi(Move move) {

        for(Component component : fieldPanel.getComponents()) {

            GameButton button = (GameButton) component;
            if (button.getGameX() == move.getX() && button.getGameY() == move.getY()) {

                button.setEnabled(false);
                button.setText(Player.PLAYER_O.toString());
                button.setFont(new Font("Arial", Font.PLAIN, button.getHeight() - 5));
                break;
            }
        }
    }

    private class GameButton extends JButton {

        private final int gameX;
        private final int gameY;

        public GameButton(String text, int x, int y) {
            super(text);
            this.gameX = x;
            this.gameY = y;
            addActionListener(e->onClick());
        }

        private void onClick() {
            setEnabled(false);
            setText(game.getCurrentPlayer().toString());
            setFont(new Font("Arial", Font.PLAIN, getHeight() - 5));

            game.nextStep(gameX, gameY, game.getCurrentPlayer());

            Move lastStepAi = game.getLastStepAi();

            if (lastStepAi.getX() != -1 && lastStepAi.getY() != -1) {
                showStepAi(lastStepAi);
            }

            if (game.isGameOver()) {
                gameOver();
            }
        }

        public int getGameX() {
            return gameX;
        }

        public int getGameY() {
            return gameY;
        }
    }
}
