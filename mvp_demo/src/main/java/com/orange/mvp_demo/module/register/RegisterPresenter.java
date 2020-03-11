package com.orange.mvp_demo.module.register;

import com.orange.mvp_demo.base.BaseBean;
import com.orange.mvp_demo.base.BaseObserver;
import com.orange.mvp_demo.base.BasePresenter;
import com.orange.mvp_demo.bean.User;

/**
 * Description : RegisterPresenter
 *
 * @author XuCanyou666
 * @date 2020/2/8
 */


class RegisterPresenter extends BasePresenter<IRegisterView> {

    RegisterPresenter(IRegisterView baseView) {
        super(baseView);
    }

    void submit(String username, String password, String repassword) {

        addDisposable(apiServer.register(username, password, repassword), new BaseObserver<BaseBean<User>>(baseView, true) {
            @Override
            public void onSuccess(BaseBean<User> bean) {
                baseView.showRegisterSuccess("注册成功（￣▽￣）");
                baseView.doSuccess(bean);
            }

            @Override
            public void onError(String msg) {
                baseView.showRegisterFailed(msg + "(°∀°)ﾉ");
            }
        });

    }
}
