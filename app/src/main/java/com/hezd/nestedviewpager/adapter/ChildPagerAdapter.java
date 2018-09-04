package com.hezd.nestedviewpager.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.hezd.nestedviewpager.fragment.ChildFragment;

import java.util.ArrayList;

/**
 * @author 顾修忠-guxiuzhong@youku.com/gfj19900401@163.com
 * @Title: MyPagerAdapter
 * @Package com.guxiuzhong.pagerslidingtabstrip.adapter
 * @Description:
 * @date 15/11/29
 * @time 下午12:53
 */
public class ChildPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> titles;

    public ChildPagerAdapter(FragmentManager fm, ArrayList<String> list) {
        super(fm);
        this.titles = list;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public Fragment getItem(int position) {
        Bundle b = new Bundle();
        b.putString("title", titles.get(position));
        return ChildFragment.getInstance(b);
    }
}
