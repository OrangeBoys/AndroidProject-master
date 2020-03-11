package com.orange.mvp_demo.module.register;


import android.text.Editable;
import android.text.TextWatcher;

import com.google.android.material.textfield.TextInputLayout;
import com.orange.mvp_demo.module.login.LoginTextWatcher;

/**
 * created by xucanyou666
 * on 2020/2/8 14:07
 * email：913710642@qq.com
 */
class RegisterTextWatcher implements TextWatcher {
    TextInputLayout mTilUsername;
    TextInputLayout mTilPassword;
    TextInputLayout mTilRepassword;

    RegisterTextWatcher(TextInputLayout username, TextInputLayout password, TextInputLayout rePassword) {
        mTilUsername = username;
        mTilPassword = password;
        mTilRepassword = rePassword;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        LoginTextWatcher.checkInput(mTilUsername);
        LoginTextWatcher.checkInput(mTilPassword);
        LoginTextWatcher.checkInput(mTilRepassword);
    }
}
