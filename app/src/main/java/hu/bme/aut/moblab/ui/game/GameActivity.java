package hu.bme.aut.moblab.ui.game;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.aut.moblab.MobSoftApplication;
import hu.bme.aut.moblab.R;
import hu.bme.aut.moblab.ui.main.MainPresenter;

/**
 * Created by bali on 2017. 04. 23..
 */

public class GameActivity extends AppCompatActivity implements GameScreen {
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_menu);
//    }
    Integer score;
    String username;
    long startTime;

    @Inject
    GamePresenter gamePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        gamePresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        gamePresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void startGame() {
        score = 0;
        startTime = System.currentTimeMillis();
        askForUsername();

    }

    @Override
    public void askForUsername() {
        Dialog myDialog = new Dialog(this);
        myDialog.show();
    }

    @Override
    public void pauseGame() {

    }

    @Override
    public void incrementScore(int score) {
        this.score += score;
    }

    @Override
    public void decremeentScore(int score) {
        this.score -= score;
    }

    @Override
    public void finishGame() {
        gamePresenter.postResult();
    }
}
