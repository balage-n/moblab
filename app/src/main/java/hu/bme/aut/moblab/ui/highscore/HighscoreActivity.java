package hu.bme.aut.moblab.ui.highscore;

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

public class HighscoreActivity extends AppCompatActivity implements HighscoreScreen {
    @Inject
    HighscorePresenter highscorePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        highscorePresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        highscorePresenter.detachScreen();
    }

    @Override
    public void showHighscore() {
        highscorePresenter.getResults();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
