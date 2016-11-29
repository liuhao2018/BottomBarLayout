package com.example.liuhao.bottombar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomBarLayout bottomBarLayout;
    private List<TabEntity> tabEntityList;
    private String[] tabText = {"首页","玩啥","买票","我的"};

    private int[] normalIcon = {R.mipmap.home,R.mipmap.play,R.mipmap.buy,R.mipmap.mine};
    private int[] selectIcon = {R.mipmap.home1,R.mipmap.play1,R.mipmap.buy1,R.mipmap.mine1};

    private int normalTextColor = Color.parseColor("#999999");
    private int selectTextColor = Color.parseColor("#fa6e51");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBarLayout = (BottomBarLayout) findViewById(R.id.bottom_nav);
        tabEntityList = new ArrayList<>();
        for (int i=0;i<tabText.length;i++){
            TabEntity item = new TabEntity();
            item.setText(tabText[i]);
            item.setNormalIconId(normalIcon[i]);
            item.setSelectIconId(selectIcon[i]);
            if(i==2 || i==3){
                item.setShowPoint(true);
            }else{
                item.setShowPoint(false);
            }
            if(i==0 || i==1){
                item.setNewsCount(i+1);
            }else {
                item.setNewsCount(0);
            }
            tabEntityList.add(item);
        }

        bottomBarLayout.setNormalTextColor(normalTextColor);
        bottomBarLayout.setSelectTextColor(selectTextColor);
        bottomBarLayout.setTabList(tabEntityList);

        bottomBarLayout.setOnItemClickListener(new BottomBarLayout.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
