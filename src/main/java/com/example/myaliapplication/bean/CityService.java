package com.example.myaliapplication.bean;

import com.example.myaliapplication.R;

import java.util.ArrayList;

/**
 * Created by ha on 2017/7/8.
 */

public class CityService {

    public String name;
    public int pic;
    public boolean isVisible = true;// 该item是否显示

    public String title;
    public boolean isTitle = false;// 该item是否是Title


    /**
     * @param pic       图片id
     * @param name      item内容
     * @param isVisible 该item是否可见
     * @param title     title文字
     * @param isTitle   该item是否是title布局
     */
    public CityService(int pic, String name, boolean isVisible, String title, boolean isTitle) {
        this.name = name;
        this.pic = pic;
        this.isVisible = isVisible;
        this.title = title;
        this.isTitle = isTitle;
    }

    public static ArrayList<CityService> getDefault() {
        ArrayList<CityService> itemArray = new ArrayList<CityService>();

        // 车主
        itemArray.add(new CityService(R.drawable.c_jiazheng, "驾驶证业务缴费", true, null, false));//0
        itemArray.add(new CityService(R.drawable.c_fakuan, "交通违法缴罚", true, null, false));
        itemArray.add(new CityService(R.drawable.c_weifa, "机动车违法查询", true, null, false));
        itemArray.add(new CityService(R.drawable.c_jiazheng, "驾驶证查询", true, null, false));
        itemArray.add(new CityService(R.drawable.c_tixing, "车辆违法提醒", true, null, false));
        itemArray.add(new CityService(R.drawable.c_jidongche, "机动车业务缴费", true, null, false));
        itemArray.add(new CityService(R.drawable.c_chongdian, "汽车充电站", true, null, false));
        itemArray.add(new CityService(R.drawable.c_qita_blue, "其他服务", true, null, false));

        // 医疗
        itemArray.add(new CityService(0, null, true, "医疗", true));//8
        itemArray.add(new CityService(R.drawable.c_guahao, "挂号就诊", true, null, false));//9
        itemArray.add(new CityService(R.drawable.c_yisheng, "问医生", true, null, false));
        itemArray.add(new CityService(R.drawable.c_yuzhen, "智能预诊", true, null, false));
        itemArray.add(new CityService(R.drawable.c_tijian, "体检预约", true, null, false));
        itemArray.add(new CityService(R.drawable.c_more_yiiliao, "更多医疗服务", true, null, false));
        itemArray.add(new CityService(R.drawable.c_qita_blue, "null", false, null, false));

        // 政务
        itemArray.add(new CityService(0, null, true, "政务", true));//15
        itemArray.add(new CityService(R.drawable.c_gongjijin, "公积金服务", true, null, false));//16
        itemArray.add(new CityService(R.drawable.c_shebaoka, "郑州社保卡服务", true, null, false));
        itemArray.add(new CityService(R.drawable.c_shebao, "自然人社保费缴费", true, null, false));
        itemArray.add(new CityService(R.drawable.c_geshui, "个人所得税查询", true, null, false));
        itemArray.add(new CityService(R.drawable.c_xinshenger, "新生儿重名查询", true, null, false));
        itemArray.add(new CityService(R.drawable.c_churujing, "出入境缴费", true, null, false));
        itemArray.add(new CityService(R.drawable.c_fapiao, "发票抽奖", true, null, false));
        itemArray.add(new CityService(R.drawable.c_qita_blue, "其他服务", true, null, false));

        // 交通
        itemArray.add(new CityService(0, null, true, "交通", true));//24
        itemArray.add(new CityService(R.drawable.c_huoche, "火车票", true, null, false));//25
        itemArray.add(new CityService(R.drawable.c_chepiao, "汽车票", true, null, false));
        itemArray.add(new CityService(R.drawable.c_gongjiao, "公交查询", true, null, false));
        itemArray.add(new CityService(R.drawable.c_jipiao, "机票", true, null, false));
        itemArray.add(new CityService(R.drawable.c_ditie, "地铁购票", true, null, false));
        itemArray.add(new CityService(R.drawable.c_lukuang, "实时路况", true, null, false));

        // 综合
        itemArray.add(new CityService(0, null, true, "综合", true));//31
        itemArray.add(new CityService(R.drawable.c_taifeng, "台风查询", true, null, false));//32
        itemArray.add(new CityService(R.drawable.c_shenghuo, "生活缴费", true, null, false));
        itemArray.add(new CityService(R.drawable.c_paimai, "司法拍卖", true, null, false));
        itemArray.add(new CityService(R.drawable.c_jubao, "网络不良信息举报", true, null, false));
        itemArray.add(new CityService(R.drawable.c_menpiao, "景点门票", true, null, false));
        itemArray.add(new CityService(R.drawable.c_kongqi, "空气水质查询", true, null, false));
        itemArray.add(new CityService(R.drawable.c_falv, "法律服务", true, null, false));
        itemArray.add(new CityService(R.drawable.c_qita_red, "其他服务", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        itemArray.add(new CityService(R.color.transparent, "", true, null, false));
        return itemArray;
    }
}
