package com.msport.clientmaster.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by like on 2016/7/26.
 */
public class YueQiuBean implements Serializable{
    /**
     * name : 打文海
     * value : null
     * type : 0
     * sort : null
     * fees : 0.01
     * inviteType : null
     * extLstAttendMember : []
     * inviteAccount : awdawd
     * customName : 李可
     * billId : 201607261701418918345205
     * payMode : null
     * customAddress : 小操场
     * minParticipants : 4
     * currentParticipants : 0
     * avatarList : null
     * activiDateTime : null
     * timeStart : 2016-07-30 16:59:00.0
     * timeEnd : 2016-07-30 20:59:00.0
     * initiator : 123
     * telephone : 18574965284
     * activiNotice : -1
     * activiComment : 一起打
     * totalParticipants : 4
     * createTime : null
     * id : 56
     */

    private String name;
    private String value;
    private String type;
    private String inviteType;
    private String fees;
    private String billId;
    private String inviteAccount;
    private String customName;
    private String initiator;
    private String telephone;
    private String activiNotice;
    private String activiComment;
    private String totalParticipants;
    private String createTime;
    private String payMode;
    private String customAddress;
    private String minParticipants;
    private String currentParticipants;
    private String avatarList;
    private String activiDateTime;
    private String timeStart;
    private String timeEnd;
    private String sort;
    private String id;
    private List<?> extLstAttendMember;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getActiviComment() {
        return activiComment;
    }

    public void setActiviComment(String activiComment) {
        this.activiComment = activiComment;
    }

    public String getActiviDateTime() {
        return activiDateTime;
    }

    public void setActiviDateTime(String activiDateTime) {
        this.activiDateTime = activiDateTime;
    }

    public String getActiviNotice() {
        return activiNotice;
    }

    public void setActiviNotice(String activiNotice) {
        this.activiNotice = activiNotice;
    }

    public String getAvatarList() {
        return avatarList;
    }

    public void setAvatarList(String avatarList) {
        this.avatarList = avatarList;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCurrentParticipants() {
        return currentParticipants;
    }

    public void setCurrentParticipants(String currentParticipants) {
        this.currentParticipants = currentParticipants;
    }

    public String getCustomAddress() {
        return customAddress;
    }

    public void setCustomAddress(String customAddress) {
        this.customAddress = customAddress;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public List<?> getExtLstAttendMember() {
        return extLstAttendMember;
    }

    public void setExtLstAttendMember(List<?> extLstAttendMember) {
        this.extLstAttendMember = extLstAttendMember;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public String getInviteAccount() {
        return inviteAccount;
    }

    public void setInviteAccount(String inviteAccount) {
        this.inviteAccount = inviteAccount;
    }

    public String getInviteType() {
        return inviteType;
    }

    public void setInviteType(String inviteType) {
        this.inviteType = inviteType;
    }

    public String getMinParticipants() {
        return minParticipants;
    }

    public void setMinParticipants(String minParticipants) {
        this.minParticipants = minParticipants;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTotalParticipants() {
        return totalParticipants;
    }

    public void setTotalParticipants(String totalParticipants) {
        this.totalParticipants = totalParticipants;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
