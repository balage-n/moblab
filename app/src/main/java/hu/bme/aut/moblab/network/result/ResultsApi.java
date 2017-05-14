package hu.bme.aut.moblab.network.result;

import hu.bme.aut.moblab.model.Result;
import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ResultsApi {

    /**
     * Post the result of the actual logged in user
     *
     * @param username Name of the actual user.
     * @param score Score reached by actual user.
     * @return Call<Void>
     */

    @POST("result")
    Call<Void> resultPost(
            @Query("username") String username, @Query("score") BigDecimal score
    );


    /**
     * Results of other players so far
     * The Results endpoint returns information about the highscores of the top10 users in the world. The response includes the display name\nand reached score of each users, and lists them in a descreasing order.
     * @return Call<List<Result>>
     */

    @GET("results")
    Call<List<Result>> resultsGet();



}
