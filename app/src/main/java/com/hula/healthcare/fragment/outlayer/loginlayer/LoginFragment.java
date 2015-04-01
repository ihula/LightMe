package com.hula.healthcare.fragment.outlayer.loginlayer;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hula.healthcare.MainActivity;
import com.hula.healthcare.R;


/**
 * 登录
 */
public class LoginFragment extends Fragment {


    public void initForm(final EditText et, final TextView tv, final ImageView iv) {
        et.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                if (TextUtils.isEmpty(arg0)) {
                    iv.setVisibility(View.INVISIBLE);
                    tv.setVisibility(View.VISIBLE);
                }
                else {
                    iv.setVisibility(View.VISIBLE);
                    tv.setVisibility(View.INVISIBLE);
                }
            }

        });
        iv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                et.setText("");
            }

        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_login, null);
        TextView tv_down = (TextView)view.findViewById(R.id.tv_down);
        tv_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoRankMe();
            }
        });

        EditText edtPassword = (EditText) view.findViewById(R.id.et_psw);
        ImageView ivLogin = (ImageView) view.findViewById(R.id.btn_login);
        TextView tvForgetPwd = (TextView) view.findViewById(R.id.tv_forgetpsw);
        initForm(edtPassword, tvForgetPwd, ivLogin);

        ivLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }

    /**
     * 下载有光
     */
    private void gotoRankMe() {
        try {
            Uri uri = Uri.parse("market://details?id=com.hula.lightme");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
        }
    }
}
