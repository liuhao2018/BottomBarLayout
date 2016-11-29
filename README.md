# BottomBarLayout

![](https://github.com/liuhaoer/BottomBarLayout/blob/master/img.png)

### 使用：
XML:

```
	<com.example.liuhao.bottombar.BottomBarLayout
        android:id="@+id/bottom_nav"
        android:layout_width="match_parent"
        android:layout_height="48dp"
        android:background="#FFFFFF"
        android:layout_alignParentBottom="true"/>
```
Activity:

init:

```
private BottomBarLayout bottomBarLayout;
private List<TabEntity> tabEntityList;
private String[] tabText = {"tab0","tab1","tab2","tab3"};

private int[] normalIcon = {R.mipmap.home,R.mipmap.play,R.mipmap.buy,R.mipmap.mine};
private int[] selectIcon = {R.mipmap.home1,R.mipmap.play1,R.mipmap.buy1,R.mipmap.mine1};
private int normalTextColor = Color.parseColor("#999999");

private int selectTextColor = Color.parseColor("#fa6e51");
bottomBarLayout = (BottomBarLayout) findViewById(R.id.bottom_nav);
tabEntityList = new ArrayList<>();
	for (int i=0;i<tabText.length;i++){
         TabEntity item = new TabEntity();
         item.setText(tabText[i]);
         item.setNormalIconId(normalIcon[i]);
         item.setSelectIconId(selectIcon[i]);
         tabEntityList.add(item);
   }
```

设置默认颜色和选中颜色：

```
bottomBarLayout.setNormalTextColor(normalTextColor); 
bottomBarLayout.setSelectTextColor(selectTextColor);
```

设置tab数据：

```
bottomBarLayout.setTabList(tabEntityList);
```

点击监听：

```
 bottomBarLayout.setOnItemClickListener(new BottomBarLayout.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }
  });
```

