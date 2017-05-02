package hu.bme.aut.moblab.ui.menu;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.moblab.interactor.result.LoginInteractor;
import hu.bme.aut.moblab.interactor.result.ResultsInteractor;
import hu.bme.aut.moblab.interactor.result.events.GetResultsEvent;
import hu.bme.aut.moblab.model.LoginRequest;
import hu.bme.aut.moblab.model.Result;
import hu.bme.aut.moblab.ui.*;
import hu.bme.aut.moblab.ui.main.MainScreen;

import static hu.bme.aut.moblab.MobSoftApplication.injector;

/**
 * Created by bali on 2017. 03. 24..
 */

public class MenuPresenter extends Presenter<MenuScreen> {

    @Inject
    LoginInteractor loginInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(MenuScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void postLogin() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                loginInteractor.postLogin(new LoginRequest("1234", "Aladar"));
            }
        });
    }

    public void onEventMainThread(GetResultsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                for(Result t : event.getResults()){
                    screen.showMessage(t.getName());;
                }
            }
        }
    }

}
