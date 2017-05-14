package hu.bme.aut.moblab;

/**
 * Created by bali on 2017. 03. 24..
 */

import android.app.Application;

import javax.inject.Inject;
import hu.bme.aut.moblab.repository.Repository;
import hu.bme.aut.moblab.ui.*;

public class MobSoftApplication extends Application {

    @Inject
    Repository repository;

    public void setInjector(MobSoftApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }


    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
        injector.inject(this);
        repository.open(getApplicationContext());
    }
}