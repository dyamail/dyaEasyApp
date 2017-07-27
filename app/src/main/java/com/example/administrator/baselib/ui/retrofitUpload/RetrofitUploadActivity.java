package com.example.administrator.baselib.ui.retrofitUpload;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.administrator.baselib.R;
import com.example.administrator.baselib.base.MvpActivity;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class RetrofitUploadActivity extends MvpActivity<retroUploadPresenterImpl> implements retroUploadView {
    String imagePath = "/storage/emulated/0/yydb/1501050100664.jpg";
    @Bind(R.id.upload_image)
    Button uploadImage;

    private String uploadUrl = "img/36xmqOQyA93D6Cc3OaXijmtfqNn_Le3DJC-HtFi_6vg/img.do";


    @Override
    protected void beforeInit() {

    }

    @Override
    protected retroUploadPresenterImpl createPresenter() {
        return new retroUploadPresenterImpl();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_retrofit_upload;
    }

    @OnClick(R.id.upload_image)
    public void onViewClicked() {
        File file = new File(imagePath);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("uploaded_file", file.getName(), requestFile);
        mPresenter.retroUploadImage(uploadUrl,body);
    }


}
