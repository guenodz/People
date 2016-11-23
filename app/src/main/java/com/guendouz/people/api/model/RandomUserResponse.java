package com.guendouz.people.api.model;

import com.guendouz.people.model.User;

import java.util.List;

/**
 * Created by Guendouz on 22/11/2016.
 */

public class RandomUserResponse {

    private List<User> results;
    private Info info;

    public RandomUserResponse() {
    }

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
