package com.easycrm.services;

import com.easycrm.hibernate.Factory;
import com.easycrm.hibernate.HibernateUtil;
import com.easycrm.users.LogonDetails;
import com.easycrm.users.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by drkomp on 13.11.2016.
 */
public class LoginService {
    public static final LoginService instance = new LoginService();

    public static LoginService getInstance() { return instance;}

    public LoginService() {
    }

    public JSONObject loginUser (HttpServletRequest request) {
        JSONObject jsonObject = new JSONObject();
        String userPass = request.getParameter("pass");
        String userLog = request.getParameter("log");
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            Transaction tx = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
            List<User> users = Factory.getInstance().getUserDao().findItByField("nickName", userLog);
            if ((users.size() == 1) && (users.get(0).getPassword().equals(userPass)) && !users.get(0).isBaned()) {
                //login OK
                String tokenString = userLog + userPass + System.currentTimeMillis() + (Math.random() * System.currentTimeMillis());
                String md5Hex = DigestUtils.md5Hex(tokenString);
                //System.out.println(md5Hex);
                User logedUser = users.get(0);
                if (logedUser.getLogonDetails() == null) {
                    logedUser.setLogonDetails(new LogonDetails().setKey(md5Hex).setLogonDate(new Date())
                            .setLastActivity(new Date()).setUser(logedUser));
                } else { //already logged
                    md5Hex = logedUser.getLogonDetails().getKey();
                }
                session.flush();
                jsonObject.put("key", md5Hex);
                jsonObject.put("result", "ok");
            } else { //login failed!
                 jsonObject = JsonResponses.ERROR_LOGIN_OR_PASSWORD_INCORRECT;
            }
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("In catch");
            System.out.println(e);
        }
        return jsonObject;
    }
}
