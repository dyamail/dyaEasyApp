package com.example.administrator.baselib.retrofit;

import com.example.administrator.baselib.client.ResultInfo;

/**
 * Created by yang
 * jjs1
 * 201706 301113
 * NewYYDB
 * 折扣商城
 */
public class DiscountBean extends Response {
    /**
     * code ;// 200
     * data ;// [{discount;//0.8,market_price;//1000,p_id;//95,p_main_img;//www.baidu.com,p_name;//中石化加油卡面值1000元,payment_num;//1,single_price;//800},{discount;//0.9,market_price;//1000,p_id;//96,p_main_img;//www.hao123.com,p_name;//中石化加油卡面值1000元,payment_num;//1,single_price;//900}]
     * msg ;// 请求成功
     */

//
        /**
         * discount ;// 0.8
         * market_price ;// 1000
         * p_id ;// 95
         * p_main_img ;// www.baidu.com
         * p_name ;// 中石化加油卡面值1000元
         * payment_num ;// 1
         * single_price ;// 800
         */

        private String market_price;//1000,
        private String delivery_fee;//12,
        private String discount;//6,
        private String p_main_img;//www.baidu.com,
        private String p_id;//95,
        private String preferral;//www.baidu.com,
        private String p_name;//中石化加油卡面值1000元,
        private String p_ad_img;//,
        private String monthly_sales;//0,
        private String payment_num;//0,
        private String discount_price;//600

        public String getMarket_price() {
            return market_price;
        }

        public void setMarket_price(String market_price) {
            this.market_price = market_price;
        }

        public String getDelivery_fee() {
            return delivery_fee;
        }

        public void setDelivery_fee(String delivery_fee) {
            this.delivery_fee = delivery_fee;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public String getP_main_img() {
            return p_main_img;
        }

        public void setP_main_img(String p_main_img) {
            this.p_main_img = p_main_img;
        }

        public String getP_id() {
            return p_id;
        }

        public void setP_id(String p_id) {
            this.p_id = p_id;
        }

        public String getPreferral() {
            return preferral;
        }

        public void setPreferral(String preferral) {
            this.preferral = preferral;
        }

        public String getP_name() {
            return p_name;
        }

        public void setP_name(String p_name) {
            this.p_name = p_name;
        }

        public String getP_ad_img() {
            return p_ad_img;
        }

        public void setP_ad_img(String p_ad_img) {
            this.p_ad_img = p_ad_img;
        }

        public String getMonthly_sales() {
            return monthly_sales;
        }

        public void setMonthly_sales(String monthly_sales) {
            this.monthly_sales = monthly_sales;
        }

        public String getPayment_num() {
            return payment_num;
        }

        public void setPayment_num(String payment_num) {
            this.payment_num = payment_num;
        }

        public String getDiscount_price() {
            return discount_price;
        }

        public void setDiscount_price(String discount_price) {
            this.discount_price = discount_price;

    }

//    private String code;
//    private String msg;
//    private String token;
//    private String discount;//折扣率
//    private String market_price;//市场价格
//    private String P_name;//折扣商品名称
//    private String p_main_img;//图片地址
//    private String payment_num;//已付款人数
//    private String single_price;//折后价格


}
