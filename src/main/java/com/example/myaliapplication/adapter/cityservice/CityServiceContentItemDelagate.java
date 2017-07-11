package com.example.myaliapplication.adapter.cityservice;

import android.view.View;

import com.example.myaliapplication.R;
import com.example.myaliapplication.bean.CityService;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

public class CityServiceContentItemDelagate implements ItemViewDelegate<CityService> {

    @Override
    public int getItemViewLayoutId() {
        return R.layout.layout_city_item;
    }

    @Override
    public boolean isForViewType(CityService item, int position) {
        return !item.isTitle;
    }

    @Override
    public void convert(ViewHolder holder, CityService cityService, int position) {
        if (!cityService.isVisible) {
            holder.getConvertView().findViewById(R.id.ly_item).setVisibility(View.INVISIBLE);
        } else {
            holder.setText(R.id.tv_name, cityService.name);
            holder.setImageResource(R.id.iv_pic, cityService.pic);
            holder.getConvertView().findViewById(R.id.ly_item).setVisibility(View.VISIBLE);
        }
    }
}
