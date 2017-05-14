package hu.bme.aut.moblab.repository;

/**
 * Created by bali on 2017. 05. 14..
 */

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestRepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new MemoryRepository();
    }
}
