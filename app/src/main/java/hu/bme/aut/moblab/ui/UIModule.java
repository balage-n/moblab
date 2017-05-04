package hu.bme.aut.moblab.ui;

import de.greenrobot.event.EventBus;
import hu.bme.aut.moblab.ui.game.GamePresenter;
import hu.bme.aut.moblab.ui.highscore.HighscorePresenter;
import hu.bme.aut.moblab.ui.main.MainPresenter;
import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public GamePresenter provideGamePresenter() {
        return new GamePresenter();
    }

    @Provides
    @Singleton
    public HighscorePresenter provideHighscorePresenter() {
        return new HighscorePresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}