package com.msport.clientmaster.bean;

import java.io.Serializable;
/**
 * 用户登陆后填充的实体
 * @author like
 * 2016-5-17
 */
public class LoginBean implements Serializable{
	/**
	 * 用户姓名
	 */
	private String name;
	/**
	 * 用户所在地址
	 */
    private String location;
    /**
     * 用户体重
     */
    private String weight;
    /**
     * 用户工作
     */
    private String job;
    /**
     * 用户性别
     */
    private String sex;
    /**
     * 用户到期时间
     */
    private String expiretime;
    /**
     * 用户生日
     */
    private String birthday;
    /**
     * 用户注册的时间
     */
    private String registetime;
    /**
     * 用户的电话
     */
    private String telephone;
    /**
     * 用户的身高
     */
    private String height;
    /**
     * 用户的第一次购买日期
     */
    private String firstbuytime;
    /**
     * 用户id
     */
    private String id;
    
    /**
     * 用户头像
     */
    private String avatarUrl;
    
    /**
     * 用户年龄 
     */
    private String age;
    
    /**
     * 用户的私钥
     */
    private String secret;
    
    /**
     * 用户的token
     */
    private String accessToken;
	/**
	 * type : 0
	 * unionId : null
	 * openId : 49C1D8FF1E8E58A95C83958762657E81
	 * expireTime : 0
	 */

	private String type;
	private String unionId;
	private String openId;
	private String expireTime;


	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
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
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getExpiretime() {
		return expiretime;
	}
	public void setExpiretime(String expiretime) {
		this.expiretime = expiretime;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
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
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}
}
