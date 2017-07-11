package com.example.myaliapplication.bean;

/**
 * 个人信息
 */
public class PersonInfo {

    /**
     * name : 刘鑫
     * personNum : 4****************2(身份证号码)
     * sex : 男
     * nation : 回族
     * birthday : 1989-05-27 (生日)
     * cardNum : A******5 (社保卡号码)
     * danweiName : 单位名称
     * danweiNum : 单位编号
     * canbaostatus : 参保状态
     * status : 社保卡状态
     * email : 邮箱
     * phone : 手机号
     * nickName : 昵称
     */

    private String name;
    private String personNum;
    private String sex;
    private String nation;
    private String birthday;
    private String cardNum;
    private String danweiName;
    private String danweiNum;
    private String canbaostatus;
    private String status;
    private String email;
    private String phone;
    private String nickName;

    /**
     * 获取用户姓名
     *
     * @return 用户姓名
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户身份证号码
     *
     * @return 身份证号码
     */
    public String getPersonNum() {
        return personNum;
    }

    public void setPersonNum(String personNum) {
        this.personNum = personNum;
    }

    /**
     * 获取用户性别
     *
     * @return 性别
     */
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取用户民族
     *
     * @return 民族
     */
    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 获取用户生日
     *
     * @return 生日
     */
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取社保卡号
     *
     * @return 社保卡号
     */
    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    /**
     * 获取单位名称
     *
     * @return 单位名称
     */
    public String getDanweiName() {
        return danweiName;
    }

    public void setDanweiName(String danweiName) {
        this.danweiName = danweiName;
    }

    /**
     * 获取单位编号
     *
     * @return 单位编号
     */
    public String getDanweiNum() {
        return danweiNum;
    }

    public void setDanweiNum(String danweiNum) {
        this.danweiNum = danweiNum;
    }

    /**
     * 获取参保状态
     *
     * @return 参保状态
     */
    public String getCanbaostatus() {
        return canbaostatus;
    }

    public void setCanbaostatus(String canbaostatus) {
        this.canbaostatus = canbaostatus;
    }

    /**
     * 获取社保卡状态
     *
     * @return 社保卡状态
     */
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取用户邮箱
     *
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取用户手机号
     *
     * @return 手机号
     */
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取用户昵称
     *
     * @return 昵称
     */
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
