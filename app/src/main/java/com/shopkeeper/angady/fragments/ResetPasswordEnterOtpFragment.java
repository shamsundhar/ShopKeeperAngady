package com.shopkeeper.angady.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import angady.com.customer.ForgotPasswordActivity;
import angady.com.customer.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static angady.com.customer.utils.Constants.BUNDLE_KEY_MOBILE_NUMBER;

/**
 * Created by shyam on 2/19/2018.
 */

public class ResetPasswordEnterOtpFragment extends Fragment {
    ResetPasswordEnterMobileFragment.ActivityListener activityListener;
    @BindView(R.id.otp_mobile_number_message)
    TextView otp_mobile_number_message;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_password_enter_otp, null);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activityListener = (ForgotPasswordActivity)getActivity();
    }
    @OnClick(R.id.btn_validate)
    public void clickOnValidate(){
        activityListener.resetPasswordResult(true);
    }
    private void initData(){
        Resources res = getResources();
        Bundle bundle = this.getArguments();
        if(bundle != null){
            String text = String.format(res.getString(R.string.otp_mobile_number_message),  bundle.get(BUNDLE_KEY_MOBILE_NUMBER));
            CharSequence styledText = Html.fromHtml(text);
            otp_mobile_number_message.setText(styledText);
        }

    }
}
