package com.example.vmmet.mypiedashboard.bean;

import java.util.List;

/**
 * Created by Vmmet on 2016/11/8.
 */
public class DashboradBean {
    private int maxValue; //刻度盘最大值
    private int minValue; //刻度盘最小值
    private int bigSliceCount;  //刻度盘大刻度区间数
    private int smallSliceCount;  //刻度盘大刻度中小刻度区间数
    private int StartAngle;     //开始角度
    private int allAngle;       //需要画的总角度
    private List<HighlightCR> highlightCRList; //色带的集合
    private boolean isHalf;     //是否是半圆
    private int scaleColor;     //刻度值的颜色，默认0时，颜色随色带变化

    public int getScaleTextColor() {
        return scaleTextColor;
    }

    public void setScaleTextColor(int scaleTextColor) {
        this.scaleTextColor = scaleTextColor;
    }

    private int scaleTextColor;     //刻度值的读数的颜色，默认0时，颜色随色带变化
    private int centerPointColor;//中心原点的颜色
    private int pointerColor;    //指针的颜色

    public int getCenterPointColor() {
        return centerPointColor;
    }

    public void setCenterPointColor(int centerPointColor) {
        this.centerPointColor = centerPointColor;
    }

    public int getPointerColor() {
        return pointerColor;
    }

    public void setPointerColor(int pointerColor) {
        this.pointerColor = pointerColor;
    }

    public int getScaleColor() {
        return scaleColor;

    }

    public void setScaleColor(int scaleColor) {
        this.scaleColor = scaleColor;
    }

    public boolean isHalf() {
        return isHalf;
    }

    public void setIsHalf(boolean isHalf) {
        this.isHalf = isHalf;
    }

    public DashboradBean(){}
    public int getMaxValue() {
        return maxValue;
    }

    public int getStartAngle() {
        return StartAngle;
    }
    public int getSmallSliceCount() {
        return smallSliceCount;
    }

    public void setSmallSliceCount(int smallSliceCount) {
        this.smallSliceCount = smallSliceCount;
    }
    public void setStartAngle(int startAngle) {
        StartAngle = startAngle;
    }

    public int getAllAngle() {
        return allAngle;
    }

    public void setAllAngle(int allAngle) {
        this.allAngle = allAngle;
    }

    public DashboradBean(int StartAngle, int allAngle, int maxValue, int minValue, int bigSliceCount, List<HighlightCR> highlightCRList) {
        this.StartAngle=StartAngle;
        this.allAngle=allAngle;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.bigSliceCount = bigSliceCount;
        this.highlightCRList = highlightCRList;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }


    public int getBigSliceCount() {
        return bigSliceCount;
    }

    public void setBigSliceCount(int bigSliceCount) {
        this.bigSliceCount = bigSliceCount;
    }

    public List<HighlightCR> getHighlightCRList() {
        return highlightCRList;
    }

    public void setHighlightCRList(List<HighlightCR> highlightCRList) {
        this.highlightCRList = highlightCRList;
    }
}
