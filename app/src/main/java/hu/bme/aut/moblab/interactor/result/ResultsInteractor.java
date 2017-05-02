package hu.bme.aut.moblab.interactor.result;

/**
 * Created by bali on 2017. 04. 20..
 */

import java.util.List;
import javax.inject.Inject;
import de.greenrobot.event.EventBus;
import hu.bme.aut.moblab.MobSoftApplication;
import hu.bme.aut.moblab.interactor.result.events.GetResultsEvent;
import hu.bme.aut.moblab.interactor.result.events.RemoveResultEvent;
import hu.bme.aut.moblab.interactor.result.events.SaveResultEvent;
import hu.bme.aut.moblab.model.Result;
import hu.bme.aut.moblab.repository.Repository;

public class ResultsInteractor {

    @Inject
    Repository repository;
    @Inject
    EventBus bus;

    public ResultsInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getResults() {
        GetResultsEvent event = new GetResultsEvent();
        try {
            List<Result> results = repository.getResults();
            event.setResults(results);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void saveResult(Result result) {

        SaveResultEvent event = new SaveResultEvent();
        event.setResult(result);
        try {
            repository.saveResult(result);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void removeResult(Result result) {
        RemoveResultEvent event = new RemoveResultEvent();
        event.setResults(result);
        try {
            repository.removeResult(result);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
