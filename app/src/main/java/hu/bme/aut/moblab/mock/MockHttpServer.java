package hu.bme.aut.moblab.mock;

/**
 * Created by bali on 2017. 05. 14..
 */

import hu.bme.aut.moblab.mock.interceptors.MockInterceptor;
import okhttp3.Request;
import okhttp3.Response;

public class MockHttpServer {

    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}