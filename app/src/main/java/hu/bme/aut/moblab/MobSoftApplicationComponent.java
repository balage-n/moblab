package hu.bme.aut.moblab;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.moblab.interactor.InteractorModule;
import hu.bme.aut.moblab.interactor.result.LoginInteractor;
import hu.bme.aut.moblab.interactor.result.ResultsInteractor;
import hu.bme.aut.moblab.repository.RepositoryModule;
import hu.bme.aut.moblab.ui.UIModule;
import hu.bme.aut.moblab.ui.game.GameActivity;
import hu.bme.aut.moblab.ui.game.GamePresenter;
import hu.bme.aut.moblab.ui.highscore.HighscoreActivity;
import hu.bme.aut.moblab.ui.highscore.HighscorePresenter;
import hu.bme.aut.moblab.ui.main.MainActivity;
import hu.bme.aut.moblab.ui.main.MainPresenter;

/**
 * Created by bali on 2017. 03. 24..
 */

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(HighscoreActivity highscoreActivity);

    void inject(GameActivity gameActivity);

    void inject(ResultsInteractor resultsInteractor);

    void inject(LoginInteractor loginInteractor);

    void inject(MobSoftApplication mobSoftApplication);

    void inject(MainPresenter mainPresenter);

    void inject(GamePresenter gamePresenter);

    void inject(HighscorePresenter highscorePresenter);
}
