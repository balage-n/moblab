package hu.bme.aut.moblab.repository;

/**
 * Created by bali on 2017. 04. 20..
 */

import android.content.Context;

import java.util.List;

import hu.bme.aut.moblab.model.LoginRequest;
import hu.bme.aut.moblab.model.Result;

public interface Repository {

    void open(Context context);

    void close();

    List<Result> getResults();

    void saveResult(Result result);

    void saveRequest(LoginRequest loginRequest);

    void removeResult(Result result);

    boolean isInDB(Result result);
}
