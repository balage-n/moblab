package hu.bme.aut.moblab;

/**
 * Created by bali on 2017. 03. 24..
 */

import android.app.Application;

import hu.bme.aut.moblab.ui.*;

public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}