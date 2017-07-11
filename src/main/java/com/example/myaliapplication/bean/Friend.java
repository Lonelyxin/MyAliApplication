package com.example.myaliapplication.bean;

import com.example.myaliapplication.R;

import java.util.ArrayList;

/**
 * Created by ha on 2017/7/1.
 */
public class Friend {
    public int pic;
    public String title;
    public String content;
    public String time;

    public Friend(int pic, String title, String content, String time) {
        this.pic = pic;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public static ArrayList<Friend> getDefault() {
        ArrayList<Friend> itemArray = new ArrayList<Friend>();
        itemArray.add(new Friend(R.drawable.f_shenghuohao, "生活号(原服务窗)", "飞猪旅行:[福利]350元机票抵用券已经到账，请注意查收", "09:27"));
        itemArray.add(new Friend(R.drawable.f_shenghuoquan, "生活圈", "每日一刻为你推荐了新动态", "07:27"));
        itemArray.add(new Friend(R.drawable.f_dongtai, "朋友动态", "自说自话发布了新动态", "06:40"));
        itemArray.add(new Friend(R.drawable.f_yinhang, "网商银行", "90后大学生养猪专业户", "昨天"));
        itemArray.add(new Friend(R.drawable.f_zhifu, "支付助手", "付款成功", "昨天"));
        itemArray.add(new Friend(R.drawable.f_xiaoxi, "消息中心", "", "昨天"));
        itemArray.add(new Friend(R.drawable.f_zhisheng, "吱声团队", "简单点，聊天的套路简单点", "星期五"));
        itemArray.add(new Friend(R.drawable.f_zhima, "芝麻信用", "就在明天了！", "星期四"));
        return itemArray;
    }
}
