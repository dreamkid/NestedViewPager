package com.hezd.nestedviewpager.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hezd.nestedviewpager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @create_time 2018/5/10
 * @Author zjb
 * @duscrubs:
 */
public class ViewPagerIndicator implements ViewPager.OnPageChangeListener {
    private Context context;
    private ViewPager viewPager;
    private LinearLayout dotLayout;
    private int size;
    private int img1 = R.drawable.viewpage_corner_radius_select, img2 = R.drawable.viewpage_corner_radius;
    private int imgSize = 6;
    private List<ImageView> dotViewLists = new ArrayList<>();
    private OnPageSelect onPageSelect;

    public ViewPagerIndicator(Context context, ViewPager viewPager, LinearLayout dotLayout, int size, int pose, OnPageSelect onPageSelect) {
        this.context = context;
        this.viewPager = viewPager;
        this.dotLayout = dotLayout;
        this.size = size;
        this.onPageSelect = onPageSelect;
        dotLayout.removeAllViews();
        dotViewLists.clear();
        for (int i = 0; i < size; i++) {
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            //为小圆点左右添加间距
            params.leftMargin = 5;
            params.rightMargin = 5;
            //手动给小圆点一个大小

            if (i == pose) {
//                params.height = imgSize;
//                params.width = imgSize+10;
                imageView.setBackgroundResource(img2);
            } else {
//                params.height = imgSize;
//                params.width = imgSize;
                imageView.setBackgroundResource(img1);

            }
            //为LinearLayout添加ImageView
            dotLayout.addView(imageView, params);
            dotViewLists.add(imageView);
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if(onPageSelect!=null) {
            onPageSelect.onPageScrolled(position,positionOffset,positionOffsetPixels);
        }
    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < size; i++) {
            //选中的页面改变小圆点为选中状态，反之为未选中
            if ((position % size) == i) {
                ((View) dotViewLists.get(i)).setBackgroundResource(img2);
            } else {
                ((View) dotViewLists.get(i)).setBackgroundResource(img1);
            }
        }
        if (onPageSelect != null) onPageSelect.onPageSelect(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if(onPageSelect!=null) {
            onPageSelect.onPageScrollStateChanged(state);
        }
    }
    public interface OnPageSelect{
        void onPageSelect(int pos);
        void onPageScrollStateChanged(int state);
        void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);
    }
}