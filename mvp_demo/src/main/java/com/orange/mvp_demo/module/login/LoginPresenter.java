package com.orange.mvp_demo.module.login;

import com.orange.mvp_demo.base.BaseBean;
import com.orange.mvp_demo.base.BaseObserver;
import com.orange.mvp_demo.base.BasePresenter;
import com.orange.mvp_demo.bean.User;

/**
 * Time: 2020/3/11 9:34
 * <p>
 * Author: 橘子丶
 */
public class LoginPresenter extends BasePresenter<ILoginView> {

    public LoginPresenter(ILoginView baseView) {
        super(baseView);
    }

    void login(String mUsername, String mPassword) {
        addDisposable(apiServer.login(mUsername, mPassword), new BaseObserver<BaseBean<User>>(baseView, true) {

            @Override
            public void onSuccess(BaseBean<User> bean) {
                baseView.showLoginSuccess("登录成功（￣▽￣）");
                baseView.doSuccess(bean);
            }

            @Override
            public void onError(String msg) {
                baseView.showLoginFailed(msg + "(°∀°)ﾉ");
            }
        });
    }
}
