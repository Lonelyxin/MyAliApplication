package com.example.myaliapplication.fragment;

import com.example.myaliapplication.fragment.BackHandledFragment;

/**
 * 所有继承BackHandledFragment的子类Fragment, 它的容器activity, 需要实现接口BackHandledInterface
 * 而该BackHandledFragment需实例化接口BackHandledInterface, 重写setSelectedFragment方法
 * 
 * @author liuxin
 */
public interface BackHandledInterface {
	/**
	 * 所有实现接口BackHandledInterface的fragmentActivity
	 * 在该方法下获悉当前栈顶中的BackHandledFragment是哪个;
	 * 所有继承BackHandledFragment的fragment须实例化接口BackHandledInterface
	 * 调用该方法通知容器fragmentActivity,当前fragment已在栈顶
	 * 
	 * @param selectedFragment
	 */
	public abstract void setSelectedFragment(
            BackHandledFragment selectedFragment);
}
