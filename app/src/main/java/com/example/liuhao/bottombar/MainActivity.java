package com.example.liuhao.bottombar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomBarLayout bottomBarLayout;
    private List<TabEntity> tabEntityList;
    private String[] tabText = {"tab0","tab1","tab2","tab3"};

    private int[] tabIcon = {R.mipmap.home,R.mipmap.play,R.mipmap.buy,R.mipmap.mine};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBarLayout = (BottomBarLayout) findViewById(R.id.bottom_nav);
        tabEntityList = new ArrayList<>();
        for (int i=0;i<tabText.length;i++){
            TabEntity item = new TabEntity();
            item.setText(tabText[i]);
            item.setIconId(tabIcon[i]);
            tabEntityList.add(item);
        }
        bottomBarLayout.setTabList(tabEntityList);

        bottomBarLayout.setOnItemClickListener(new BottomBarLayout.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
