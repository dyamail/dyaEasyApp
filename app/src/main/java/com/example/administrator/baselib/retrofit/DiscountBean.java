package com.example.administrator.baselib.retrofit;

import com.example.administrator.baselib.client.ResultInfo;

import java.util.List;

/**
 * Created by yang
 * jjs1
 * 201706 301113
 * NewYYDB
 * 折扣商城
 */
public class DiscountBean{


    /**
     * data : {"treasures":[{"progress":0.75,"taskId":258,"pMainImg":"1","pName":"测试1"},{"progress":0,"taskId":242,"pMainImg":"7","pName":"测试6"},{"progress":0,"taskId":263,"pMainImg":"4","pName":"测试4"},{"progress":0,"taskId":260,"pMainImg":"9","pName":"测试9"},{"progress":0,"taskId":257,"pMainImg":"10","pName":"测试10"},{"progress":0,"taskId":252,"pMainImg":"8","pName":"测试8"},{"progress":0,"taskId":249,"pMainImg":"3","pName":"测试3"},{"progress":0,"taskId":264,"pMainImg":"596ed56a32ea5.png","pName":"夺宝1修改"},{"progress":0,"taskId":262,"pMainImg":"2","pName":"测试2"},{"progress":0,"taskId":256,"pMainImg":"5","pName":"测试5"}],"ad":[{"status":-1,"adImg":"444","tId":44,"url":"44"},{"adImg":"/Uploads/ads/5970680fe3bb1.jpg","status":-1,"url":"http://www.baidu.com"},{"status":1,"tId":97,"adImg":"59719b03dccf3.jpg"}]}
     */

//    private DataBean data;
//
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
//    public static class DataBean {
        private List<TreasuresBean> treasures;
        private List<AdBean> ad;

        public List<TreasuresBean> getTreasures() {
            return treasures;
        }

        public void setTreasures(List<TreasuresBean> treasures) {
            this.treasures = treasures;
        }

        public List<AdBean> getAd() {
            return ad;
        }

        public void setAd(List<AdBean> ad) {
            this.ad = ad;
        }

        public static class TreasuresBean {
            /**
             * progress : 0.75
             * taskId : 258
             * pMainImg : 1
             * pName : 测试1
             */

            private double progress;
            private int taskId;
            private String pMainImg;
            private String pName;

            public double getProgress() {
                return progress;
            }

            public void setProgress(double progress) {
                this.progress = progress;
            }

            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
            }

            public String getPMainImg() {
                return pMainImg;
            }

            public void setPMainImg(String pMainImg) {
                this.pMainImg = pMainImg;
            }

            public String getPName() {
                return pName;
            }

            public void setPName(String pName) {
                this.pName = pName;
            }
        }

        public static class AdBean {
            /**
             * status : -1
             * adImg : 444
             * tId : 44
             * url : 44
             */

            private int status;
            private String adImg;
            private int tId;
            private String url;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getAdImg() {
                return adImg;
            }

            public void setAdImg(String adImg) {
                this.adImg = adImg;
            }

            public int getTId() {
                return tId;
            }

            public void setTId(int tId) {
                this.tId = tId;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
//    }
}
