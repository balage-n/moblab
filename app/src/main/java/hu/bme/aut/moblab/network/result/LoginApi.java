package hu.bme.aut.moblab.network.result;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LoginApi {

    /**
     * Sending the credentials of the user
     *
     * @param username Username of the actual user.
     * @param password Password of the actual user.
     * @return Call<Void>
     */

    @POST("login")
    Call<Void> loginPost(
            @Query("username") String username, @Query("password") String password
    );


}
