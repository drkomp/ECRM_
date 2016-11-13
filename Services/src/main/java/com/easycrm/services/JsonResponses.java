package com.easycrm.services;

import org.json.simple.JSONObject;

/**
 * Created by drkomp on 13.11.2016.
 */
public final class JsonResponses {
    public static final JSONObject ERROR_LOGIN_OR_PASSWORD_INCORRECT;

    static {
        JSONObject response = new JSONObject();
//        response.put("result", "error");
//        response.put("errorCode", 1);
//        response.put("errorDescription", "Incorrect request");
//        ERROR_INCORRECT_REQUEST = response;

        response = new JSONObject();
        response.put("result", "error");
        response.put("errorCode", 2);
        response.put("errorDescription", "Login failed! Login or password incorrect.");
        ERROR_LOGIN_OR_PASSWORD_INCORRECT = response;
    }
}

