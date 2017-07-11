package com.example.myaliapplication.bean;

import java.util.List;

/**
 * 社保卡余额信息
 */

public class CardBalance {

    /**
     * balance : 社保卡余额
     * consumptionDetails :
     * [
     * {"time":"消费时间","amount":"消费金额","location":"消费地点 公司和分店以\u2018\n\u2019分割，格式例子：河南张仲景大药房股份有限公司\n郑州东风路一店"},
     * {"time":"消费时间","amount":"消费金额","location":"消费地点 公司和分店以\u2018\n\u2019分割，格式例子：河南张仲景大药房股份有限公司\n郑州东风路一店"},
     * {"time":"消费时间","amount":"消费金额","location":"消费地点 公司和分店以\u2018\n\u2019分割，格式例子：河南张仲景大药房股份有限公司\n郑州东风路一店"},
     * {"time":"消费时间","amount":"消费金额","location":"消费地点 公司和分店以\u2018\n\u2019分割，格式例子：河南张仲景大药房股份有限公司\n郑州东风路一店"},
     * {"time":"消费时间","amount":"消费金额","location":"消费地点 公司和分店以\u2018\n\u2019分割，格式例子：河南张仲景大药房股份有限公司\n郑州东风路一店"}
     * ]
     */

    private String balance;
    private List<ConsumptionDetailsBean> consumptionDetails;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public List<ConsumptionDetailsBean> getConsumptionDetails() {
        return consumptionDetails;
    }

    public void setConsumptionDetails(List<ConsumptionDetailsBean> consumptionDetails) {
        this.consumptionDetails = consumptionDetails;
    }

    public static class ConsumptionDetailsBean {
        /**
         * time : 消费时间
         * amount : 消费金额
         * location : 消费地点 公司和分店以‘
         * ’分割，格式例子：河南张仲景大药房股份有限公司
         * 郑州东风路一店
         */

        private String time;
        private String amount;
        private String location;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
}
