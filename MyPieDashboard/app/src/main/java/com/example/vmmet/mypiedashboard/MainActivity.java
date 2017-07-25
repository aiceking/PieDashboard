package com.example.vmmet.mypiedashboard;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.vmmet.mypiedashboard.bean.DashboradBean;
import com.example.vmmet.mypiedashboard.bean.HighlightCR;
import com.example.vmmet.mypiedashboard.view.NewDashboardView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private NewDashboardView view1,view2,view3,view4,view5,view6,view7,view8,view9,view10,
        view11,view12,view13,view14,view15,view16,view17,view18,view19,view20,view21,view22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        /**大刻度份数和小刻度份数(半圆)*/
        setView_1_2();
        /**指针和原点颜色(半圆)*/
        setView_3_4();
        /**外弧的色条(半圆)*/
        setView_5_6();
        /**刻度和刻度值的颜色(半圆)*/
        setView_7_8();
        /**原点上方的Text字体大小和颜色(半圆)*/
        setView_9_10();
        //////////////////////////////////////
        /**大刻度份数和小刻度份数(圆)*/
        setView_11_12();
        /**指针和原点颜色(圆)*/
        setView_13_14();
        /**外弧的色条(圆)*/
        setView_15_16();
        /**刻度和刻度值的颜色(圆)*/
        setView_17_18();
        /**原点上方的Text字体大小和颜色(圆)*/
        setView_19_20();
        /**原点下方的Text字体大小和颜色(圆)*/
        setView_21_22();
    }
    private void initView() {
        view1=(NewDashboardView)findViewById(R.id.view1);
        view2=(NewDashboardView)findViewById(R.id.view2);
        view3=(NewDashboardView)findViewById(R.id.view3);
        view4=(NewDashboardView)findViewById(R.id.view4);
        view5=(NewDashboardView)findViewById(R.id.view5);
        view6=(NewDashboardView)findViewById(R.id.view6);
        view7=(NewDashboardView)findViewById(R.id.view7);
        view8=(NewDashboardView)findViewById(R.id.view8);
        view9=(NewDashboardView)findViewById(R.id.view9);
        view10=(NewDashboardView)findViewById(R.id.view10);
        view11=(NewDashboardView)findViewById(R.id.view11);
        view12=(NewDashboardView)findViewById(R.id.view12);
        view13=(NewDashboardView)findViewById(R.id.view13);
        view14=(NewDashboardView)findViewById(R.id.view14);
        view15=(NewDashboardView)findViewById(R.id.view15);
        view16=(NewDashboardView)findViewById(R.id.view16);
        view17=(NewDashboardView)findViewById(R.id.view17);
        view18=(NewDashboardView)findViewById(R.id.view18);
        view19=(NewDashboardView)findViewById(R.id.view19);
        view20=(NewDashboardView)findViewById(R.id.view20);
        view21=(NewDashboardView)findViewById(R.id.view21);
        view22=(NewDashboardView)findViewById(R.id.view22);
    }
    /**大刻度份数和小刻度份数(半圆)*/
    private void setView_1_2() {
        List<HighlightCR> highlights = new ArrayList<>();
        highlights.add(new HighlightCR(180, 40, Color.parseColor("#4CAF50")));
        highlights.add(new HighlightCR(220, 50, Color.parseColor("#EEC900")));
        highlights.add(new HighlightCR(270, 90, Color.parseColor("#F44336")));
        DashboradBean dashboradBean=new DashboradBean();
        dashboradBean.setHighlightCRList(highlights);
        dashboradBean.setAllAngle(180);
        dashboradBean.setStartAngle(180);
        dashboradBean.setBigSliceCount(5);
        dashboradBean.setSmallSliceCount(3);
        dashboradBean.setMaxValue(100);
        dashboradBean.setMinValue(0);
        dashboradBean.setIsHalf(true);
        view1.setDashboradBean(dashboradBean);
        view1.setRealTimeValue(60);
        ///////////////////////////////
        DashboradBean dashboradBean2=new DashboradBean();
        dashboradBean2.setHighlightCRList(highlights);
        dashboradBean2.setAllAngle(180);
        dashboradBean2.setStartAngle(180);
        dashboradBean2.setBigSliceCount(10);
        dashboradBean2.setSmallSliceCount(5);
        dashboradBean2.setMaxValue(200);
        dashboradBean2.setMinValue(100);
        dashboradBean2.setIsHalf(true);
        view2.setDashboradBean(dashboradBean2);
        view2.setRealTimeValue(120);
    }
    /**指针和原点颜色(半圆)*/
    private void setView_3_4() {
        List<HighlightCR> highlights = new ArrayList<>();
        highlights.add(new HighlightCR(180, 40, Color.parseColor("#4CAF50")));
        highlights.add(new HighlightCR(220, 50, Color.parseColor("#EEC900")));
        highlights.add(new HighlightCR(270, 90, Color.parseColor("#F44336")));
        DashboradBean dashboradBean=new DashboradBean();
        dashboradBean.setHighlightCRList(highlights);
        dashboradBean.setAllAngle(180);
        dashboradBean.setStartAngle(180);
        dashboradBean.setBigSliceCount(5);
        dashboradBean.setSmallSliceCount(3);
        dashboradBean.setMaxValue(100);
        dashboradBean.setMinValue(0);
        dashboradBean.setIsHalf(true);
        view3.setDashboradBean(dashboradBean);
        view3.setRealTimeValue(60);
        ///////////////////////////////
        DashboradBean dashboradBean2=new DashboradBean();
        dashboradBean2.setHighlightCRList(highlights);
        dashboradBean2.setAllAngle(180);
        dashboradBean2.setStartAngle(180);
        dashboradBean2.setBigSliceCount(5);
        dashboradBean2.setSmallSliceCount(3);
        dashboradBean2.setMaxValue(100);
        dashboradBean2.setMinValue(0);
        dashboradBean2.setIsHalf(true);
        dashboradBean2.setCenterPointColor(Color.BLACK);
        dashboradBean2.setPointerColor(Color.BLUE);
        view4.setDashboradBean(dashboradBean2);
        view4.setRealTimeValue(60);
    }
    /**外弧的色条(半圆)*/
    private void setView_5_6() {
        List<HighlightCR> highlights1 = new ArrayList<>();
        highlights1.add(new HighlightCR(180, 40, Color.parseColor("#4CAF50")));
        highlights1.add(new HighlightCR(220, 50, Color.parseColor("#EEC900")));
        highlights1.add(new HighlightCR(270, 90, Color.parseColor("#F44336")));
        DashboradBean dashboradBean=new DashboradBean();
        dashboradBean.setHighlightCRList(highlights1);
        dashboradBean.setAllAngle(180);
        dashboradBean.setStartAngle(180);
        dashboradBean.setBigSliceCount(5);
        dashboradBean.setSmallSliceCount(3);
        dashboradBean.setMaxValue(100);
        dashboradBean.setMinValue(0);
        dashboradBean.setIsHalf(true);
        view5.setDashboradBean(dashboradBean);
        view5.setRealTimeValue(60);
        ///////////////////////////////
        DashboradBean dashboradBean2=new DashboradBean();
        List<HighlightCR> highlights2 = new ArrayList<>();
        highlights2.add(new HighlightCR(180, 60, Color.parseColor("#FF7F00")));
        highlights2.add(new HighlightCR(240, 120, Color.parseColor("#0000EE")));
        dashboradBean2.setHighlightCRList(highlights2);
        dashboradBean2.setAllAngle(180);
        dashboradBean2.setStartAngle(180);
        dashboradBean2.setBigSliceCount(5);
        dashboradBean2.setSmallSliceCount(3);
        dashboradBean2.setMaxValue(100);
        dashboradBean2.setMinValue(0);
        dashboradBean2.setIsHalf(true);
        view6.setDashboradBean(dashboradBean2);
        view6.setRealTimeValue(60);

    }
    /**刻度值的颜色(半圆)*/
    private void setView_7_8() {
        List<HighlightCR> highlights1 = new ArrayList<>();
        highlights1.add(new HighlightCR(180, 40, Color.parseColor("#4CAF50")));
        highlights1.add(new HighlightCR(220, 50, Color.parseColor("#EEC900")));
        highlights1.add(new HighlightCR(270, 90, Color.parseColor("#F44336")));
        DashboradBean dashboradBean=new DashboradBean();
        dashboradBean.setHighlightCRList(highlights1);
        dashboradBean.setAllAngle(180);
        dashboradBean.setStartAngle(180);
        dashboradBean.setBigSliceCount(5);
        dashboradBean.setSmallSliceCount(3);
        dashboradBean.setMaxValue(100);
        dashboradBean.setMinValue(0);
        dashboradBean.setIsHalf(true);
        view7.setDashboradBean(dashboradBean);
        view7.setRealTimeValue(60);
        ///////////////////////////////
        DashboradBean dashboradBean2=new DashboradBean();
        dashboradBean2.setHighlightCRList(highlights1);
        dashboradBean2.setAllAngle(180);
        dashboradBean2.setStartAngle(180);
        dashboradBean2.setBigSliceCount(5);
        dashboradBean2.setSmallSliceCount(3);
        dashboradBean2.setMaxValue(100);
        dashboradBean2.setMinValue(0);
        dashboradBean2.setIsHalf(true);
        dashboradBean2.setScaleTextColor(Color.BLACK);
        dashboradBean2.setScaleColor(Color.BLUE);
        view8.setDashboradBean(dashboradBean2);
        view8.setRealTimeValue(60);
    }
    /**原点上方的Text字体大小和颜色(半圆)*/
    private void setView_9_10() {
        List<HighlightCR> highlights1 = new ArrayList<>();
        highlights1.add(new HighlightCR(180, 40, Color.parseColor("#4CAF50")));
        highlights1.add(new HighlightCR(220, 50, Color.parseColor("#EEC900")));
        highlights1.add(new HighlightCR(270, 90, Color.parseColor("#F44336")));
        DashboradBean dashboradBean=new DashboradBean();
        dashboradBean.setHighlightCRList(highlights1);
        dashboradBean.setAllAngle(180);
        dashboradBean.setStartAngle(180);
        dashboradBean.setBigSliceCount(5);
        dashboradBean.setSmallSliceCount(3);
        dashboradBean.setMaxValue(100);
        dashboradBean.setMinValue(0);
        dashboradBean.setIsHalf(true);
        view9.setDashboradBean(dashboradBean);
        view9.setRealTimeValue(60);
        view9.setTopText("TopText", 0, 0);
        view10.setDashboradBean(dashboradBean);
        view10.setRealTimeValue(60);
        view10.setTopText("TopText", 30, Color.BLUE);
    }
    /**大刻度份数和小刻度份数(圆)*/
    private void setView_11_12() {
        List<HighlightCR> highlights = new ArrayList<>();
        highlights.add(new HighlightCR(120, 80, Color.parseColor("#4CAF50")));
        highlights.add(new HighlightCR(200, 70, Color.parseColor("#EEC900")));
        highlights.add(new HighlightCR(270, 150, Color.parseColor("#F44336")));
        DashboradBean dashboradBean=new DashboradBean();
        dashboradBean.setHighlightCRList(highlights);
        dashboradBean.setAllAngle(300);
        dashboradBean.setStartAngle(120);
        dashboradBean.setBigSliceCount(5);
        dashboradBean.setSmallSliceCount(3);
        dashboradBean.setMaxValue(100);
        dashboradBean.setMinValue(0);
        dashboradBean.setIsHalf(false);
        view11.setDashboradBean(dashboradBean);
        view12.setRealTimeValue(60);
        ///////////////////////////////
        DashboradBean dashboradBean2=new DashboradBean();
        dashboradBean2.setHighlightCRList(highlights);
        dashboradBean2.setAllAngle(300);
        dashboradBean2.setStartAngle(120);
        dashboradBean2.setBigSliceCount(10);
        dashboradBean2.setSmallSliceCount(5);
        dashboradBean2.setMaxValue(200);
        dashboradBean2.setMinValue(100);
        dashboradBean2.setIsHalf(false);
        view12.setDashboradBean(dashboradBean2);
        view12.setRealTimeValue(120);
    }
    /**指针和原点颜色(圆)*/
    private void setView_13_14() {
        List<HighlightCR> highlights = new ArrayList<>();
        highlights.add(new HighlightCR(120, 80, Color.parseColor("#4CAF50")));
        highlights.add(new HighlightCR(200, 70, Color.parseColor("#EEC900")));
        highlights.add(new HighlightCR(270, 150, Color.parseColor("#F44336")));
        DashboradBean dashboradBean=new DashboradBean();
        dashboradBean.setHighlightCRList(highlights);
        dashboradBean.setAllAngle(300);
        dashboradBean.setStartAngle(120);
        dashboradBean.setBigSliceCount(5);
        dashboradBean.setSmallSliceCount(3);
        dashboradBean.setMaxValue(100);
        dashboradBean.setMinValue(0);
        dashboradBean.setIsHalf(false);
        view13.setDashboradBean(dashboradBean);
        view13.setRealTimeValue(60);
        ///////////////////////////////
        DashboradBean dashboradBean2=new DashboradBean();
        dashboradBean2.setHighlightCRList(highlights);
        dashboradBean2.setAllAngle(300);
        dashboradBean2.setStartAngle(120);
        dashboradBean2.setBigSliceCount(5);
        dashboradBean2.setSmallSliceCount(3);
        dashboradBean2.setMaxValue(100);
        dashboradBean2.setMinValue(0);
        dashboradBean2.setIsHalf(false);
        dashboradBean2.setCenterPointColor(Color.BLACK);
        dashboradBean2.setPointerColor(Color.BLUE);
        view14.setDashboradBean(dashboradBean2);
        view14.setRealTimeValue(60);
    }
    /**外弧的色条(圆)*/
    private void setView_15_16() {
        List<HighlightCR> highlights1 = new ArrayList<>();
        highlights1.add(new HighlightCR(120, 80, Color.parseColor("#4CAF50")));
        highlights1.add(new HighlightCR(200, 70, Color.parseColor("#EEC900")));
        highlights1.add(new HighlightCR(270, 150, Color.parseColor("#F44336")));
        DashboradBean dashboradBean=new DashboradBean();
        dashboradBean.setHighlightCRList(highlights1);
        dashboradBean.setAllAngle(300);
        dashboradBean.setStartAngle(120);
        dashboradBean.setBigSliceCount(5);
        dashboradBean.setSmallSliceCount(3);
        dashboradBean.setMaxValue(100);
        dashboradBean.setMinValue(0);
        dashboradBean.setIsHalf(false);
        view15.setDashboradBean(dashboradBean);
        view15.setRealTimeValue(60);
        ///////////////////////////////
        DashboradBean dashboradBean2=new DashboradBean();
        List<HighlightCR> highlights2 = new ArrayList<>();
        highlights2.add(new HighlightCR(120, 80, Color.parseColor("#FF7F00")));
        highlights2.add(new HighlightCR(200, 220, Color.parseColor("#0000EE")));
        dashboradBean2.setHighlightCRList(highlights2);
        dashboradBean2.setAllAngle(300);
        dashboradBean2.setStartAngle(120);
        dashboradBean2.setBigSliceCount(5);
        dashboradBean2.setSmallSliceCount(3);
        dashboradBean2.setMaxValue(100);
        dashboradBean2.setMinValue(0);
        dashboradBean2.setIsHalf(false);
        view16.setDashboradBean(dashboradBean2);
        view16.setRealTimeValue(60);
    }
    /**刻度值的颜色(圆)*/
    private void setView_17_18() {
        List<HighlightCR> highlights1 = new ArrayList<>();
        highlights1.add(new HighlightCR(120, 80, Color.parseColor("#4CAF50")));
        highlights1.add(new HighlightCR(200, 70, Color.parseColor("#EEC900")));
        highlights1.add(new HighlightCR(270, 150, Color.parseColor("#F44336")));
        DashboradBean dashboradBean=new DashboradBean();
        dashboradBean.setHighlightCRList(highlights1);
        dashboradBean.setAllAngle(300);
        dashboradBean.setStartAngle(120);
        dashboradBean.setBigSliceCount(5);
        dashboradBean.setSmallSliceCount(3);
        dashboradBean.setMaxValue(100);
        dashboradBean.setMinValue(0);
        dashboradBean.setIsHalf(false);
        view17.setDashboradBean(dashboradBean);
        view17.setRealTimeValue(60);
        ///////////////////////////////
        DashboradBean dashboradBean2=new DashboradBean();
        dashboradBean2.setHighlightCRList(highlights1);
        dashboradBean2.setAllAngle(300);
        dashboradBean2.setStartAngle(120);
        dashboradBean2.setBigSliceCount(5);
        dashboradBean2.setSmallSliceCount(3);
        dashboradBean2.setMaxValue(100);
        dashboradBean2.setMinValue(0);
        dashboradBean2.setIsHalf(false);
        dashboradBean2.setScaleTextColor(Color.BLACK);
        dashboradBean2.setScaleColor(Color.BLUE);
        view18.setDashboradBean(dashboradBean2);
        view18.setRealTimeValue(60);

    }
    /**原点上方的Text字体大小和颜色(圆)*/
    private void setView_19_20() {
        List<HighlightCR> highlights1 = new ArrayList<>();
        highlights1.add(new HighlightCR(120, 80, Color.parseColor("#4CAF50")));
        highlights1.add(new HighlightCR(200, 70, Color.parseColor("#EEC900")));
        highlights1.add(new HighlightCR(270, 150, Color.parseColor("#F44336")));
        DashboradBean dashboradBean=new DashboradBean();
        dashboradBean.setHighlightCRList(highlights1);
        dashboradBean.setAllAngle(300);
        dashboradBean.setStartAngle(120);
        dashboradBean.setBigSliceCount(5);
        dashboradBean.setSmallSliceCount(3);
        dashboradBean.setMaxValue(100);
        dashboradBean.setMinValue(0);
        dashboradBean.setIsHalf(false);
        view19.setDashboradBean(dashboradBean);
        view19.setRealTimeValue(60);
        view19.setTopText("TopText", 0, 0);
        view20.setDashboradBean(dashboradBean);
        view20.setRealTimeValue(60);
        view20.setTopText("TopText", 30, Color.BLUE);
    }
    /**原点下方的Text字体大小和颜色(圆)*/
    private void setView_21_22() {
        List<HighlightCR> highlights1 = new ArrayList<>();
        highlights1.add(new HighlightCR(120, 80, Color.parseColor("#4CAF50")));
        highlights1.add(new HighlightCR(200, 70, Color.parseColor("#EEC900")));
        highlights1.add(new HighlightCR(270, 150, Color.parseColor("#F44336")));
        DashboradBean dashboradBean=new DashboradBean();
        dashboradBean.setHighlightCRList(highlights1);
        dashboradBean.setAllAngle(300);
        dashboradBean.setStartAngle(120);
        dashboradBean.setBigSliceCount(5);
        dashboradBean.setSmallSliceCount(2);
        dashboradBean.setMaxValue(100);
        dashboradBean.setMinValue(0);
        dashboradBean.setIsHalf(false);
        view21.setDashboradBean(dashboradBean);
        view21.setRealTimeValue(60);
        view21.setEndText("EndText", 0, 0);
        view22.setDashboradBean(dashboradBean);
        view22.setRealTimeValue(60);
        view22.setEndText("EndText", 40, Color.BLUE);
    }
}
