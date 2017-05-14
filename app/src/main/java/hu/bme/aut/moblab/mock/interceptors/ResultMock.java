package hu.bme.aut.moblab.mock.interceptors;

/**
 * Created by bali on 2017. 05. 14..
 */

import android.net.Uri;

import hu.bme.aut.moblab.network.NetworkConfig;
import hu.bme.aut.moblab.repository.MemoryRepository;
import hu.bme.aut.moblab.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.aut.moblab.mock.interceptors.MockHelper.makeResponse;

public class ResultMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "todo/favourite") && request.method().equals("POST")) {
            responseString = "";
            responseCode = 200;

            /**
             * Simple Get Example
             */
			/*
		}else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Todos") && request.method().equals("Get")) {
			MemoryRepository memoryRepository = new MemoryRepository();
			memoryRepository.open(null);
			responseString = GsonHelper.getGson().toJson(memoryRepository.getFavourites());
			responseCode = 200;*/
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
