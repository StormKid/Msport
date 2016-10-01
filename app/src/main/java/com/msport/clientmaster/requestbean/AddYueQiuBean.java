package com.msport.clientmaster.requestbean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by like on 2016/7/27.
 */

public class AddYueQiuBean implements Serializable {


    /**
     * fees : 11
     * initiator : 124
     * telephone : 15926232237
     * activiDateTime : 1467858060
     * timeStart : 1467858060
     * timeEnd : 1467858060
     * totalParticipants : 5
     * name : 新测试活动开始啦
     * customAddress : 湖北省武汉市武昌区梨园小学
     * type : 1
     * customName : 文海
     * avatarList : []
     * activiNotice : haha
     * activiComment : 4654
     * inviteAccount : 12315465465
     * minParticipants : 1
     * payMode : 0
     */

    private String fees;
    private String initiator;
    private String telephone;
    private String activiDateTime;
    private String timeStart;
    private String timeEnd;
    private String totalParticipants;
    private String name;
    private String customAddress;
    private String type;
    private String customName;
    private String activiNotice;
    private String activiComment;
    private String inviteAccount;
    private String minParticipants;
    private String payMode;
    private List<?> avatarList;

    private String inviteType;

    public String getInviteType() {
        return inviteType;
    }

    public void setInviteType(String inviteType) {
        this.inviteType = inviteType;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getActiviDateTime() {
        return activiDateTime;
    }

    public void setActiviDateTime(String activiDateTime) {
        this.activiDateTime = activiDateTime;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTotalParticipants() {
        return totalParticipants;
    }

    public void setTotalParticipants(String totalParticipants) {
        this.totalParticipants = totalParticipants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomAddress() {
        return customAddress;
    }

    public void setCustomAddress(String customAddress) {
        this.customAddress = customAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getActiviNotice() {
        return activiNotice;
    }

    public void setActiviNotice(String activiNotice) {
        this.activiNotice = activiNotice;
    }

    public String getActiviComment() {
        return activiComment;
    }

    public void setActiviComment(String activiComment) {
        this.activiComment = activiComment;
    }

    public String getInviteAccount() {
        return inviteAccount;
    }

    public void setInviteAccount(String inviteAccount) {
        this.inviteAccount = inviteAccount;
    }

    public String getMinParticipants() {
        return minParticipants;
    }

    public void setMinParticipants(String minParticipants) {
        this.minParticipants = minParticipants;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public List<?> getAvatarList() {
        return avatarList;
    }

    public void setAvatarList(List<?> avatarList) {
        this.avatarList = avatarList;
    }
}
