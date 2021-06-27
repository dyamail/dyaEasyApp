package com.example.dyamail.customviewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.AppCompatSeekBar;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.SeekBar;

public class SeekBarAndText extends AppCompatSeekBar {
    private Paint mPaint;
    private Rect mProgressTextRect = new Rect();
    private int mThumbWidth = dp2px(60);
    private OnSeekBarAndtextChangeListener onSeekBarAndtextChangeListener;
    private SongTimeCallBack songTimeCallBack;

    public SeekBarAndText(Context context) {
        this(context, null);
    }

    public SeekBarAndText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SeekBarAndText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new TextPaint();//初始化画笔
        mPaint.setAntiAlias(true);//消除锯齿
        mPaint.setColor(Color.parseColor("#99000000"));//画笔颜色
        mPaint.setTextSize(sp2px(6));//字体大小
        // 如果不设置padding，当滑动到最左边或最右边时，滑块会显示不全
        setPadding(mThumbWidth / 2, 0, mThumbWidth / 2, 0);
        // 设置滑动监听
        this.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (onSeekBarAndtextChangeListener != null) {
                    onSeekBarAndtextChangeListener.onProgressChanged(seekBar, progress, fromUser);
                }
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (onSeekBarAndtextChangeListener != null) {
                    onSeekBarAndtextChangeListener.onStartTrackingTouch(seekBar);
                }
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (onSeekBarAndtextChangeListener != null) {
                    onSeekBarAndtextChangeListener.onStopTrackingTouch(seekBar);
                }
            }
        });
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String progressText = "";//要画的文字
        if (songTimeCallBack != null) {
            //将要画的时间对外提供
            progressText = songTimeCallBack.getDrawText();
        }
        mPaint.getTextBounds(progressText, 0, progressText.length(), mProgressTextRect);
        // 进度百分比
        float progressRatio = (float) getProgress() / getMax();
        float thumbOffset = (mThumbWidth - mProgressTextRect.width()) / 2 - mThumbWidth * progressRatio;
        float thumbX = getWidth() * progressRatio + thumbOffset;
        float thumbY = getHeight() / 2f + mProgressTextRect.height() / 2f;
        float indicatorOffset = getWidth() * progressRatio - mThumbWidth / 2 - mThumbWidth * progressRatio;
        if (progressRatio > 0) {
            //画文字
            canvas.drawText(progressText, thumbX, thumbY, mPaint);
            mProgressTextRect.offsetTo((int) thumbX, (int) thumbY);
        } else {
            canvas.drawText(progressText, (mThumbWidth - mProgressTextRect.width()) / 2, thumbY, mPaint);
        }
    }


    /**
     * 设置进度监听
     *
     * @param listener OnIndicatorSeekBarChangeListener
     */
    public void setOnSeekBarChangeListener(OnSeekBarAndtextChangeListener listener) {
        this.onSeekBarAndtextChangeListener = listener;
    }

    /**
     * 进度监听
     */
    public interface OnSeekBarAndtextChangeListener {
        public void onProgress(SeekBar seekBar, int progress, float indicatorOffset);

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromuser);

        public void onStartTrackingTouch(SeekBar seekBar);

        public void onStopTrackingTouch(SeekBar seekBar);
    }

    /**
     * dp转px
     *
     * @param dp dp值
     * @return px值
     */
    public int dp2px(float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }


    /**
     * sp转px
     *
     * @param sp sp值
     * @return px值
     */
    private int sp2px(float sp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp,
                getResources().getDisplayMetrics());
    }

    public interface SongTimeCallBack {
        String getSongTime(int progress);

        String getDrawText();
    }

    public void setSongTimeCallBack(SongTimeCallBack songTimeCallBack) {
        this.songTimeCallBack = songTimeCallBack;
    }
}
