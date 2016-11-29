package com.example.liuhao.bottombar;

/**
 * Created by liuhao on 16/11/28.
 */

public class TabEntity {
    private String text;
    private int normalIconId;
    private int selectIconId;
    private boolean isShowPoint;
    private int newsCount;

    public int getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(int newsCount) {
        this.newsCount = newsCount;
    }

    public boolean isShowPoint() {
        return isShowPoint;
    }

    public void setShowPoint(boolean showPoint) {
        isShowPoint = showPoint;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNormalIconId() {
        return normalIconId;
    }

    public void setNormalIconId(int normalIconId) {
        this.normalIconId = normalIconId;
    }

    public int getSelectIconId() {
        return selectIconId;
    }

    public void setSelectIconId(int selectIconId) {
        this.selectIconId = selectIconId;
    }
}
