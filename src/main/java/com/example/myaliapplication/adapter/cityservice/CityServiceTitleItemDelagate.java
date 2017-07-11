package com.example.myaliapplication.adapter.cityservice;

import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.myaliapplication.R;
import com.example.myaliapplication.bean.CityService;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

public class CityServiceTitleItemDelagate implements ItemViewDelegate<CityService>
{

    @Override
    public int getItemViewLayoutId()
    {
        return R.layout.layout_city_item_title;
    }

    @Override
    public boolean isForViewType(CityService item, int position)
    {
        return item.isTitle;
    }

    @Override
    public void convert(ViewHolder holder, CityService cityService, int position)
    {
        holder.setText(R.id.title, cityService.title);
        StaggeredGridLayoutManager.LayoutParams layoutParams =
                (StaggeredGridLayoutManager.LayoutParams) holder.getConvertView().getLayoutParams();
        layoutParams.setFullSpan(true);
        holder.getConvertView().setLayoutParams(layoutParams);
    }
}
