package hu.bme.aut.moblab.ui.game;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

import javax.inject.Inject;

import hu.bme.aut.moblab.MobSoftApplication;
import hu.bme.aut.moblab.R;
import hu.bme.aut.moblab.ui.main.MainActivity;

/**
 * Created by bali on 2017. 04. 23..
 */

public class GameActivity extends AppCompatActivity implements GameScreen {

    Button pauseButton;
    Button x1Button;
    Button x2Button;
    Button x3Button;
    boolean isPaused = false;
    Integer score = 0;
    int secondsLeft = 60;
    long startTime;
    TextView timerUI;
    TextView scoreUI;
    TextView charUI;
    ArrayList<String> ahArray = new ArrayList<String>();

    @Inject
    GamePresenter gamePresenter;

    CountDownTimer myCountDown = CountdownTimerInitializator(60);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        MobSoftApplication.injector.inject(this);

        // Upload AHA array with random characters
        Random random = new Random();
        int tempRandom;

        for (int i = 0; i < 60; i++) {
            tempRandom = random.nextBoolean() ? 0 : 1;
            if(tempRandom == 1)
                ahArray.add("A");
            else
                ahArray.add("H");
        }

        x1Button = (Button) findViewById(R.id.x1button);
        x2Button = (Button) findViewById(R.id.x2button);
        x3Button = (Button) findViewById(R.id.x3button);

        x1Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((60 - secondsLeft - 1) >= 0) {
                    if(ahArray.get(60 - secondsLeft).equals(ahArray.get(60 - secondsLeft - 1))) {
                        score += 2;
                    } else {
                        if (score > 1)
                            score -= 2;
                    }
                    scoreUI.setText(Integer.toString(score));
                }
            }
        });
        x2Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((60 - secondsLeft - 2) >= 0) {
                    if(ahArray.get(60 - secondsLeft).equals(ahArray.get(60 - secondsLeft - 2))) {
                        score += 3;
                    } else {
                        if (score > 2)
                            score -= 3;
                    }
                    scoreUI.setText(Integer.toString(score));
                }
            }
        });
        x3Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ((60 - secondsLeft - 3) >= 0) {
                    if(ahArray.get(60 - secondsLeft).equals(ahArray.get(60 - secondsLeft - 3))) {
                        score += 4;
                    } else {
                        if (score > 3)
                            score -= 4;
                    }
                    scoreUI.setText(Integer.toString(score));
                }
            }
        });

        scoreUI = (TextView) findViewById(R.id.scorecounter);
        timerUI = (TextView) findViewById(R.id.timecounter);
        charUI = (TextView) findViewById(R.id.characterscreen);

        pauseButton = (Button) findViewById(R.id.pausebutton);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                isPaused = !isPaused;

                secondsLeft = Integer.parseInt(timerUI.getText().toString());
                myCountDown.cancel();

                if(x1Button.isEnabled()) {
                    x1Button.setEnabled(false);
                    x2Button.setEnabled(false);
                    x3Button.setEnabled(false);
                    pauseButton.setText("▶");
                } else {
                    x1Button.setEnabled(true);
                    x2Button.setEnabled(true);
                    x3Button.setEnabled(true);
                    pauseButton.setText("▋▋");
                    myCountDown = CountdownTimerInitializator(secondsLeft + 1);
                    myCountDown.start();
                }
            }
        });

        myCountDown.start();
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

    // Helper method to handle the clock initialization
    CountDownTimer CountdownTimerInitializator(int seconds) {
        return new CountDownTimer(seconds * 1000, 1000) {
            public void onTick(long millisUntilFinished) {
                Random r = new Random();
                int Low = 0;
                int High = 255;
                int redRandom = r.nextInt(High - Low) + Low;
                int greenRandom = r.nextInt(High - Low) + Low;
                int blueRandom = r.nextInt(High - Low) + Low;

                int secondToPrint = (int) millisUntilFinished / 1000;
                timerUI.setText(Long.toString(secondToPrint));
                scoreUI.setText(Integer.toString(score));
                charUI.setText(ahArray.get(60 - secondToPrint));
                charUI.setTextColor(Color.rgb(redRandom, greenRandom, blueRandom));
                secondsLeft = secondToPrint;
            }

            public void onFinish() {
                AlertDialog alertDialog = new AlertDialog.Builder(GameActivity.this).create();
                alertDialog.setTitle("Game Over");
                alertDialog.setMessage("Time is up, your score: " + score);
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        };
    }
}
