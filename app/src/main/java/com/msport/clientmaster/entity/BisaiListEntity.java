package com.msport.clientmaster.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by like on 2016/8/4.
 */
public class BisaiListEntity extends BaseEntity{


    /**
     * name : 测试比赛
     * value : null
     * type : 0
     * sort : null
     * customName : 系统发起
     * avatarList : |/msport-admin/userfiles/c07bd4b956034129b09d04ee7c095822/files/admin/invitatation/2016/08/lALOYiGV_M0B8c0CAA_512_497.png
     * fees : 20
     * inviteAccount : asd
     * inviteType : 1
     * telephone : 123456
     * payMode : null
     * billId : null
     * timeStart : 2016-08-25 16:23:58.0
     * initiator : -1
     * timeEnd : 2016-08-25 16:24:03.0
     * customAddress : null
     * activiNotice : 活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明活动说明
     * activiComment : 活动备注活动备注活动备注活动备注活动备注活动备注活动备注活动备注活动备注活动备注活动备注活动备注活动备注活动备注活动备注活动备注活动备注活动备注
     * isHot : 1
     * createTime : 1470299389000
     * activiDateTime : null
     * currentParticipants : null
     * minParticipants : 1
     * extLstAttendMember : []
     * totalParticipants : 50
     * id : 71
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        private String name;
        private String value;
        private String type;
        private String sort;
        private String customName;
        private String avatarList;
        private String fees;
        private String inviteAccount;
        private String inviteType;
        private String telephone;
        private String payMode;
        private String billId;
        private String timeStart;
        private String initiator;
        private String timeEnd;
        private String customAddress;
        private String activiNotice;
        private String activiComment;
        private String isHot;
        private String createTime;
        private String activiDateTime;
        private String currentParticipants;
        private String minParticipants;
        private String totalParticipants;
        private String id;
        private String matchStyle;
        private List<?> extLstAttendMember;

        private String venueName;

        public String getVenueName() {
            return venueName;
        }

        public void setVenueName(String venueName) {
            this.venueName = venueName;
        }


        public String getMatchStyle() {
            return matchStyle;
        }

        public void setMatchStyle(String matchStyle) {
            this.matchStyle = matchStyle;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getCustomName() {
            return customName;
        }

        public void setCustomName(String customName) {
            this.customName = customName;
        }

        public String getAvatarList() {
            return avatarList;
        }

        public void setAvatarList(String avatarList) {
            this.avatarList = avatarList;
        }

        public String getFees() {
            return fees;
        }

        public void setFees(String fees) {
            this.fees = fees;
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

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getPayMode() {
            return payMode;
        }

        public void setPayMode(String payMode) {
            this.payMode = payMode;
        }

        public String getBillId() {
            return billId;
        }

        public void setBillId(String billId) {
            this.billId = billId;
        }

        public String getTimeStart() {
            return timeStart;
        }

        public void setTimeStart(String timeStart) {
            this.timeStart = timeStart;
        }

        public String getInitiator() {
            return initiator;
        }

        public void setInitiator(String initiator) {
            this.initiator = initiator;
        }

        public String getTimeEnd() {
            return timeEnd;
        }

        public void setTimeEnd(String timeEnd) {
            this.timeEnd = timeEnd;
        }

        public String getCustomAddress() {
            return customAddress;
        }

        public void setCustomAddress(String customAddress) {
            this.customAddress = customAddress;
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

        public String getIsHot() {
            return isHot;
        }

        public void setIsHot(String isHot) {
            this.isHot = isHot;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getActiviDateTime() {
            return activiDateTime;
        }

        public void setActiviDateTime(String activiDateTime) {
            this.activiDateTime = activiDateTime;
        }

        public String getCurrentParticipants() {
            return currentParticipants;
        }

        public void setCurrentParticipants(String currentParticipants) {
            this.currentParticipants = currentParticipants;
        }

        public String getMinParticipants() {
            return minParticipants;
        }

        public void setMinParticipants(String minParticipants) {
            this.minParticipants = minParticipants;
        }

        public String getTotalParticipants() {
            return totalParticipants;
        }

        public void setTotalParticipants(String totalParticipants) {
            this.totalParticipants = totalParticipants;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<?> getExtLstAttendMember() {
            return extLstAttendMember;
        }

        public void setExtLstAttendMember(List<?> extLstAttendMember) {
            this.extLstAttendMember = extLstAttendMember;
        }
    }
}
