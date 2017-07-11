package com.example.myaliapplication.bean;

import com.example.myaliapplication.R;

import java.util.ArrayList;

/**
 * Created by ha on 2017/6/24.
 */

public class MineItem {
    public int pic;
    public String name;
    public String info;
    public int infoColor;
    public boolean hasMargin = false;


    public MineItem(int pic, String name, String info,int infoColor, boolean hasMargin){
        this.pic = pic;
        this.name = name;
        this.info = info;
        this.infoColor = infoColor;
        this.hasMargin = hasMargin;
    }

    public static ArrayList<MineItem> getDefault() {
        ArrayList<MineItem> itemArray = new ArrayList<MineItem>();

        itemArray.add(new MineItem(R.drawable.my_huiyuan, "蚂蚁会员", "3,149积分", 0, true));

        itemArray.add(new MineItem(R.drawable.my_zhangdan, "账单", null, 0, false));
        itemArray.add(new MineItem(R.drawable.my_zichan, "总资产", "账户安全保护中", R.color.green_64, false));
        itemArray.add(new MineItem(R.drawable.my_yue, "余额", "0.04元", 0, false));
        itemArray.add(new MineItem(R.drawable.my_yuebao, "余额宝", null, 0, false));
        itemArray.add(new MineItem(R.drawable.my_card, "银行卡", null, 0, true));

        itemArray.add(new MineItem(R.drawable.my_caifu, "蚂蚁财富", null, 0, false));
        itemArray.add(new MineItem(R.drawable.my_zhima, "芝麻信用", null, 0, false));
        itemArray.add(new MineItem(R.drawable.my_baoxian, "保险服务", null, 0, false));
        itemArray.add(new MineItem(R.drawable.my_huabei, "花呗", null, 0, false));
        itemArray.add(new MineItem(R.drawable.my_jiebei, "蚂蚁借呗", null, 0, false));
        itemArray.add(new MineItem(R.drawable.my_wangshang, "网上银行", null, 0, true));

        itemArray.add(new MineItem(R.drawable.my_aixin, "爱心捐赠", null, 0, false));
        itemArray.add(new MineItem(R.drawable.my_yule, "娱乐宝", null, 0, true));
        return itemArray;
    }

}
