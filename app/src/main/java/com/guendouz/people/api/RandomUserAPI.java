package com.guendouz.people.api;

import com.guendouz.people.api.model.RandomUserResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * This class is used as Wrapper around the RandomUser.me API
 */

public interface RandomUserAPI {

    String SERVICE_ENDPOINT = "https://randomuser.me/";

    /**
     * @param results the number of results (users) to generate
     * @return An Observable object that contains the response
     */
    @GET("api/")
    Observable<RandomUserResponse> getRandomUsers(@Query("results") Integer results);

    class Factory {
        public static RandomUserAPI create() {
            return ServiceFactory.createRetrofitService(RandomUserAPI.class, SERVICE_ENDPOINT);
        }
    }
}
