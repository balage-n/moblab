package hu.bme.aut.moblab.interactor.result.events;

import hu.bme.aut.moblab.model.Result;
/**
 * Created by bali on 2017. 04. 20..
 */

public class SaveResultEvent {
    private int code;
    private Result result;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public SaveResultEvent() {
    }

    public SaveResultEvent(int code, Result result, Throwable throwable) {
        this.code = code;
        this.result = result;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    //</editor-fold>
}
