package com.easycrm.orders;

import com.easycrm.contragents.Client;
import com.easycrm.contragents.Organization;
import com.easycrm.users.User;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by drkomp on 25.08.2016.
 */
public class Order {
    private int id;
    private Date date;
    private int number;
    private Client client;
    private Organization organization;
    private int price_sum;
    private int sum;
    private int payedSum;
    private ArrayList<OrderDetail> orderDetails;
    private ArrayList<Check> checks;
    private User manager;
    private User executor;
    private OrderStatus status;
    private String description;


}
