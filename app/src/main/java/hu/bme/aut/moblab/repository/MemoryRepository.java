package hu.bme.aut.moblab.repository;

/**
 * Created by bali on 2017. 04. 20..
 */

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.bme.aut.moblab.model.Result;

public class MemoryRepository implements Repository {

    public static List<Result> results;

    @Override
    public void open(Context context) {
        Result result1 = new Result(1L, 10, "Józsi");
        Result result2 = new Result(2L, 20, "Béla");

        results = new ArrayList<>();
        results.add(result1);
        results.add(result2);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Result> getResults() {
        return results;
    }

    @Override
    public void saveResult(Result result) {
        results.add(result);
    }

    @Override
    public void removeResult(Result result) {
        results.remove(result);
    }

    @Override
    public boolean isInDB(Result result) {
        return results.contains(result);
    }
}