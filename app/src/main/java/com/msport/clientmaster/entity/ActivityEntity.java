package com.msport.clientmaster.entity;

import java.util.List;

/**
 * Created by like on 2016/8/20.
 */

public class ActivityEntity extends BaseEntity {

    /**
     * name : awd
     * value : null
     * type : 0
     * member : {"name":"like","location":"武汉","type":1,"openId":null,"weight":"69","telephone":"18827347882","secret":null,"avatarUrl":"http://192.168.0.7:8080/msport-admin/userfiles/124/images/admin/mobile/2016/7/1467885070261.png","expireTime":0,"age":"19","accessToken":null,"sex":"2","birthday":null,"registetime":1465292979000,"height":"167","job":"","firstbuytime":1466070107000,"id":"124"}
     * tag : 0
     * sort : null
     * activiDateTime : null
     * currentParticipants : 1
     * minParticipants : 1
     * extLstAttendMember : [{"name":"换手机号说说","location":"湖北 孝感 安陆市","type":1,"openId":null,"weight":"89","telephone":"15172518243","secret":null,"avatarUrl":"userfiles/80/images/admin/mobile/2016/7/1468219038750.png","expireTime":0,"age":"24","accessToken":null,"sex":"0","birthday":null,"registetime":1461116517000,"height":"173","job":null,"firstbuytime":1466059865000,"id":"80"}]
     * totalParticipants : 1
     * inviteType : null
     * customAddress : 奥万大
     * timeStart : 2016-07-11 19:48:00.0
     * customName : awd
     * inviteAccount : null
     * initiator : 124
     * fees : 12
     * billId : 201607111849121468234152612675
     * avatarList : null
     * timeEnd : 2016-07-11 23:06:00.0
     * payMode : null
     * telephone : 18574952648
     * activiNotice : -1
     * activiComment : 
     * createTime : null
     * isHot : null
     * matchStyle : null
     * venueName : null
     * matchType : null
     * dispute : 0
     * id : 47
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String name;
        private String value;
        private String type;
        /**
         * name : like
         * location : 武汉
         * type : 1
         * openId : null
         * weight : 69
         * telephone : 18827347882
         * secret : null
         * avatarUrl : http://192.168.0.7:8080/msport-admin/userfiles/124/images/admin/mobile/2016/7/1467885070261.png
         * expireTime : 0
         * age : 19
         * accessToken : null
         * sex : 2
         * birthday : null
         * registetime : 1465292979000
         * height : 167
         * job : 
         * firstbuytime : 1466070107000
         * id : 124
         */

        private MemberBean member;
        private String tag;
        private String sort;
        private String activiDateTime;
        private String currentParticipants;
        private String minParticipants;
        private String totalParticipants;
        private String inviteType;
        private String customAddress;
        private String timeStart;
        private String customName;
        private String inviteAccount;
        private String initiator;
        private String fees;
        private String billId;
        private String avatarList;
        private String timeEnd;
        private String payMode;
        private String telephone;
        private String activiNotice;
        private String activiComment;
        private String createTime;
        private String isHot;
        private String matchStyle;
        private String venueName;
        private String matchType;
        private String dispute;
        private String id;
        /**
         * name : 换手机号说说
         * location : 湖北 孝感 安陆市
         * type : 1
         * openId : null
         * weight : 89
         * telephone : 15172518243
         * secret : null
         * avatarUrl : userfiles/80/images/admin/mobile/2016/7/1468219038750.png
         * expireTime : 0
         * age : 24
         * accessToken : null
         * sex : 0
         * birthday : null
         * registetime : 1461116517000
         * height : 173
         * job : null
         * firstbuytime : 1466059865000
         * id : 80
         */

        private List<ExtLstAttendMemberBean> extLstAttendMember;

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

        public MemberBean getMember() {
            return member;
        }

        public void setMember(MemberBean member) {
            this.member = member;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
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

        public String getInviteType() {
            return inviteType;
        }

        public void setInviteType(String inviteType) {
            this.inviteType = inviteType;
        }

        public String getCustomAddress() {
            return customAddress;
        }

        public void setCustomAddress(String customAddress) {
            this.customAddress = customAddress;
        }

        public String getTimeStart() {
            return timeStart;
        }

        public void setTimeStart(String timeStart) {
            this.timeStart = timeStart;
        }

        public String getCustomName() {
            return customName;
        }

        public void setCustomName(String customName) {
            this.customName = customName;
        }

        public String getInviteAccount() {
            return inviteAccount;
        }

        public void setInviteAccount(String inviteAccount) {
            this.inviteAccount = inviteAccount;
        }

        public String getInitiator() {
            return initiator;
        }

        public void setInitiator(String initiator) {
            this.initiator = initiator;
        }

        public String getFees() {
            return fees;
        }

        public void setFees(String fees) {
            this.fees = fees;
        }

        public String getBillId() {
            return billId;
        }

        public void setBillId(String billId) {
            this.billId = billId;
        }

        public String getAvatarList() {
            return avatarList;
        }

        public void setAvatarList(String avatarList) {
            this.avatarList = avatarList;
        }

        public String getTimeEnd() {
            return timeEnd;
        }

        public void setTimeEnd(String timeEnd) {
            this.timeEnd = timeEnd;
        }

        public String getPayMode() {
            return payMode;
        }

        public void setPayMode(String payMode) {
            this.payMode = payMode;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
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

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getIsHot() {
            return isHot;
        }

        public void setIsHot(String isHot) {
            this.isHot = isHot;
        }

        public String getMatchStyle() {
            return matchStyle;
        }

        public void setMatchStyle(String matchStyle) {
            this.matchStyle = matchStyle;
        }

        public String getVenueName() {
            return venueName;
        }

        public void setVenueName(String venueName) {
            this.venueName = venueName;
        }

        public String getMatchType() {
            return matchType;
        }

        public void setMatchType(String matchType) {
            this.matchType = matchType;
        }

        public String getDispute() {
            return dispute;
        }

        public void setDispute(String dispute) {
            this.dispute = dispute;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<ExtLstAttendMemberBean> getExtLstAttendMember() {
            return extLstAttendMember;
        }

        public void setExtLstAttendMember(List<ExtLstAttendMemberBean> extLstAttendMember) {
            this.extLstAttendMember = extLstAttendMember;
        }

        public static class MemberBean {
            private String name;
            private String location;
            private String type;
            private String openId;
            private String weight;
            private String telephone;
            private String secret;
            private String avatarUrl;
            private String expireTime;
            private String age;
            private String accessToken;
            private String sex;
            private String birthday;
            private String registetime;
            private String height;
            private String job;
            private String firstbuytime;
            private String id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getOpenId() {
                return openId;
            }

            public void setOpenId(String openId) {
                this.openId = openId;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public String getSecret() {
                return secret;
            }

            public void setSecret(String secret) {
                this.secret = secret;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public String getExpireTime() {
                return expireTime;
            }

            public void setExpireTime(String expireTime) {
                this.expireTime = expireTime;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getAccessToken() {
                return accessToken;
            }

            public void setAccessToken(String accessToken) {
                this.accessToken = accessToken;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getRegistetime() {
                return registetime;
            }

            public void setRegistetime(String registetime) {
                this.registetime = registetime;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getJob() {
                return job;
            }

            public void setJob(String job) {
                this.job = job;
            }

            public String getFirstbuytime() {
                return firstbuytime;
            }

            public void setFirstbuytime(String firstbuytime) {
                this.firstbuytime = firstbuytime;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class ExtLstAttendMemberBean {
            private String name;
            private String location;
            private String type;
            private String openId;
            private String weight;
            private String telephone;
            private String secret;
            private String avatarUrl;
            private String expireTime;
            private String age;
            private String accessToken;
            private String sex;
            private String birthday;
            private String registetime;
            private String height;
            private String job;
            private String firstbuytime;
            private String id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getOpenId() {
                return openId;
            }

            public void setOpenId(String openId) {
                this.openId = openId;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }

            public String getTelephone() {
                return telephone;
            }

            public void setTelephone(String telephone) {
                this.telephone = telephone;
            }

            public String getSecret() {
                return secret;
            }

            public void setSecret(String secret) {
                this.secret = secret;
            }

            public String getAvatarUrl() {
                return avatarUrl;
            }

            public void setAvatarUrl(String avatarUrl) {
                this.avatarUrl = avatarUrl;
            }

            public String getExpireTime() {
                return expireTime;
            }

            public void setExpireTime(String expireTime) {
                this.expireTime = expireTime;
            }

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getAccessToken() {
                return accessToken;
            }

            public void setAccessToken(String accessToken) {
                this.accessToken = accessToken;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getRegistetime() {
                return registetime;
            }

            public void setRegistetime(String registetime) {
                this.registetime = registetime;
            }

            public String getHeight() {
                return height;
            }

            public void setHeight(String height) {
                this.height = height;
            }

            public String getJob() {
                return job;
            }

            public void setJob(String job) {
                this.job = job;
            }

            public String getFirstbuytime() {
                return firstbuytime;
            }

            public void setFirstbuytime(String firstbuytime) {
                this.firstbuytime = firstbuytime;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
