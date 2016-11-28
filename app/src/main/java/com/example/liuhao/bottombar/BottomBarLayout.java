package com.example.liuhao.bottombar;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhao on 16/11/28.
 */

public class BottomBarLayout extends LinearLayout implements View.OnClickListener{

    private OnItemClickListener mOnItemClickListener;

    interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }


    private int normalTextColor;
    private int selectTextColor;

    private LinearLayout mLinearLayout;
    private List<TabEntity> tabList = new ArrayList<>();

    public BottomBarLayout(Context context) {
        super(context);
        init(context);
    }

    public BottomBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context) {
        mLinearLayout = (LinearLayout) View.inflate(context,R.layout.container_layout,null);
        addView(mLinearLayout);
    }

    public void setNormalTextColor(int color){
        this.normalTextColor = color;
    }

    public void setSelectTextColor(int color){
        this.selectTextColor = color;
    }

    public void setTabList(List<TabEntity> tabs){
        if(tabs == null || tabs.size() == 0){
            return;
        }
        this.tabList = tabs;
        for (int i=0;i<tabs.size();i++) {
            View itemView = View.inflate(getContext(), R.layout.item_tab_layout, null);
            itemView.setId(i);
            itemView.setOnClickListener(this);
            TextView text = (TextView) itemView.findViewById(R.id.tv_title);
            ImageView icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            TabEntity itemTab = tabList.get(i);
            text.setText(itemTab.getText());
            icon.setImageResource(itemTab.getNormalIconId());
            mLinearLayout.addView(itemView);
            if(i==0){
                showTab(0,itemView);
            }
        }
    }



    @Override
    public void onClick(View view) {
        if(mOnItemClickListener == null){
            return;
        }
        switch(view.getId()){
            case 0:
                mOnItemClickListener.onItemClick(0);
                showTab(0,view);
                break;
            case 1:
                mOnItemClickListener.onItemClick(1);
                showTab(1,view);
                break;
            case 2:
                mOnItemClickListener.onItemClick(2);
                showTab(2,view);
                break;
            case 3:
                mOnItemClickListener.onItemClick(3);
                showTab(3,view);
                break;
        }
    }

    public void showTab(int position,View view){
        clearStatus();
        TextView text = (TextView) view.findViewById(R.id.tv_title);
        text.setTextColor(selectTextColor);
        ImageView icon = (ImageView) view.findViewById(R.id.iv_icon);
        icon.setImageResource(tabList.get(position).getSelectIconId());

    }

    private void clearStatus() {
        for (int i=0;i<mLinearLayout.getChildCount();i++){
            View itemView = mLinearLayout.getChildAt(i);
            ImageView icon = (ImageView) itemView.findViewById(R.id.iv_icon);
            TextView text = (TextView) itemView.findViewById(R.id.tv_title);
            text.setTextColor(normalTextColor);
            icon.setImageResource(tabList.get(i).getNormalIconId());
        }
    }
}
