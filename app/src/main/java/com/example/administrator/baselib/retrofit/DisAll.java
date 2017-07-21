package com.example.administrator.baselib.retrofit;

import java.util.List;

/**
 * Description:
 * Company    :
 * Author     : dyamail
 * Date       : 2017/7/21  19:02
 */
public class DisAll extends Response{

    private List<DiscountBean> data;

    public List<DiscountBean> getData() {
        return data;
    }

    public void setData(List<DiscountBean> data) {
        this.data = data;
    }
}
