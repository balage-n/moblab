package hu.bme.aut.moblab.interactor.result.events;

import java.util.List;

import hu.bme.aut.moblab.model.Result;
/**
 * Created by bali on 2017. 04. 20..
 */

public class GetResultsEvent {
    private int code;
    private List<Result> results;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public GetResultsEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

//</editor-fold>
}
