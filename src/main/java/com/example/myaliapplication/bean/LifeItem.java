package com.example.myaliapplication.bean;

import com.example.myaliapplication.R;
import java.util.ArrayList;


public class LifeItem {
	public int pic;
	public String title;

	public LifeItem(int pic, String title) {
		this.pic = pic;
		this.title = title;
	}
	
	public static ArrayList<LifeItem> getDefault() {
		ArrayList<LifeItem> itemArray = new ArrayList<LifeItem>();
		itemArray.add(new LifeItem(R.drawable.zhuanzhang, "转账"));
		itemArray.add(new LifeItem(R.drawable.hongbao, "红包"));
		itemArray.add(new LifeItem(R.drawable.chongzhi, "充值中心"));
		itemArray.add(new LifeItem(R.drawable.chaoshi, "天猫超市"));

		itemArray.add(new LifeItem(R.drawable.xinyongka, "信用卡还款"));
		itemArray.add(new LifeItem(R.drawable.caifu, "蚂蚁财富"));
		itemArray.add(new LifeItem(R.drawable.taopiao, "淘票票"));
		itemArray.add(new LifeItem(R.drawable.didi, "滴滴出行"));

		itemArray.add(new LifeItem(R.drawable.jizhang, "记账本"));
		itemArray.add(new LifeItem(R.drawable.chengshi, "城市服务"));
		itemArray.add(new LifeItem(R.drawable.shenghuohao, "生活号"));
		itemArray.add(new LifeItem(R.drawable.gengduo, "更多"));
		return itemArray;
	}
}
