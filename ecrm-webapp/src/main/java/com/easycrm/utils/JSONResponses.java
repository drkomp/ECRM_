package com.easycrm.utils;

import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

/**
 * Created by cube on 20.08.2016.
 */
public final class JSONResponses {
    public static final JSONStreamAware ERROR_INCORRECT_REQUEST;
    public static final JSONStreamAware ERROR_LOGIN_OR_PASSWORD_INCORRECT;

    static {
        JSONObject response = new JSONObject();
        response.put("result","error");
        response.put("errorCode", 1);
        response.put("errorDescription", "Incorrect request");
        ERROR_INCORRECT_REQUEST = JSON.prepare(response);

        response = new JSONObject();
        response.put("result","error");
        response.put("errorCode", 2);
        response.put("errorDescription", "Login failed! Login or password incorrect.");
        ERROR_LOGIN_OR_PASSWORD_INCORRECT = JSON.prepare(response);
    }
}
