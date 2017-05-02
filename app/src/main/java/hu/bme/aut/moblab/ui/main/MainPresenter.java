package hu.bme.aut.moblab.ui.main;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.moblab.interactor.result.ResultsInteractor;
import hu.bme.aut.moblab.interactor.result.events.GetResultsEvent;
import hu.bme.aut.moblab.model.Result;
import hu.bme.aut.moblab.ui.*;
import static hu.bme.aut.moblab.MobSoftApplication.injector;

/**
 * Created by bali on 2017. 03. 24..
 */

public class MainPresenter extends Presenter<MainScreen> {


    @Inject
    ResultsInteractor resultsInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen(){
        bus.unregister(this);
        super.detachScreen();
    }

    public void getFavourites() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                resultsInteractor.getResults();
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
