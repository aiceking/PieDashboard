package com.example.vmmet.mypiedashboard.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.vmmet.mypiedashboard.bean.DashboradBean;
import com.example.vmmet.mypiedashboard.bean.HighlightCR;

/**
 * Created by Vmmet on 2016/11/8.

 */
public class NewDashboardView extends View {
    private Paint paint;
    private float mRadius,mHighlightRadius,mCenterX,mCenterY;
    private String topText,endText;
    private int TopTextSize, TopTextColor,EndTextSize,EndTextColor;
    private DashboradBean dashboradBean;

    public void setRealTimeValue(float realTimeValue) {
        this.realTimeValue = realTimeValue;
        invalidate();
    }

    private float realTimeValue; //刻度盘当前值
    public void setDashboradBean(DashboradBean dashboradBean) {
        this.dashboradBean = dashboradBean;
        this.realTimeValue = dashboradBean.getMinValue();
        invalidate();
    }

    public NewDashboardView(Context context) {
        this(context, null);
    }

    public void setTopText(String topText,int TopTextSize,int TopTextColor) {
        this.topText = topText;
        this.TopTextSize=TopTextSize;
        this.TopTextColor=TopTextColor;
        invalidate();
    }

    public void setEndText(String endText,int EndTextSize,int EndTextColor) {
        this.endText = endText;
        this.EndTextSize=EndTextSize;
        this.EndTextColor=EndTextColor;
        invalidate();
    }

    public NewDashboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mRadius=0;
        mCenterX=0;
        mCenterY=0;
        mHighlightRadius=0;
        realTimeValue=0;
        topText="";
        endText="";
        TopTextSize=0;
        TopTextColor=0;
        EndTextSize=0;
        EndTextColor=0;
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public NewDashboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int width=MeasureSpec.getSize(widthMeasureSpec);
        int height = 0;
        if (dashboradBean!=null){
            if (dashboradBean.isHalf()){
                height =(int) (width/2f+(width/2f/7.5f));
            }else{
                height=width;
            }
//        switch (mode) {
//            case MeasureSpec.UNSPECIFIED: {//如果没有指定大小，就设置为默认大小
//                if (dashboradBean.isHalf()){
//                height = widthMeasureSpec / 4 * 3;
//                }else{
//                    height=widthMeasureSpec;
//                }
//                break;
//            }
//            case MeasureSpec.AT_MOST: {//如果测量模式是最大取值为size
//                //我们将大小取最大值,你也可以取其他值
//                if (dashboradBean.isHalf()){
//                    height = widthMeasureSpec / 4 * 3;
//                }else{
//                    height=widthMeasureSpec;
//                }
//                break;
//            }
//            case MeasureSpec.EXACTLY: {//如果是固定的大小，那就不要去改变它
//                height=heightMeasureSpec;
//                break;
//            }
//        }
        setMeasuredDimension(width, height);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mRadius=getWidth()/2f;
        mHighlightRadius=mRadius/7.5f;
        mCenterX=mRadius;
        mCenterY=mRadius;
        super.onDraw(canvas);
        if (dashboradBean != null) {
            drawMeasures(canvas);/*** 刻度盘和读数*/
        drawStripe(canvas);/**刻度盘的弧形*/
        drawTopTexts(canvas);/**画中心原点上方文本*/
            drawEndTexts(canvas);/**画中心原点下方文本*/
            drawPointer(canvas);    /**画指针和中心原点*/
        }
    }

    private void drawEndTexts(Canvas canvas) {
        if (EndTextSize==0){
        paint.setTextSize(mHighlightRadius / 1.2f);
        }else {
            paint.setTextSize(EndTextSize);
        }
        if (EndTextColor==0){
            paint.setColor(Color.BLACK);
        }else{
            paint.setColor(EndTextColor);
        }
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(endText,mCenterX,mCenterY+3f*mHighlightRadius,paint);
    }

    private void drawTopTexts(Canvas canvas) {
        if (TopTextSize==0){
            paint.setTextSize(mHighlightRadius / 1.4f);
        }else {
            paint.setTextSize(TopTextSize);
        }
        if (TopTextColor==0){
            paint.setColor(Color.BLACK);
        }else{
            paint.setColor(TopTextColor);
        }
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(topText,mCenterX,mCenterY-mHighlightRadius,paint);
    }

    /**刻度盘的弧形*/
    private void drawStripe(Canvas canvas) {
            if (dashboradBean.getHighlightCRList()!=null){
            for (int i = 0; i < dashboradBean.getHighlightCRList().size(); i++) {
                HighlightCR highlightCR = dashboradBean.getHighlightCRList().get(i);
                if (highlightCR.getColor() == 0 || highlightCR.getSweepAngle() == 0)
                    continue;
                paint.setColor(highlightCR.getColor());
                paint.setStrokeWidth(mHighlightRadius);
                paint.setStrokeCap(Paint.Cap.ROUND);
                paint.setStyle(Paint.Style.STROKE);
                RectF rectF1=new RectF(mHighlightRadius/2f,mHighlightRadius/2f,getWidth()-mHighlightRadius/2f,getWidth()-mHighlightRadius/2f);
                RectF rectF2=new RectF(mHighlightRadius/0.85f,mHighlightRadius/0.85f,getWidth()-mHighlightRadius/0.85f,getWidth()-mHighlightRadius/0.85f);
                canvas.drawArc(rectF1, highlightCR.getStartAngle(),
                        highlightCR.getSweepAngle(), false, paint);
                paint.setStrokeWidth(mHighlightRadius/6f);
                canvas.drawArc(rectF2, highlightCR.getStartAngle(),
                        highlightCR.getSweepAngle(), false, paint);
            }
        }
    }
    /*** 刻度盘和读数*/
    private void drawMeasures(Canvas canvas) {
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(2);
        Paint p=new Paint();
        p.setStyle(Paint.Style.FILL);
        p.setStrokeWidth(1);
        p.setTextSize(mHighlightRadius / 1.2f);
        p.setAntiAlias(true);
        p.setTextAlign(Paint.Align.CENTER);
        float averageBigangle=((float)dashboradBean.getAllAngle()) /((float)dashboradBean.getBigSliceCount());
        for (int i = 0; i <= dashboradBean.getBigSliceCount(); i++) {
            //绘制大刻度
            float angle = i *averageBigangle+dashboradBean.getStartAngle() ;
            float[] point1 = getCoordinatePoint(mRadius-mHighlightRadius/0.85f, angle);
            float[] point2 = getCoordinatePoint(mRadius-mHighlightRadius/0.85f-mHighlightRadius/5f*2.8f, angle);
            if ( dashboradBean.getHighlightCRList() != null) {
                for (int j = 0; j < dashboradBean.getHighlightCRList().size(); j++) {
                    HighlightCR highlightCR = dashboradBean.getHighlightCRList().get(j);
                    if (highlightCR.getColor() == 0 || highlightCR.getSweepAngle() == 0)
                        continue;
                    if (angle>=highlightCR.getStartAngle()&&angle <= highlightCR.getStartAngle() + highlightCR.getSweepAngle()) {
                        paint.setColor(highlightCR.getColor());
                        p.setColor(highlightCR.getColor());
                        break;
                    }
                }
            } else {
                paint.setColor(Color.BLACK);
                p.setColor(Color.BLACK);
            }
            if (dashboradBean.getScaleColor()!=0){
                paint.setColor(dashboradBean.getScaleColor());
            }
            paint.setStrokeWidth(mHighlightRadius / 6f);
            canvas.drawLine(point1[0], point1[1], point2[0], point2[1], paint);
            //绘制圆盘上的数字
            String number =trimFloat(((float) (dashboradBean.getMaxValue()-dashboradBean.getMinValue()))
                    /((float)dashboradBean.getBigSliceCount())*i+(float)dashboradBean.getMinValue()) +"";
            if (dashboradBean.getScaleTextColor()!=0){
                p.setColor(dashboradBean.getScaleTextColor());
            }
            //旋转绘制
            canvas.rotate(360f - (float) dashboradBean.getAllAngle() / 2f + (float) i * averageBigangle, mCenterX, mCenterY);
            canvas.drawText(number, mCenterX, mHighlightRadius * 2.75f, p);
            canvas.rotate(-360f+(float)dashboradBean.getAllAngle()/2f-(float)i*averageBigangle,mCenterX,mCenterY);
        }

        //绘制小的子刻度
        float averageSmallangle=((float)dashboradBean.getAllAngle() )/(float)(dashboradBean.getSmallSliceCount()*dashboradBean.getBigSliceCount());
        for (int i = 0; i < dashboradBean.getSmallSliceCount()*dashboradBean.getBigSliceCount(); i++) {
                float angle = i * averageSmallangle + dashboradBean.getStartAngle();
                float[] point1 = getCoordinatePoint(mRadius-mHighlightRadius/0.85f, angle);
                float[] point2 = getCoordinatePoint(mRadius-mHighlightRadius/0.85f-mHighlightRadius/5f*1.4f, angle);

                if ( dashboradBean.getHighlightCRList() != null) {
                    for (int j = 0; j < dashboradBean.getHighlightCRList().size(); j++) {
                        HighlightCR highlightCR = dashboradBean.getHighlightCRList().get(j);
                        if (highlightCR.getColor() == 0 || highlightCR.getSweepAngle() == 0)
                            continue;
                        if (angle>=highlightCR.getStartAngle()&&angle <= highlightCR.getStartAngle() + highlightCR.getSweepAngle()) {
                            paint.setColor(highlightCR.getColor());
                            break;
                        }
                    }
                } else {
                    paint.setColor(Color.BLACK);
                }
            if (dashboradBean.getScaleColor()!=0){
                paint.setColor(dashboradBean.getScaleColor());
            }
            paint.setStrokeWidth(mHighlightRadius/6f/2f);
                canvas.drawLine(point1[0], point1[1], point2[0], point2[1], paint);
        }
    }
    /**
     * float类型如果小数点后为零则显示整数否则保留
     */
    public static String trimFloat(float value) {
        if (Math.round(value) - value == 0) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
    /**画指针和中心原点*/
    private void drawPointer(Canvas canvas) {
        float degree=0;
        if (realTimeValue>=dashboradBean.getMinValue()&&realTimeValue<=dashboradBean.getMaxValue()){
            degree=(float)(dashboradBean.getStartAngle())+((realTimeValue-dashboradBean.getMinValue())/
                (dashboradBean.getMaxValue()-dashboradBean.getMinValue()))*(float)dashboradBean.getAllAngle();
        }else if(realTimeValue<dashboradBean.getMinValue()){
            degree=(float)dashboradBean.getStartAngle();
        }else{
            degree=(float)(dashboradBean.getStartAngle())+(float)dashboradBean.getAllAngle();
        }
        float point[]=getCoordinatePoint(mRadius-mHighlightRadius*2.4f,degree);
        paint.setStyle(Paint.Style.FILL);
            Path p=new Path();
            p.moveTo(point[0], point[1]);
            float point_left[]=getCoordinatePoint(mHighlightRadius / 2f,degree-90);
            float point_right[]=getCoordinatePoint(mHighlightRadius / 2f,degree+90);
            p.lineTo(point_left[0], point_left[1]);
            p.lineTo(point_right[0], point_right[1]);
            p.close();
            if(dashboradBean.getPointerColor()!=0){
                paint.setColor(dashboradBean.getPointerColor());
            }else{
                paint.setColor(Color.RED);
            }
            canvas.drawPath(p, paint);
            if (dashboradBean.getCenterPointColor()!=0){
                 paint.setColor(dashboradBean.getCenterPointColor());
            } else {
                paint.setColor(Color.parseColor("#A9AFAE"));
            }
        canvas.drawCircle(mCenterX,mCenterY,mHighlightRadius/1.65f,paint);
    }
    public float[] getCoordinatePoint(float radius, float cirAngle) {
        float[] point = new float[2];
        double arcAngle = Math.toRadians(cirAngle); //将角度转换为弧度
        if (cirAngle < 90) {
            point[0] = (float) (mCenterX + Math.cos(arcAngle) * radius);
            point[1] = (float) (mCenterY + Math.sin(arcAngle) * radius);
        } else if (cirAngle == 90) {
            point[0] = mCenterX;
            point[1] = mCenterY + radius;
        } else if (cirAngle > 90 && cirAngle < 180) {
            arcAngle = Math.PI * (180 - cirAngle) / 180.0;
            point[0] = (float) (mCenterX - Math.cos(arcAngle) * radius);
            point[1] = (float) (mCenterY + Math.sin(arcAngle) * radius);
        } else if (cirAngle == 180) {
            point[0] = mCenterX - radius;
            point[1] = mCenterY;
        } else if (cirAngle > 180 && cirAngle < 270) {
            arcAngle = Math.PI * (cirAngle - 180) / 180.0;
            point[0] = (float) (mCenterX - Math.cos(arcAngle) * radius);
            point[1] = (float) (mCenterY - Math.sin(arcAngle) * radius);
        } else if (cirAngle == 270) {
            point[0] = mCenterX;
            point[1] = mCenterY - radius;
        } else {
            arcAngle = Math.PI * (360 - cirAngle) / 180.0;
            point[0] = (float) (mCenterX + Math.cos(arcAngle) * radius);
            point[1] = (float) (mCenterY - Math.sin(arcAngle) * radius);
        }
        return point;
    }
}