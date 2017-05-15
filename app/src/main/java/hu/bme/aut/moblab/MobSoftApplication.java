package hu.bme.aut.moblab;

/**
 * Created by bali on 2017. 03. 24..
 */

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import javax.inject.Inject;
import hu.bme.aut.moblab.repository.Repository;
import hu.bme.aut.moblab.ui.*;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

public class MobSoftApplication extends Application {

    @Inject
    Repository repository;
    private Tracker mTracker;

    public void setInjector(MobSoftApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }


    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());


        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}