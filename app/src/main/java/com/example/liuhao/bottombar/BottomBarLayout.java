package com.example.liuhao.bottombar;

import android.content.Context;
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
            icon.setImageResource(itemTab.getIconId());
            mLinearLayout.addView(itemView);
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
                break;
            case 1:
                mOnItemClickListener.onItemClick(1);
                break;
            case 2:
                mOnItemClickListener.onItemClick(2);
                break;
            case 3:
                mOnItemClickListener.onItemClick(3);
                break;
        }
    }
}
