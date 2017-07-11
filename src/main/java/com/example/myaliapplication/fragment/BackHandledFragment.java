package com.example.myaliapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;


public abstract class BackHandledFragment extends Fragment {

	public BackHandledInterface mBackHandledInterface;

	/**
	 * 所有继承BackHandledFragment的子类都将在这个方法中实现物理Back键按下后的逻辑;
	 * 实现物理Back键按下后的逻辑处理则返回值为true,否则为false;
	 * FragmentActivity捕捉到物理返回键点击事件后会首先询问Fragment是否消费该事件,
	 * 如果没有Fragment消息时FragmentActivity自己才会消费该事件;
	 */
	public abstract boolean onBackPressed();

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  
        if(!(getActivity() instanceof BackHandledInterface)){  
            throw new ClassCastException("Hosting Activity must implement BackHandledInterface");
        }else{  
            this.mBackHandledInterface = (BackHandledInterface)getActivity();  
        }  
    }
	
	@Override
	public void onResume() {
		super.onResume();
		// 告诉FragmentActivity，当前Fragment在栈顶
		mBackHandledInterface.setSelectedFragment(this);
	}

}