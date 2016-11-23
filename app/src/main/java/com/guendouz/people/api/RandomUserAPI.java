package com.guendouz.people.api;

import com.guendouz.people.api.model.RandomUserResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 *
 * This class is used as Wrapper around the API
 */

public interface RandomUserAPI {

    String SERVICE_ENDPOINT = "https://randomuser.me/";

    @GET("api/")
    Observable<RandomUserResponse> getRandomUsers(@Query("results") Integer results);

    class Factory {
        public static RandomUserAPI create() {
            return ServiceFactory.createRetrofitService(RandomUserAPI.class, SERVICE_ENDPOINT);
        }
    }
}
