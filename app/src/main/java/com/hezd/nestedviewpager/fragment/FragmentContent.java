package com.hezd.nestedviewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hezd.nestedviewpager.R;
import com.hezd.nestedviewpager.adapter.ChildPagerAdapter;
import com.hezd.nestedviewpager.views.ViewPagerIndicator;

import java.util.ArrayList;


/**
 * Created by guxiuzhong on 2015/7/6.
 */
public class FragmentContent extends Fragment implements ViewPagerIndicator.OnPageSelect {

    public static final ArrayList<String> list = new ArrayList<String>(){
        {
            add("页面1");
            add("页面2");
            add("页面3");
            add("页面4");
        }
    };
    public static Fragment getInstance(Bundle bundle) {
        FragmentContent fragment = new FragmentContent();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmnet_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
//        TextView tv = (TextView) view.findViewById(R.id.tv_id);
//        tv.setText(getArguments().getString("title"));
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        LinearLayout ll_circle = (LinearLayout) view.findViewById(R.id.ll_circle);
        ChildPagerAdapter childPagerAdapter = new ChildPagerAdapter(getChildFragmentManager(),list);
        viewPager.setAdapter(childPagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPagerIndicator(getContext(),viewPager,ll_circle,list.size(),0,this));
    }

    @Override
    public void onPageSelect(int pos) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
}
