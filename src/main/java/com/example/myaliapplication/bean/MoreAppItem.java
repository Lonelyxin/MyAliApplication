package com.example.myaliapplication.bean;

import com.example.myaliapplication.R;

import java.util.ArrayList;

/**
 * Created by ha on 2017/6/24.
 */

public class MoreAppItem {
    public String name;
    public int pic;
    public boolean isVisible = true;// 该item是否显示

    public String title;
    public boolean isTitle = false;// 该item是否是Title
    public boolean isDivider = false;// 该item是否是分割线

    /**
     *
     * @param pic 图片id
     * @param name item内容
     * @param isVisible 该item是否可见
     * @param title title文字
     * @param isTitle 该item是否是title布局
     * @param isDivider 该item是否是分割线布局
     */
    public MoreAppItem( int pic, String name,boolean isVisible, String title, boolean isTitle, boolean isDivider){
        this.name = name;
        this.pic = pic;
        this.isVisible = isVisible;
        this.title = title;
        this.isTitle = isTitle;
        this.isDivider = isDivider;
    }

    public static ArrayList<MoreAppItem> getDefault() {
        ArrayList<MoreAppItem> itemArray = new ArrayList<MoreAppItem>();

        //最近使用
        itemArray.add(new MoreAppItem(0, null, true, "最近使用", true, false));
        itemArray.add(new MoreAppItem(R.drawable.tianmao, "天猫", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.renlian, "人脸识别", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.huoche, "火车票机票", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.senlin, "蚂蚁森林", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.jianglijin, "奖励金", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.yuebao, "余额宝", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.shouqian2, "收钱", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.gengduo, "更多", true, null, false, false));
        itemArray.add(new MoreAppItem(0, null, true, null, false, true));//分割线

        //为你推荐
        itemArray.add(new MoreAppItem(0, null, true, "为你推荐", true, false));
        itemArray.add(new MoreAppItem(R.drawable.jiaofei, "生活缴费", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.yundong, "运动", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.kuaidi, "我的快递", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.kefu, "我的客服", true, null, false, false));
        itemArray.add(new MoreAppItem(0, null, true, null, false, true));//分割线

        //便民生活
        itemArray.add(new MoreAppItem(0, null, true, "便民生活", true, false));
        itemArray.add(new MoreAppItem(R.drawable.chongzhi, "充值中心", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.xinyongka, "信用卡还款", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.jiaofei, "生活缴费", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.chengshi, "城市服务", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.shenghuohao, "生活号", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.daowei, "到位", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.kefu, "我的客服", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.kuaidi, "我的快递", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.jiankang, "医疗健康", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.jizhang, "记账本", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.jiayou, "加油服务", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.fapiao, "发票管家", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.baoka, "蚂蚁宝卡", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.liuliang, "境外流量包", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.chezhu, "车主服务", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.youliao, "天天有料", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.weike, "蚂蚁微客", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.danche, "共享单车", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.appicon, "null", false, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.appicon, "null", false, null, false, false));
        itemArray.add(new MoreAppItem(0, null, true, null, false, true));//分割线

        //资金往来
        itemArray.add(new MoreAppItem(0, null, true, "资金往来", true, false));
        itemArray.add(new MoreAppItem(R.drawable.zhuanzhang, "转账", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.hongbao, "红包", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.qinqing, "亲情圈", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.shouqian2, "收钱", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.aa, "AA收款", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.qinmi, "亲密付", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.shangyin, "上银汇款", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.zhuanrang, "话费卡转让", true, null, false, false));
        itemArray.add(new MoreAppItem(0, null, true, null, false, true));//分割线

        //购物娱乐
        itemArray.add(new MoreAppItem(0, null, true, "购物娱乐", true, false));
        itemArray.add(new MoreAppItem(R.drawable.youxi, "游戏中心", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.dianshi, "电视红包", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.chujing, "出境必备", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.caipiao, "彩票", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.renlian, "人脸识别", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.jianglijin, "奖励金", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.huiwan, "口碑惠玩", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.appicon, "null", false, null, false, false));
        itemArray.add(new MoreAppItem(0, null, true, null, false, true));//分割线

        //财富管理
        itemArray.add(new MoreAppItem(0, null, true, "财富管理", true, false));
        itemArray.add(new MoreAppItem(R.drawable.yuebao, "余额宝", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.huabei, "花呗", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.zhima, "芝麻信用", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.caifu, "蚂蚁财富", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.jiebei, "蚂蚁借呗", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.gupiao, "股票", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.baoxian, "保险服务", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.huilv, "汇率换算", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.xiaogongju, "理财小工具", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.appicon, "null",false, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.appicon, "null",false, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.appicon, "null",false, null, false, false));
        itemArray.add(new MoreAppItem(0, null, true, null, false, true));//分割线

        //教育公益
        itemArray.add(new MoreAppItem(0, null, true, "教育公益", true, false));
        itemArray.add(new MoreAppItem(R.drawable.xiaoyuan, "校园工作", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.jiaoyu, "教育缴费", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.aixin, "爱心捐赠", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.senlin, "蚂蚁森林", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.zhongxiaoxue, "中小学", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.yundong, "运动", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.appicon, "null", false, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.appicon, "null", false, null, false, false));
        itemArray.add(new MoreAppItem(0, null, true, null, false, true));//分割线

        //第三方提供服务
        itemArray.add(new MoreAppItem(0, null, true, "第三方提供服务", true, false));
        itemArray.add(new MoreAppItem(R.drawable.taopiao, "淘票票", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.didi, "滴滴出行", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.waimai, "外卖", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.tianmao, "天猫", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.taobao, "淘宝", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.chaoshi, "天猫超市", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.huoche, "火车票机票", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.feizhu, "飞猪旅行", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.jiudian, "未来酒店", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.aibiying, "爱彼迎", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.tiyu, "阿里体育", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.huoyuan, "1688好货源", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.jifen, "易积分", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.fenqi, "来分期", true, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.appicon, "null", false, null, false, false));
        itemArray.add(new MoreAppItem(R.drawable.appicon, "null", false, null, false, false));
        itemArray.add(new MoreAppItem(0, null, true, null, false, true));//分割线
        return itemArray;
    }
}
