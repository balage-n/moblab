package hu.bme.aut.moblab.ui.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hu.bme.aut.moblab.R;
import hu.bme.aut.moblab.MobSoftApplication;
import hu.bme.aut.moblab.ui.game.GameActivity;
import hu.bme.aut.moblab.ui.highscore.HighscoreActivity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainScreen {

    Button newGameButton;
    Button loginButton;
    Button highscoreButton;
    Button exitButton;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);

        loginButton = (Button) findViewById(R.id.loginbutton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Login");
                alertDialog.setMessage("You logged in successfully");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                alertDialog.show();
            }
        });

        newGameButton = (Button) findViewById(R.id.newgame);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startNewGame();
            }
        });

        highscoreButton = (Button) findViewById(R.id.highscore);
        highscoreButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showHighscore();
            }
        });

        exitButton = (Button) findViewById(R.id.exit);
        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startNewGame() {
        Intent k = new Intent(MainActivity.this, GameActivity.class);
        startActivity(k);
    }

    @Override
    public void showHighscore() {
        Intent k = new Intent(MainActivity.this, HighscoreActivity.class);
        startActivity(k);
    }

    @Override
    public void showLogin() {
        Dialog myDialog = new Dialog(this);
//        myDialog.setContentView(R.layout.yourxmlfileID);
//        myDialog.setCancelable(true);
//        Button login = (Button) myDialog.findViewById(R.id.yourloginbtnID);
//
//        emailaddr = (EditText) myDialog.findViewById(R.id.youremailID);
//        password = (EditText) myDialog.findViewById(R.id.yourpasswordID);
        myDialog.show();
    }
}
