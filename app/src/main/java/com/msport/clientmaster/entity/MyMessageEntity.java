package com.msport.clientmaster.entity;

import java.util.List;

/**
 * Created by like on 2016/8/16.
 */

public class MyMessageEntity extends  BaseEntity {


    /**
     * type : 1
     * content : 我们的外卖为什么还没有到
     * validTimeStart : null
     * validTimeEnd : null
     * isTop : 0
     * isEnable : 0
     * nowTime : null
     * createTime : 1471318321000
     * title : 我们的外卖呢
     * id : 10
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String type;
        private String content;
        private String validTimeStart;
        private String validTimeEnd;
        private String isTop;
        private String isEnable;
        private String nowTime;
        private String createTime;
        private String title;
        private String id;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getValidTimeStart() {
            return validTimeStart;
        }

        public void setValidTimeStart(String validTimeStart) {
            this.validTimeStart = validTimeStart;
        }

        public String getValidTimeEnd() {
            return validTimeEnd;
        }

        public void setValidTimeEnd(String validTimeEnd) {
            this.validTimeEnd = validTimeEnd;
        }

        public String getIsTop() {
            return isTop;
        }

        public void setIsTop(String isTop) {
            this.isTop = isTop;
        }

        public String getIsEnable() {
            return isEnable;
        }

        public void setIsEnable(String isEnable) {
            this.isEnable = isEnable;
        }

        public String getNowTime() {
            return nowTime;
        }

        public void setNowTime(String nowTime) {
            this.nowTime = nowTime;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
