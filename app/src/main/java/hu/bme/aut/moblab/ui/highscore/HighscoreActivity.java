package hu.bme.aut.moblab.ui.highscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
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
        setContentView(R.layout.activity_highscore);

        MobSoftApplication.injector.inject(this);

        View wrLinearLayout = findViewById(R.id.world_records);
        View lrLinearLayout = findViewById(R.id.local_records);
        TextView valueTV = new TextView(this);
        valueTV.setText("Józsi - 10 p");
        valueTV.setId(5);
        valueTV.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView valueTV2 = new TextView(this);
        valueTV2.setText("Béla - 5 p");
        valueTV2.setId(6);
        valueTV2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        ((LinearLayout) wrLinearLayout).addView(valueTV);
        ((LinearLayout) lrLinearLayout).addView(valueTV2);
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
