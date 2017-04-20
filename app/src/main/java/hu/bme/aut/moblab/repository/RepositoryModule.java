package hu.bme.aut.moblab.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
/**
 * Created by bali on 2017. 04. 20..
 */

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new SugarOrmRepository();
    }
}
