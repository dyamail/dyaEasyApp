package com.example.dyamail.customviewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dyamail on 2017/8/17.
 */

public class CustonView extends View {
    private Paint mPaint;

    private int desiredWidth = 100;
    private int desiredHeight = 100;

    public CustonView(Context context) {
        super(context);
        initPaint();
    }

    public CustonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CustonView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        Paint paint=new Paint();
        paint.setColor(Color.BLUE);     //画笔设置颜色
        paint.setAntiAlias(true);       //画笔设置是否抗锯齿
        paint.setStrokeWidth(5);        //设置画笔笔尖大小
        paint.setStyle(Paint.Style.FILL);//STROKE 画线模式、FILL填充模式(默认为填充模式)、FILL_AND_STROKE（即画线又填充）
        mPaint=paint;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //解决自定义View 设置warp_content无效问题
        int width;
        int height;
        //获取with的测量模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        //获取height的测量模式
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //获取width的大小
        int withSize = MeasureSpec.getSize(widthMeasureSpec);
        //获取height的大小
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        //当width的测量模式为精确模式的时候直接用测量大小
        //当width的测量模式为最大值模式时用设置最小值取代
        if (widthMode == MeasureSpec.EXACTLY) {
            width = withSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, withSize);
        } else {
            width = desiredWidth;
        }
        //当height的测量模式为精确模式的时候直接用测量大小
        //当height的测量模式为最大值模式时用设置最小值取代
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 画圆
         */
        //设置画笔为填充
        mPaint.setStyle(Paint.Style.FILL);
        //画圆——200,200为圆心的坐标  100为半径
        canvas.drawCircle(200,200,100,mPaint);
        //设置画笔颜色为红色
        mPaint.setColor(Color.RED);
        //设置画笔为描边模式
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(200,200,105,mPaint);
        /**
         * 画矩形
         */
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRect(330,100,500,300,mPaint);
        // RectF描述为屏幕的一块矩形区域
        RectF rectF=new RectF(530,100,630,300);
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(rectF,mPaint);
        /**
         * 画圆角矩形
         */
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        canvas.drawRoundRect(650,100,800,200,20,20,mPaint);
        // RectF描述为屏幕的一块矩形区域
        RectF RoundrectF=new RectF(850,100,1100,200);
        canvas.drawRoundRect(RoundrectF,20,25,mPaint);
        //画椭圆
        canvas.drawOval(10,400,200,500,mPaint);
        //画扇形
        canvas.drawArc(250,400,400,550,0,100,true,mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawArc(250,400,400,550,0,101,true,mPaint);

        canvas.drawArc(600,400,900,650,0,100,false                     ,mPaint);
    }
}
