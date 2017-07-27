package com.example.administrator.baselib.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.baselib.R;
import com.example.administrator.baselib.util.ToastUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ObjectAnimatorActivity extends AppCompatActivity {

    @Bind(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        ButterKnife.bind(this);
        ObjectAnimator animator = ObjectAnimator.ofFloat(image, "scaleX", 1f, 6f, 1f, 6f);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setDuration(6000);
//        animator.start();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(image, "alpha", 1, 0, 1, 0);
        final AnimatorSet set = new AnimatorSet();
        set.play(animator).with(animator1);
        set.setDuration(2000);
        set.start();
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                image.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @OnClick(R.id.image)
    public void onViewClicked() {
        ToastUtils.showShort("你点到我了");
    }
}
