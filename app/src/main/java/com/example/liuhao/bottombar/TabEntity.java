package com.example.liuhao.bottombar;

/**
 * Created by liuhao on 16/11/28.
 */

public class TabEntity {
    private String text;
    private int normalIconId;
    private int selectIconId;

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
