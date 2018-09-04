package com.hezd.nestedviewpager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hezd.nestedviewpager.R;

/**
 * @auther hezd
 * created on 2018/9/4 11:21
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    private Context mContext;
    private OnBtnClickListener mListener;

    public ItemAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(mContext).inflate(R.layout.item_btn_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null)
                    mListener.onBtnClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 24;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public Button button;
        public ItemHolder(View itemView) {
            super(itemView);
            button = (Button) itemView.findViewById(R.id.btn_click);
        }
    }

    public void setOnBtnClickListener(OnBtnClickListener onBtnClickListener) {
        this.mListener = onBtnClickListener;
    }

    public interface OnBtnClickListener {
        void onBtnClick();
    }
}
