package com.example.myaliapplication.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myaliapplication.R;
import com.jaeger.library.StatusBarUtil;

public class KouBeiFragment extends BackHandledFragment {

    private final static String TAG = "HomeFragment";
    private View rootView;

    public KouBeiFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_koubei, container, false);
            StatusBarUtil.setColor(getActivity(), ContextCompat.getColor(getContext(), R.color.alipayColor));
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

}
