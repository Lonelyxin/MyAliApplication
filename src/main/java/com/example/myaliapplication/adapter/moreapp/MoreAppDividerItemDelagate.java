package com.example.myaliapplication.adapter.moreapp;

import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.myaliapplication.R;
import com.example.myaliapplication.bean.MoreAppItem;
import com.zhy.adapter.recyclerview.base.ItemViewDelegate;
import com.zhy.adapter.recyclerview.base.ViewHolder;

/**
 * Created by zhy on 16/6/22.
 */
public class MoreAppDividerItemDelagate implements ItemViewDelegate<MoreAppItem>
{

    @Override
    public int getItemViewLayoutId()
    {
        return R.layout.layout_divider;
    }

    @Override
    public boolean isForViewType(MoreAppItem item, int position)
    {
        return item.isDivider;
    }

    @Override
    public void convert(ViewHolder holder, MoreAppItem moreAppItem, int position)
    {
        StaggeredGridLayoutManager.LayoutParams layoutParams =
                (StaggeredGridLayoutManager.LayoutParams) holder.getConvertView().getLayoutParams();
        layoutParams.setFullSpan(true);
        holder.getConvertView().setLayoutParams(layoutParams);
    }
}
