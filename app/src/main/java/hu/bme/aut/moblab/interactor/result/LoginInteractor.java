package hu.bme.aut.moblab.interactor.result;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.moblab.MobSoftApplication;
import hu.bme.aut.moblab.interactor.result.events.PostLoginEvent;
import hu.bme.aut.moblab.interactor.result.events.SaveResultEvent;
import hu.bme.aut.moblab.model.LoginRequest;
import hu.bme.aut.moblab.model.Result;
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

    public void postLogin(LoginRequest loginRequest) {
        PostLoginEvent event = new PostLoginEvent();
        event.setRequest(loginRequest);
        try {
            repository.saveRequest(loginRequest);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

}
