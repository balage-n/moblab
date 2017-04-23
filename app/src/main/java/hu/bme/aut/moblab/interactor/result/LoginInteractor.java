package hu.bme.aut.moblab.interactor.result;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.moblab.MobSoftApplication;
import hu.bme.aut.moblab.repository.Repository;

/**
 * Created by bali on 2017. 04. 23..
 */

public class LoginInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public LoginInteractor() {
        MobSoftApplication.injector.inject(this);
    }



}
