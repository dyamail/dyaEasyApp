package com.example.administrator.baselib.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.baselib.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusAct extends AppCompatActivity {

    @Bind(R.id.send_post)
    Button sendPost;
    @Bind(R.id.send_post_one)
    Button sendPostOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.send_post, R.id.send_post_one})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.send_post:
                EventBus.getDefault().post(new MessageEvent(0));
                break;
            case R.id.send_post_one:
                EventBus.getDefault().post(new MessageEvent(5));
                break;
        }
    }
}
