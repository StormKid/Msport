package com.msport.clientmaster.requestbean;

import java.io.Serializable;

/**
 * Created by like on 2016/8/22.
 */
public class JiufenRequestBean implements Serializable{


    private String name ;
    private String inviteActiveId;
    private String memberid;

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getInviteActiveId() {
        return inviteActiveId;
    }

    public void setInviteActiveId(String inviteActiveId) {
        this.inviteActiveId = inviteActiveId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
