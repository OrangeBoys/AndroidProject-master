package com.orange.mvp_demo.module.register;

import com.orange.mvp_demo.base.BaseBean;
import com.orange.mvp_demo.base.BaseView;
import com.orange.mvp_demo.bean.User;

/**
 * Description : IRegisterView
 *
 * @author XuCanyou666
 * @date 2020/2/8
 */

public interface IRegisterView extends BaseView {

    /**
     * 显示注册成功
     *
     * @param successMessage
     */
    void showRegisterSuccess(String successMessage);

    /**
     * 显示注册失败
     *
     * @param errorMessage
     */
    void showRegisterFailed(String errorMessage);

    /**
     * 注册成功
     *
     * @param user
     */
    void doSuccess(BaseBean<User> user);

}
