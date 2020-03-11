package com.orange.mvp_demo.module.login;

import com.orange.mvp_demo.base.BaseBean;
import com.orange.mvp_demo.base.BaseView;
import com.orange.mvp_demo.bean.User;

/**
 * Time: 2020/3/11 9:34
 * <p>
 * Author: 橘子丶
 */
public interface ILoginView extends BaseView {

    /**
     * 显示登陆成功
     *
     * @param successMessage 成功信息
     */
    void showLoginSuccess(String successMessage);

    /**
     * 显示登陆失败
     *
     * @param errorMessage 失败信息
     */
    void showLoginFailed(String errorMessage);

    void doSuccess(BaseBean<User> user);


}
