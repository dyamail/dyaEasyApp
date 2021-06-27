package com.example.dyamail.customviewdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dyamail.customviewdemo.adapter.FragmentInfo;
import com.example.dyamail.customviewdemo.adapter.ViewPagerAdapter;
import com.example.dyamail.customviewdemo.fragment.HartFragment;
import com.example.dyamail.customviewdemo.fragment.HistogramFragment;
import com.example.dyamail.customviewdemo.fragment.RingFragment;
import com.example.dyamail.customviewdemo.fragment.SectorFragment;
import com.example.dyamail.customviewdemo.fragment.TestFragment;
import com.example.dyamail.customviewdemo.view.SeekBarAndText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tablayout;
    private ViewPager viewpager;
    private SeekBarAndText mSeekBarAndText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        viewpager = (ViewPager) findViewById(R.id.viewPage);
        mSeekBarAndText= (SeekBarAndText) findViewById(R.id.music_seek_bar);
        mSeekBarAndText.setSongTimeCallBack(new SeekBarAndText.SongTimeCallBack() {
            @Override
            public String getSongTime(int progress) {
                return progress+"222 ";
            }

            @Override
            public String getDrawText() {
                return "/1000";
            }
        });
        initTabLayout();
    }

    private void initTabLayout() {
        PagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), initFragments());
        viewpager.setOffscreenPageLimit(adapter.getCount());
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
    }


    private List<FragmentInfo> initFragments() {
        List<FragmentInfo> list = new ArrayList<>();
        list.add(new FragmentInfo("练习", TestFragment.class));
        list.add(new FragmentInfo("直方图", HistogramFragment.class));
        list.add(new FragmentInfo("扇形图", SectorFragment.class));
        list.add(new FragmentInfo("圆环图", RingFragment.class));
        list.add(new FragmentInfo("画心形", HartFragment.class));
        return list;
    }
}
