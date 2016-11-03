package com.easycrm.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONStreamAware;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cube on 20.08.2016.
 */
public class LoginServlet extends APIHandlerServlet.APIRequestHandler {

    public static final LoginServlet instance = new LoginServlet();


    public static LoginServlet getInstance() {
        return instance;
    }

    private LoginServlet() {
    }

    @Override
    protected JSONStreamAware processRequest(HttpServletRequest request) throws Exception {
        JSONObject jsonObject = new JSONObject();
        String userPass = request.getParameter("pass");
        String userLog = request.getParameter("log");



        String tokenString = userLog +userPass+ System.currentTimeMillis() + (Math.random() * System.currentTimeMillis());
        String md5Hex = DigestUtils.md5Hex(tokenString);
        System.out.println(md5Hex);
        jsonObject.put("key",md5Hex);
       // Factory.getInstance().getUserDAO();
        return jsonObject;
    }
}
