package com.hezd.nestedviewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hezd.nestedviewpager.R;
import com.hezd.nestedviewpager.adapter.ItemAdapter;


/**
 * Created by guxiuzhong on 2015/7/6.
 */
public class ChildFragment extends Fragment {

    public static Fragment getInstance(Bundle bundle) {
        ChildFragment fragment = new ChildFragment();
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
        return inflater.inflate(R.layout.fragmnet_child, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        TextView tv = (TextView) view.findViewById(R.id.tv_id);
        tv.setText(getArguments().getString("title"));
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rlv_device);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(layoutManager);
        ItemAdapter itemAdapter = new ItemAdapter(getContext());
        recyclerView.setAdapter(itemAdapter);

        itemAdapter.setOnBtnClickListener(new ItemAdapter.OnBtnClickListener() {
            @Override
            public void onBtnClick() {
                Toast.makeText(getContext(),"点点点",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
