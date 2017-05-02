package hu.bme.aut.moblab.ui.game;

/**
 * Created by bali on 2017. 04. 23..
 */

public interface GameScreen {
    void startGame();
    void askForUsername();
    void pauseGame();
    void incrementScore(int score);
    void decremeentScore(int score);
    void finishGame();
    void showMessage(String text);
}
