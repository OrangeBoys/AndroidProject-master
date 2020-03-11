package com.orange.mvp_demo.module.register;

import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;
import com.orange.mvp_demo.R;
import com.orange.mvp_demo.base.BaseActivity;
import com.orange.mvp_demo.base.BaseBean;
import com.orange.mvp_demo.bean.User;
import com.yechaoa.yutils.ToastUtil;
import com.yechaoa.yutils.YUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description : RegisterActivity
 *
 * @author XuCanyou666
 * @date 2020/2/8
 */


public class RegisterActivity extends BaseActivity<RegisterPresenter> implements IRegisterView {

    @BindView(R.id.et_username)
    EditText        mEtUsername;
    @BindView(R.id.til_username)
    TextInputLayout mTilUsername;
    @BindView(R.id.et_password)
    EditText        mEtPassword;
    @BindView(R.id.til_password)
    TextInputLayout mTilPassword;
    @BindView(R.id.et_repassword)
    EditText        mEtRepassword;
    @BindView(R.id.til_repassword)
    TextInputLayout mTilRepassword;
    @BindView(R.id.btn_register)
    Button          mBtnRegister;
    private String mUsername, mPassword, mRepassword;

    @Override
    protected RegisterPresenter createPresenter() {
        return new RegisterPresenter(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        TextWatcher textWatcher = new RegisterTextWatcher(mTilUsername, mTilPassword, mTilRepassword);
        mEtUsername.addTextChangedListener(textWatcher);
        mEtPassword.addTextChangedListener(textWatcher);
        mEtRepassword.addTextChangedListener(textWatcher);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showRegisterSuccess(String successMessage) {
        ToastUtil.showToast(successMessage);
    }

    @Override
    public void showRegisterFailed(String errorMessage) {
        ToastUtil.showToast(errorMessage);

    }

    @Override
    public void doSuccess(BaseBean<User> user) {
        finish();
    }

    private boolean isUsernameValid() {
        mUsername = mEtUsername.getText().toString().trim();
        return !TextUtils.isEmpty(mUsername) && mUsername.length() <= mTilUsername.getCounterMaxLength() && mUsername.length() >= mTilUsername.getCounterMaxLength() / 2;
    }

    private boolean isPasswordValid() {
        mPassword = mEtPassword.getText().toString().trim();
        return !TextUtils.isEmpty(mPassword) && mPassword.length() <= mTilPassword.getCounterMaxLength() && mPassword.length() >= mTilPassword.getCounterMaxLength() / 2;
    }

    private boolean isRepasswordValid() {
        mRepassword = mEtRepassword.getText().toString().trim();
        return !TextUtils.isEmpty(mRepassword) && mRepassword.length() <= mTilRepassword.getCounterMaxLength() && mRepassword.length() >= mTilRepassword.getCounterMaxLength() / 2;
    }

    @OnClick(R.id.btn_register)
    public void onViewClicked() {
        YUtils.closeSoftKeyboard();
        if (isUsernameValid() && isPasswordValid() && isRepasswordValid()) {
            if (mPassword.equals(mRepassword)) {
                presenter.submit(mUsername, mPassword, mRepassword);
            } else {
                ToastUtil.showToast("两次密码不一样( ⊙ o ⊙ ) ");
            }
        } else {
            ToastUtil.showToast("填写错误 (°∀°)ﾉ");
        }

    }
}
