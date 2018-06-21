package com.shopkeeper.angady.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import angady.com.customer.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shyam on 2/19/2018.
 */

public class ResetPasswordEnterMobileFragment extends Fragment {
@BindView(R.id.input_mobile)
    EditText _mobileText;
ActivityListener activityListener;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reset_password_enter_mobile, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_submit)
    public void clickOnSubmit(){
        String mobileNumber = _mobileText.getText().toString().trim();
        if(mobileNumber.length() > 0 && mobileNumber.length() == 10){
            _mobileText.setError(null);
            ((ActivityListener)getActivity()).displayOtpPage(mobileNumber);
        }
        else{
            _mobileText.setError("Invalid Mobile Number");
        }

    }
   public interface ActivityListener{
        void displayOtpPage(String mobileNumber);
        void resetPasswordResult(Boolean flag);
    }
}
