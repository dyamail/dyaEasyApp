package com.example.administrator.baselib.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.baselib.R;
import com.example.administrator.baselib.bean.RecycleSelect;

import java.util.List;

/**
 * Description:
 * Company    :
 * Author     : dyamail
 * Date       : 2017/7/25  16:37
 */
public class RecySelectAdapter extends BaseQuickAdapter<RecycleSelect, BaseViewHolder> {

    private boolean isShow = false;
    private OnItemListener mOnItemListener;

    public RecySelectAdapter(@LayoutRes int layoutResId, @Nullable List<RecycleSelect> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final RecycleSelect item) {
        TextView tv = helper.getView(R.id.tv_name);
        final CheckBox checkBox = helper.getView(R.id.item_check);
        tv.setText(item.getName() + "position===" + helper.getLayoutPosition());
        if (isShow) {
            checkBox.setVisibility(View.VISIBLE);
        } else {
            checkBox.setVisibility(View.GONE);
        }
        checkBox.setChecked(item.isCheck);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                item.isCheck = checkBox.isChecked();
                mOnItemListener.checkBoxClick(helper.getLayoutPosition());
            }
        });
    }

    public void setShow(boolean isShow) {
        this.isShow = isShow;
        notifyDataSetChanged();
    }

    public void setOnItemListener(OnItemListener onItemListener) {
        this.mOnItemListener = onItemListener;
    }

    public interface OnItemListener {
        void checkBoxClick(int position);
    }

}
