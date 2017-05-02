package hu.bme.aut.moblab.interactor.result.events;

import hu.bme.aut.moblab.model.LoginRequest;
import hu.bme.aut.moblab.model.Result;

/**
 * Created by bali on 2017. 04. 24..
 */

public class PostLoginEvent {
    private int code;
    private LoginRequest request;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public PostLoginEvent() {
    }

    public PostLoginEvent(int code, LoginRequest request, Throwable throwable) {
        this.code = code;
        this.request = request;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


    public void setRequest(LoginRequest request) {
        this.request = request;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    //</editor-fold>
}
