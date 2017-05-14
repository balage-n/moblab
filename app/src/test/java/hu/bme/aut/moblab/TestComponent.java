package hu.bme.aut.moblab;

/**
 * Created by bali on 2017. 05. 14..
 */

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.moblab.interactor.InteractorModule;
import hu.bme.aut.moblab.mock.MockNetworkModule;
import hu.bme.aut.moblab.repository.TestRepositoryModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
