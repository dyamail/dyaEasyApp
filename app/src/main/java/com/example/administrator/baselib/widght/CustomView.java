package com.example.administrator.baselib.widght;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.administrator.baselib.util.LogUtils;

import static com.example.administrator.baselib.util.CrashUtils.init;

/**
 * Description:
 * Company    :
 * Author     : dyamail
 * Date       : 5017/7/26  16:54
 */
public class CustomView extends View {
    private Paint mPaint;
    private Rect mBound;
    private int mRadio = 20;

    /**
     * 一个参数的构造方法
     *
     * @param context
     */
    public CustomView(Context context) {
        super(context);
        initPaint();
    }

    /**
     * 两个参数的构造方法
     *
     * @param context
     */
    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    /**
     * 三个参数的构造方法
     *
     * @param context
     */
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    /**
     * 安卓5.0以上才有的方法
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initPaint();
    }

    private void initPaint() {
//       paint. setArgb(int a, int r, int g, int b);               //设置绘制的颜色，a表示透明度，r、g、b表示颜色值；
//       paint. setAlpha(int a);                                        //设置绘制的图形的透明度；
//       paint. setColor(int color);                                 //设置绘制的颜色；
//       paint. setAntiAlias(boolean a);                             //设置是否使用抗锯齿功能，抗锯齿功能会消耗较大资源，绘制图形的速度会减慢；
//       paint. setDither(boolean b);                               //设置是否使用图像抖动处理，会使图像颜色更加平滑饱满，更加清晰；
//       paint. setFileterBitmap(Boolean b);                       //设置是否在动画中滤掉Bitmap的优化，可以加快显示速度；
//       paint. setMaskFilter(MaskFilter mf);                      //设置MaskFilter来实现滤镜的效果；
//       paint. setColorFilter(ColorFilter cf);                    //设置颜色过滤器，可以在绘制颜色时实现不同颜色的变换效果；
//       paint. setPathEffect(PathEffect pe);                      //设置绘制的路径的效果；
//       paint. setShader(Shader s);                               //设置Shader绘制各种渐变效果；
//       paint. setShadowLayer(fpaint.oat r, int x, int y, int c);//在图形下面设置阴影层，r为阴影角度，x和y为阴影在x轴和y轴上的距离，c为阴影的颜色；
//       paint. setStyle(Paint.Style s);                          //设置画笔的样式;//FILL实心；STROKE空心；FILL_OR_STROKE同时实心与空心；
//       paint. setStrokeCap(Paint.Cap c);                        //当设置画笔样式为STROKE或FILL_OR_STROKE时，设置笔刷的图形样式；
//       paint. setStrokeJoin(Paint.Join j);                      //设置绘制时各图形的结合方式；
//       paint. setStrokeWidth(float w);                          //当画笔样式为STROKE或FILL_OR_STROKE时，设置笔刷的粗细度；
//       paint. setXfermode(Xfermode m);                          //设置图形重叠时的处理方式；
        Paint paint = new Paint();
        paint.setColor(Color.RED);      //设置画笔颜色
        paint.setAntiAlias(true);       //设置画笔抗锯齿
        paint.setStrokeWidth(5);        //设置画笔粗细
        paint.setDither(false);         //设置是否使用抗锯齿
        mPaint = paint;

        mBound = new Rect();                //暂时不知道什么东东
    }

    /**
     * 对View的测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
//    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int mWidth = 0;
//        int mHeight = 0;
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);   //获取宽的模式
//        int heightMode = MeasureSpec.getMode(heightMeasureSpec); //获取高的模式
//        int widthSize = MeasureSpec.getSize(widthMeasureSpec);   //获取宽的尺寸
//        int heightSize = MeasureSpec.getSize(heightMeasureSpec); //获取高的尺寸
////        LogUtils.d("宽的模式:" + widthMode);
////        LogUtils.d("高的模式:" + heightMode);
////        LogUtils.d("宽的尺寸:" + widthSize);
////        LogUtils.d( "高的尺寸:" + heightSize);
//        switch (widthMode) {
//            //父控件决定给孩子一个精确的尺寸
//            case MeasureSpec.EXACTLY:
//                mWidth = widthSize;
//                break;
//            //父控件会给子控件尽可能大的尺寸
//            case MeasureSpec.AT_MOST:
////                float textWidth = mBound.width();
////                mWidth =  getMinimumWidth();
//                break;
//            //父控件不强加任何约束给子控件，它可以是它想要任何大小。
//            case MeasureSpec.UNSPECIFIED:
//                break;
//            default:
//                break;
//
//        }
//
//
//        switch (heightMode) {
//            //父控件决定给孩子一个精确的尺寸
//            case MeasureSpec.EXACTLY:
//                mHeight = heightSize;
//                break;
//            //父控件会给子控件尽可能大的尺寸
//            case MeasureSpec.AT_MOST:
////                float textHeight = mBound.height();
////                mHeight =  getMinimumHeight();
//                break;
//            //父控件不强加任何约束给子控件，它可以是它想要任何大小。
//            case MeasureSpec.UNSPECIFIED:
//                break;
//            default:
//                break;
//
//        }
//        //保存测量宽度和测量高度
//        setMeasuredDimension(mWidth, mHeight);
//    }

    /**
     * 当view大小发生变化时调用
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * 设置布局的大小
     *
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 对view的绘制都在此方法中
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawText("这只是随便写的", getWidth() / 2, getWidth() / 2, mPaint);
//        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 2, mPaint);
//        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStyle(Paint.Style.STROKE); //画笔空芯

//        mPaint.setStyle(Paint.Style.FILL);//充满
        mPaint.setColor(Color.DKGRAY);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, mRadio, mPaint);
//        mPaint.setColor(Color.RED);
//        canvas.drawLine(0, 50, 50, 50, mPaint);
//        canvas.drawLine(50, 0, 50, 50, mPaint);

        startAnim();
    }

    public void startAnim() {

                ObjectAnimator animator = ObjectAnimator.ofFloat(this, "scale", 1f, 3f, 1f);
                animator.setDuration(2000);
                animator.start();

    }

    /**
     * 触摸控件是调用
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        return super.onTouchEvent(event);
        int eventAction = event.getAction();
        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:
                LogUtils.d("按下");
                break;
            case MotionEvent.ACTION_MOVE:
                LogUtils.d("移动");
                break;
            case MotionEvent.ACTION_UP:
                LogUtils.d("抬起");
                break;
        }
        return true;
    }
}
