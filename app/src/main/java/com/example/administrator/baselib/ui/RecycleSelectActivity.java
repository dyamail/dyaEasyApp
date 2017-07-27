package com.example.administrator.baselib.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.baselib.R;
import com.example.administrator.baselib.adapter.RecySelectAdapter;
import com.example.administrator.baselib.bean.RecycleSelect;
import com.example.administrator.baselib.util.ToastUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecycleSelectActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    @Bind(R.id.btn_compile)
    CheckBox btnCompile;
    @Bind(R.id.btn_all)
    CheckBox btnAll;
    @Bind(R.id.recycle)
    RecyclerView recycle;
    @Bind(R.id.action0)
    Button action0;
    @Bind(R.id.action1)
    Button action1;
    private HashSet<Integer> positionSet = new HashSet<>();
    private RecySelectAdapter adapter;
    private List<RecycleSelect> recycleSelects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_select);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        btnCompile.setOnCheckedChangeListener(this);
        btnAll.setOnCheckedChangeListener(this);
        for (int i = 0; i < 30; i++) {
            RecycleSelect select = new RecycleSelect();
            select.setName("这是测试数据");
            recycleSelects.add(select);
        }
        adapter = new RecySelectAdapter(R.layout.item_recy_select, recycleSelects);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycle.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recycle.setLayoutManager(manager);
        recycle.setAdapter(adapter);
        adapter.setOnItemListener(new RecySelectAdapter.OnItemListener() {
            @Override
            public void checkBoxClick(int position) {
                addOrRemove(position);
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.setBgColor(getResources().getColor(R.color.colorPrimary));
                ToastUtils.showShort("position====" + position);
            }
        });
    }

    private void addOrRemove(int position) {

        if (positionSet.contains(position)) {
            // 如果包含，则撤销选择
            positionSet.remove(position);
        } else {
            // 如果不包含，则添加
            positionSet.add(position);
        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.btn_compile:
                for (int i = 0; i < recycleSelects.size(); i++) {
                    recycleSelects.get(i).isCheck = false;
                }
                if (b) {
                    adapter.setShow(true);
                } else {
                    adapter.setShow(false);
                }
                break;
            case R.id.btn_all:
                if (b) {
                    for (int i = 0; i < recycleSelects.size(); i++) {
                        recycleSelects.get(i).isCheck = true;
                        positionSet.add(i);
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    for (int i = 0; i < recycleSelects.size(); i++) {
                        recycleSelects.get(i).isCheck = false;
                        positionSet.remove(i);
                    }
                    adapter.notifyDataSetChanged();
                }
                break;
        }
    }

    @OnClick({R.id.action0, R.id.action1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.action0:
                HashSet<RecycleSelect> hashSet = new HashSet<>();
                for (Integer next : positionSet) {
                    hashSet.add(adapter.getItem(next));
                }
                recycleSelects.removeAll(hashSet);
                adapter.notifyDataSetChanged();
                positionSet.clear();
                break;

            case R.id.action1:
                RecycleSelect recycleSelect = new RecycleSelect();
                recycleSelect.setName("这是新加的数据");
                recycleSelects.add(0, recycleSelect);
                adapter.notifyItemInserted(0);
                recycle.scrollToPosition(0);

                break;
        }
    }
}
