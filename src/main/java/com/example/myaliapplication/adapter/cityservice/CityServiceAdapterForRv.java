package com.example.myaliapplication.adapter.cityservice;

import android.content.Context;
import android.view.ViewGroup;

import com.example.myaliapplication.bean.CityService;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

public class CityServiceAdapterForRv extends MultiItemTypeAdapter<CityService>
{
    public CityServiceAdapterForRv(Context context, List<CityService> datas)
    {
        super(context, datas);

        addItemViewDelegate(new CityServiceTitleItemDelagate());
        addItemViewDelegate(new CityServiceContentItemDelagate());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
    }
}
