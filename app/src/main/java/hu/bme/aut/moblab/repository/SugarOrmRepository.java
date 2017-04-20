package hu.bme.aut.moblab.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.moblab.model.Result;

/**
 * Created by bali on 2017. 04. 20..
 */

public class SugarOrmRepository implements Repository{
    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Result> getResults() {
        return SugarRecord.listAll(Result.class);
    }

    @Override
    public void saveResult(Result result) {
        SugarRecord.saveInTx(result);
    }

    @Override
    public void removeResult(Result result) {
        SugarRecord.deleteInTx(result);
    }

    @Override
    public boolean isInDB(Result result) {
        return SugarRecord.findById(Result.class, result.getId()) != null;
    }
}
