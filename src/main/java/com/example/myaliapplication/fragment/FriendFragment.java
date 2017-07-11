package com.example.myaliapplication.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myaliapplication.R;
import com.example.myaliapplication.bean.Friend;
import com.jaeger.library.StatusBarUtil;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

public class FriendFragment extends BackHandledFragment {

    private final static String TAG = "HomeFragment";
    private RecyclerView rv_content;

    private View rootView;
    private CommonAdapter<Friend> mAdapter;

    public FriendFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_friend, container, false);
            StatusBarUtil.setColor(getActivity(), ContextCompat.getColor(getContext(), R.color.alipayColor));
            initAdapter();
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    private void initAdapter() {
        rv_content = (RecyclerView) rootView.findViewById(R.id.rv_content);
        rv_content.setLayoutManager(new LinearLayoutManager(getContext()));

        mAdapter = new CommonAdapter<Friend>(getContext(), R.layout.item_friend, Friend.getDefault()) {
            @Override
            protected void convert(ViewHolder holder, Friend friend, int position) {
                holder.setImageResource(R.id.img_friend, friend.pic);
                holder.setText(R.id.tv_title, friend.title);
                holder.setText(R.id.tv_content, friend.content);
                holder.setText(R.id.tv_time, friend.time);
            }
        };
        rv_content.setAdapter(mAdapter);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

}
