package hu.bme.aut.moblab.ui.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.aut.moblab.MobSoftApplication;
import hu.bme.aut.moblab.R;
import hu.bme.aut.moblab.ui.game.GameActivity;
import hu.bme.aut.moblab.ui.highscore.HighscoreActivity;
import hu.bme.aut.moblab.ui.main.MainPresenter;
import android.content.Intent;
import android.app.Dialog;
import android.widget.Button;


public class MenuActivity extends AppCompatActivity implements MenuScreen {

    @Inject
    MenuPresenter menuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        menuPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        menuPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startNewGame() {
        Intent k = new Intent(MenuActivity.this, GameActivity.class);
        startActivity(k);
    }

    @Override
    public void showHighscore() {
        Intent k = new Intent(MenuActivity.this, HighscoreActivity.class);
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
