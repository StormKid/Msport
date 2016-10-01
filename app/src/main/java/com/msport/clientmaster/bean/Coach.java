package com.msport.clientmaster.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by like on 2016/7/28.
 */

public class Coach implements Serializable{


    /**
     * name : 李教练
     * value : 0
     * major : 50
     * courseList : []
     * sort : 0
     * courseCatagoryList : []
     * servIdTimeList : ["2","1"]
     * availabletimeid : null
     * qualificationCoachList : []
     * fees : 50
     * telephone : 1231312313
     * isHot : 1
     * weight : 80
     * cooperatetype : 2
     * cooperatetime : 1462949820000
     * contractimage :
     * isapproval : 1
     * age : null
     * height : 170
     * Stringroduce :
     * album :
     * servTime : ,2,1,
     * servRange : ,0,1,
     * avatarimg :
     * scheduleid : null
     * setttletype : 1
     * msVenueId : null
     * formal : 4
     * gender : 1
     * othermajor :
     * venueNames : 洪山广场,汉街
     * id : 10
     */

    private String name;
    private String value;
    private String major;
    private String sort;
    private String availabletimeid;
    private String fees;
    private String telephone;
    private String isHot;
    private String weight;
    private String cooperatetype;
    private long cooperatetime;
    private String contractimage;
    private String isapproval;
    private String age;
    private String height;
    private String Stringroduce;
    private String album;
    private String servTime;
    private String servRange;
    private String avatarimg;
    private String scheduleid;
    private String setttletype;
    private String msVenueId;
    private String formal;
    private String gender;
    private String othermajor;
    private String venueNames;
    private String id;
    private List<?> courseList;
    private List<?> courseCatagoryList;
    private List<String> servIdTimeList;
    private List<?> qualificationCoachList;

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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getAvailabletimeid() {
        return availabletimeid;
    }

    public void setAvailabletimeid(String availabletimeid) {
        this.availabletimeid = availabletimeid;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCooperatetype() {
        return cooperatetype;
    }

    public void setCooperatetype(String cooperatetype) {
        this.cooperatetype = cooperatetype;
    }

    public long getCooperatetime() {
        return cooperatetime;
    }

    public void setCooperatetime(long cooperatetime) {
        this.cooperatetime = cooperatetime;
    }

    public String getContractimage() {
        return contractimage;
    }

    public void setContractimage(String contractimage) {
        this.contractimage = contractimage;
    }

    public String getIsapproval() {
        return isapproval;
    }

    public void setIsapproval(String isapproval) {
        this.isapproval = isapproval;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getStringroduce() {
        return Stringroduce;
    }

    public void setStringroduce(String Stringroduce) {
        this.Stringroduce = Stringroduce;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getServTime() {
        return servTime;
    }

    public void setServTime(String servTime) {
        this.servTime = servTime;
    }

    public String getServRange() {
        return servRange;
    }

    public void setServRange(String servRange) {
        this.servRange = servRange;
    }

    public String getAvatarimg() {
        return avatarimg;
    }

    public void setAvatarimg(String avatarimg) {
        this.avatarimg = avatarimg;
    }

    public String getScheduleid() {
        return scheduleid;
    }

    public void setScheduleid(String scheduleid) {
        this.scheduleid = scheduleid;
    }

    public String getSetttletype() {
        return setttletype;
    }

    public void setSetttletype(String setttletype) {
        this.setttletype = setttletype;
    }

    public String getMsVenueId() {
        return msVenueId;
    }

    public void setMsVenueId(String msVenueId) {
        this.msVenueId = msVenueId;
    }

    public String getFormal() {
        return formal;
    }

    public void setFormal(String formal) {
        this.formal = formal;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOthermajor() {
        return othermajor;
    }

    public void setOthermajor(String othermajor) {
        this.othermajor = othermajor;
    }

    public String getVenueNames() {
        return venueNames;
    }

    public void setVenueNames(String venueNames) {
        this.venueNames = venueNames;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<?> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<?> courseList) {
        this.courseList = courseList;
    }

    public List<?> getCourseCatagoryList() {
        return courseCatagoryList;
    }

    public void setCourseCatagoryList(List<?> courseCatagoryList) {
        this.courseCatagoryList = courseCatagoryList;
    }

    public List<String> getServIdTimeList() {
        return servIdTimeList;
    }

    public void setServIdTimeList(List<String> servIdTimeList) {
        this.servIdTimeList = servIdTimeList;
    }

    public List<?> getQualificationCoachList() {
        return qualificationCoachList;
    }

    public void setQualificationCoachList(List<?> qualificationCoachList) {
        this.qualificationCoachList = qualificationCoachList;
    }
}
