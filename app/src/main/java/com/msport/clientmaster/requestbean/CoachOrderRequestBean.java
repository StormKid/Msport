package com.msport.clientmaster.requestbean;

import java.io.Serializable;

/**
 * Created by like on 2016/8/13.
 */
public class CoachOrderRequestBean implements Serializable{

    private String amount;
    private String paymentmode;
    private String payerId;
    private String qScheduleList;
    private String customerAddress;
    private String coachId;
    private String name;
    public String aVenueId = "-1";


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCoachId() {
        return coachId;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }

    public String getqScheduleList() {
        return qScheduleList;
    }

    public void setqScheduleList(String qScheduleList) {
        this.qScheduleList = qScheduleList;
    }
}
