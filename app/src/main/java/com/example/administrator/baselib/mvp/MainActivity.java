package com.example.administrator.baselib.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.baselib.R;
import com.example.administrator.baselib.base.MvpActivity;
import com.example.administrator.baselib.retrofit.DiscountBean;
import com.example.administrator.baselib.ui.CustomActivity;
import com.example.administrator.baselib.ui.ObjectAnimatorActivity;
import com.example.administrator.baselib.ui.RecycleSelectActivity;
import com.example.administrator.baselib.ui.retrofitUpload.RetrofitUploadActivity;
import com.gyf.barlibrary.ImmersionBar;
import com.vlonjatg.progressactivity.ProgressLinearLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<MainPresenterImpl> implements MainView {

    @Bind(R.id.et_login_account)
    EditText etLoginAccount;
    @Bind(R.id.et_login_pwd)
    EditText etLoginPwd;
    @Bind(R.id.btn_login_login)
    Button btnLoginLogin;
    @Bind(R.id.progress_bar_loading)
    ProgressLinearLayout progressBarLoading;
    @Bind(R.id.toolbar_me)
    Toolbar toolbar;
    @Bind(R.id.main_text)
    TextView mainText;
    @Bind(R.id.start_intent)
    Button startIntent;
    @Bind(R.id.start_select)
    Button startSelect;
    @Bind(R.id.start_upload)
    Button startUpload;
    @Bind(R.id.start_custom)
    Button startCustom;


    @Override
    protected void beforeInit() {
        ImmersionBar.with(this).titleBar(toolbar).init();
        EventBus.getDefault().register(this);
    }


    @Override
    protected MainPresenterImpl createPresenter() {
        return new MainPresenterImpl();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }


    @Override
    public void showLoading() {

        progressBarLoading.showLoading();
    }

    @Override
    public void hideLoading() {
        progressBarLoading.showEmpty(R.mipmap.ic_launcher, "暂时没有数据", "去死吧");
    }

    @Override
    public void loadAdData(DiscountBean newsBean) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if (event.code == 0) {
            mainText.setText("发过来的0");
        } else if (event.code == 5) {
            mainText.setText("发过来的5");
        } else {
            mainText.setText("发过来的其他");
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login_login, R.id.start_intent, R.id.start_select, R.id.start_upload, R.id.start_custom, R.id.start_anim})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login_login:
                mPresenter.userLogin(MainActivity.this, "", "");
                break;
            case R.id.start_intent:
                startActivity(new Intent(this, EventBusAct.class));
                break;
            case R.id.start_select:
                startActivity(new Intent(this, RecycleSelectActivity.class));
                break;
            case R.id.start_upload:
                startActivity(new Intent(this, RetrofitUploadActivity.class));
                break;
            case R.id.start_custom:
                startActivity(new Intent(this, CustomActivity.class));
                break;
            case R.id.start_anim:
                startActivity(new Intent(this, ObjectAnimatorActivity.class));
                break;
        }
    }

    @OnClick(R.id.start_custom)
    public void onViewClicked() {
    }
}
