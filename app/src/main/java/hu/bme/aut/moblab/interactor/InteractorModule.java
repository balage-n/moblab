package hu.bme.aut.moblab.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.moblab.interactor.result.ResultsInteractor;

/**
 * Created by bali on 2017. 04. 20..
 */

@Module
public class InteractorModule {

    @Provides
    public ResultsInteractor provideFavourites() {
        return new ResultsInteractor();
    }
}
