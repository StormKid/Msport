package com.msport.clientmaster.entity;

import java.util.List;

/**
 * Created by like on 2016/8/1.
 */

public class TagListEntity extends  BaseEntity {


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * value : 1
         * description : ms_comment_desc
         * orderBy : null
         * label : 效果明显
         * id : 390de727ed6d4f088b02d6cddb85c7df
         */

        private List<CoachEvaluateBean> coachEvaluate;

        public List<CoachEvaluateBean> getCoachEvaluate() {
            return coachEvaluate;
        }

        public void setCoachEvaluate(List<CoachEvaluateBean> coachEvaluate) {
            this.coachEvaluate = coachEvaluate;
        }

        public static class CoachEvaluateBean {
            private String value;
            private String description;
            private String orderBy;
            private String label;
            private String id;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getOrderBy() {
                return orderBy;
            }

            public void setOrderBy(String orderBy) {
                this.orderBy = orderBy;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
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
