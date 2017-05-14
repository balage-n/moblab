package hu.bme.aut.moblab.network;

/**
 * Created by bali on 2017. 05. 14..
 */
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.moblab.network.result.*;
import hu.bme.aut.moblab.utils.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public ResultsApi provideATodoApi(Retrofit retrofit) {
        return retrofit.create(ResultsApi.class);
    }


}