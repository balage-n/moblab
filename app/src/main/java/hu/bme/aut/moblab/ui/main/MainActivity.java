package hu.bme.aut.moblab.ui.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hu.bme.aut.moblab.R;
import hu.bme.aut.moblab.MobSoftApplication;
import hu.bme.aut.moblab.ui.game.GameActivity;
import hu.bme.aut.moblab.ui.highscore.HighscoreActivity;

import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainScreen {

    Button newGameButton;
    Button loginButton;
    Button highscoreButton;
    Button exitButton;

    @Inject
    MainPresenter mainPresenter;

    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);

        loginButton = (Button) findViewById(R.id.loginbutton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
//                alertDialog.setTitle("Login");
//                alertDialog.setMessage("Please type your username/password");
//                EditText usernameInput = new EditText(MainActivity.this);
//                EditText passwordInput = new EditText(MainActivity.this);
//                passwordInput.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
//                usernameInput.setLayoutParams(lp);
//                alertDialog.setView(usernameInput);
//                passwordInput.setLayoutParams(lp);
//                alertDialog.setView(passwordInput);
//                alertDialog.setIcon(R.drawable.key);
//                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Go",
//                    new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//                alertDialog.show();

                showLogin();
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

        // Obtain the shared Tracker instance.
        MobSoftApplication application = (MobSoftApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);

        mTracker.setScreenName("Image~MainActivity");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
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
        final Dialog myDialog = new Dialog(this);
        myDialog.setContentView(R.layout.activity_login);
        myDialog.setCancelable(true);
        Button postLogin = (Button) myDialog.findViewById(R.id.email_sign_in_button);

        EditText emailaddr = (EditText) myDialog.findViewById(R.id.username);
        EditText password = (EditText) myDialog.findViewById(R.id.password);
        myDialog.show();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        myDialog.getWindow().setLayout((6 * metrics.widthPixels)/7, ActionBar.LayoutParams.WRAP_CONTENT);

        postLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO
                mainPresenter.postLogin();
                myDialog.hide();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                loginButton.setText("Logged in");
            }
        });
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }

}
