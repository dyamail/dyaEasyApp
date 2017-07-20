package com.example.administrator.baselib.mvp;

import com.example.administrator.baselib.base.MvpView;
import com.example.administrator.baselib.retrofit.DiscountBean;

/**
 * Description:
 * Company    :
 * Author     : dyamail
 * Date       : 2017/7/14  15:35
 */
public interface MainView extends MvpView {
    void showLoading();

    void hideLoading();

    /**
     * 加载广告数据
     * @param newsBean 新闻
     */
    void loadAdData(DiscountBean newsBean);

}
