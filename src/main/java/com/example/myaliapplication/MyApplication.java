package com.example.myaliapplication;

import android.app.Application;
import android.content.Context;

import com.example.myaliapplication.bean.CardBalance;
import com.example.myaliapplication.bean.PersonInfo;
import com.example.myaliapplication.bean.RetirementInsurance;
import com.example.myaliapplication.bean.UnemploymentInsurance;
import com.example.myaliapplication.utils.FileUtil;
import com.example.myaliapplication.utils.GsonUtil;

/**
 * 全局application， 进行文件解析初始化数据
 */

public class MyApplication extends Application {
    private static Context mContext;
    private static PersonInfo personInfo;
    private static RetirementInsurance retirementInsurance;
    private static UnemploymentInsurance unemploymentInsurance;
    private static CardBalance cardBalance;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        personInfo = GsonUtil.fromJson(
                FileUtil.readFile("personInfo.jason", mContext),
                PersonInfo.class);
        retirementInsurance = GsonUtil.fromJson(
                FileUtil.readFile("retirementInsurance.jason", mContext),
                RetirementInsurance.class);
        unemploymentInsurance = GsonUtil.fromJson(
                FileUtil.readFile("unemploymentInsurance.jason", mContext),
                UnemploymentInsurance.class);
        cardBalance = GsonUtil.fromJson(
                FileUtil.readFile("cardBalance.jason", mContext),
                CardBalance.class
        );
    }

    public static Context getInstance() {
        return mContext;
    }

    public static PersonInfo getPersonInfo() {
        return personInfo;
    }

    public static RetirementInsurance getRetirementInsurance() {
        return retirementInsurance;
    }

    public static UnemploymentInsurance getUnemploymentInsurance() {
        return unemploymentInsurance;
    }

    public static CardBalance getCardBalance() {
        return cardBalance;
    }
}
