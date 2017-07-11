package com.example.myaliapplication.adapter.moreapp;

import android.content.Context;
import android.view.ViewGroup;

import com.example.myaliapplication.bean.MoreAppItem;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by zhy on 15/9/4.
 */
public class MoreAppAdapterForRv extends MultiItemTypeAdapter<MoreAppItem>
{
    public MoreAppAdapterForRv(Context context, List<MoreAppItem> datas)
    {
        super(context, datas);

        addItemViewDelegate(new MoreAppTitleItemDelagate());
        addItemViewDelegate(new MoreAppContentItemDelagate());
        addItemViewDelegate(new MoreAppDividerItemDelagate());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
    }
}
