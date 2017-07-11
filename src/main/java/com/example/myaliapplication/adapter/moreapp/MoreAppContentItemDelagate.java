package com.example.myaliapplication.adapter.moreapp;

import android.view.View;

import com.example.myaliapplication.R;
import com.example.myaliapplication.bean.MoreAppItem;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by zhy on 16/6/22.
 */
public class MoreAppContentItemDelagate implements ItemViewDelegate<MoreAppItem>
{

    @Override
    public int getItemViewLayoutId()
    {
        return R.layout.item_life;
    }

    @Override
    public boolean isForViewType(MoreAppItem item, int position)
    {
        return !item.isTitle && !item.isDivider;
    }

    @Override
    public void convert(ViewHolder holder, MoreAppItem moreAppItem, int position)
    {
        if(!moreAppItem.isVisible){
            holder.getConvertView().findViewById(R.id.ly_item).setVisibility(View.INVISIBLE);
        }else{
            holder.setText(R.id.tv_title, moreAppItem.name);
            holder.setImageResource(R.id.iv_pic, moreAppItem.pic);
            holder.getConvertView().findViewById(R.id.ly_item).setVisibility(View.VISIBLE);
        }
    }
}
