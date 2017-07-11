package com.example.myaliapplication.bean;

import java.util.List;

/**
 * 养老保险信息
 */

public class RetirementInsurance {

    /**
     * canbaoTime : 参保时间
     * canbaoStatus : 参保状态!
     * payableMonths : 应缴月数
     * actualMonths : 实缴月数
     * personPayable : 个人应缴
     * coPayable : 单位应缴
     * totalPayable : 应缴总额
     * personArrears : 个人欠缴
     * coArrears : 单位欠缴
     * personPaid : 个人实缴
     * coPaid : 单位实缴
     * totalPaid : 实缴总额
     * details :缴费详情
     * [
     * {"paidTime":"缴纳时间","personPaid":"个人缴费","coPaid":"单位缴费","totalPaid":"合计缴费","baseNum":"缴费基数","paymentType":"缴费类型","isPaid":"是否缴费"},
     * {"paidTime":"缴纳时间","personPaid":"个人缴费","coPaid":"单位缴费","totalPaid":"合计缴费","baseNum":"缴费基数","paymentType":"缴费类型","isPaid":"是否缴费"},
     * {"paidTime":"缴纳时间","personPaid":"个人缴费","coPaid":"单位缴费","totalPaid":"合计缴费","baseNum":"缴费基数","paymentType":"缴费类型","isPaid":"是否缴费"},
     * {"paidTime":"缴纳时间","personPaid":"个人缴费","coPaid":"单位缴费","totalPaid":"合计缴费","baseNum":"缴费基数","paymentType":"缴费类型","isPaid":"是否缴费"},
     * {"paidTime":"缴纳时间","personPaid":"个人缴费","coPaid":"单位缴费","totalPaid":"合计缴费","baseNum":"缴费基数","paymentType":"缴费类型","isPaid":"是否缴费"}
     * ]
     */

    private String canbaoTime;
    private String canbaoStatus;
    private String payableMonths;
    private String actualMonths;
    private String personPayable;
    private String coPayable;
    private String totalPayable;
    private String personArrears;
    private String coArrears;
    private String personPaid;
    private String coPaid;
    private String totalPaid;
    private List<DetailsBean> details;

    public String getCanbaoTime() {
        return canbaoTime;
    }

    public void setCanbaoTime(String canbaoTime) {
        this.canbaoTime = canbaoTime;
    }

    public String getCanbaoStatus() {
        return canbaoStatus;
    }

    public void setCanbaoStatus(String canbaoStatus) {
        this.canbaoStatus = canbaoStatus;
    }

    public String getPayableMonths() {
        return payableMonths;
    }

    public void setPayableMonths(String payableMonths) {
        this.payableMonths = payableMonths;
    }

    public String getActualMonths() {
        return actualMonths;
    }

    public void setActualMonths(String actualMonths) {
        this.actualMonths = actualMonths;
    }

    public String getPersonPayable() {
        return personPayable;
    }

    public void setPersonPayable(String personPayable) {
        this.personPayable = personPayable;
    }

    public String getCoPayable() {
        return coPayable;
    }

    public void setCoPayable(String coPayable) {
        this.coPayable = coPayable;
    }

    public String getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable(String totalPayable) {
        this.totalPayable = totalPayable;
    }

    public String getPersonArrears() {
        return personArrears;
    }

    public void setPersonArrears(String personArrears) {
        this.personArrears = personArrears;
    }

    public String getCoArrears() {
        return coArrears;
    }

    public void setCoArrears(String coArrears) {
        this.coArrears = coArrears;
    }

    public String getPersonPaid() {
        return personPaid;
    }

    public void setPersonPaid(String personPaid) {
        this.personPaid = personPaid;
    }

    public String getCoPaid() {
        return coPaid;
    }

    public void setCoPaid(String coPaid) {
        this.coPaid = coPaid;
    }

    public String getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(String totalPaid) {
        this.totalPaid = totalPaid;
    }

    public List<DetailsBean> getDetails() {
        return details;
    }

    public void setDetails(List<DetailsBean> details) {
        this.details = details;
    }

    public static class DetailsBean {
        /**
         * paidTime : 缴纳时间
         * personPaid : 个人缴费
         * coPaid : 单位缴费
         * totalPaid : 合计缴费
         * baseNum : 缴费基数
         * paymentType : 缴费类型
         * isPaid : 是否缴费
         */

        private String paidTime;
        private String personPaid;
        private String coPaid;
        private String totalPaid;
        private String baseNum;
        private String paymentType;
        private String isPaid;

        public String getPaidTime() {
            return paidTime;
        }

        public void setPaidTime(String paidTime) {
            this.paidTime = paidTime;
        }

        public String getPersonPaid() {
            return personPaid;
        }

        public void setPersonPaid(String personPaid) {
            this.personPaid = personPaid;
        }

        public String getCoPaid() {
            return coPaid;
        }

        public void setCoPaid(String coPaid) {
            this.coPaid = coPaid;
        }

        public String getTotalPaid() {
            return totalPaid;
        }

        public void setTotalPaid(String totalPaid) {
            this.totalPaid = totalPaid;
        }

        public String getBaseNum() {
            return baseNum;
        }

        public void setBaseNum(String baseNum) {
            this.baseNum = baseNum;
        }

        public String getPaymentType() {
            return paymentType;
        }

        public void setPaymentType(String paymentType) {
            this.paymentType = paymentType;
        }

        public String getIsPaid() {
            return isPaid;
        }

        public void setIsPaid(String isPaid) {
            this.isPaid = isPaid;
        }
    }
}
