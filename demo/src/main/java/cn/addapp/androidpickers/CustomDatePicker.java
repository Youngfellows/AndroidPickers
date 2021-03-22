package cn.addapp.androidpickers;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import cn.addapp.androidpicker.R;
import cn.addapp.pickers.picker.DatePicker;

/**
 * 自定义布局
 */
public class CustomDatePicker extends DatePicker {
    View topView;
    View bottomView;
    TextView tvTitle;
    TextView tvDone;
    TextView tvOk;
    String title;
    String confirm;


    public CustomDatePicker(Activity activity) {
        super(activity);
        initTopView();
        initBottomView();
    }

    public CustomDatePicker(Activity activity, int mode) {
        super(activity, mode);
        initTopView();
        initBottomView();
    }

    @Nullable
    @Override
    protected View makeFooterView() {
        if (null == bottomView) {
            return super.makeFooterView();
        } else {
            return bottomView;
        }
    }

    @NonNull
    @Override
    protected View makeCenterView() {
        return super.makeCenterView();
    }

    @Nullable
    @Override
    protected View makeHeaderView() {
        setTopLineVisible(false);
        if (null == topView) {
            return super.makeHeaderView();
        } else {
            return topView;
        }

    }

    private void initTopView() {
        topView = LayoutInflater.from(getContext()).inflate(R.layout.layout_dialog_top_button, null);
        tvTitle = topView.findViewById(R.id.tv_title);
        tvOk = topView.findViewById(R.id.tv_right);

        tvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmit();
            }
        });
    }

    private void initBottomView() {
        bottomView = LayoutInflater.from(getContext()).inflate(R.layout.layout_dialog_bottom_button, null);
        tvDone = bottomView.findViewById(R.id.tv_done);
        tvDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmit();
            }
        });
    }

    @Override
    protected void onSubmit() {
        super.onSubmit();
        this.dismiss();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        if (null != tvTitle)
            tvTitle.setText(title);
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
        if (null != tvTitle)
            tvOk.setText(confirm);
    }
}
