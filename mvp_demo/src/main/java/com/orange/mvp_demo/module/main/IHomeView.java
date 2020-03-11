package com.orange.mvp_demo.module.main;

import com.orange.mvp_demo.base.BaseBean;
import com.orange.mvp_demo.base.BaseView;
import com.orange.mvp_demo.bean.Article;

/**
 * Time: 2020/3/11 9:55
 * <p>
 * Author: 橘子丶
 */
public interface IHomeView extends BaseView {
    /**
     * 设置文章数据
     *
     * @param list 文章list
     */
    void setArticleData(BaseBean<Article> list);

    /**
     * 显示文章失败
     *
     * @param errorMessage 失败信息
     */
    void showArticleError(String errorMessage);

    /**
     * 显示收藏成功
     *
     * @param successMessage 成功信息
     */
    void showCollectSuccess(String successMessage);

    /**
     * 显示收藏失败
     *
     * @param errorMessage 失败信息
     */
    void showCollectError(String errorMessage);

    /**
     * 显示未收藏成功
     *
     * @param successMessage 成功信息
     */
    void showUncollectSuccess(String successMessage);

    /**
     * 显示未收藏失败
     *
     * @param errorMessage 失败信息
     */
    void showUncollectError(String errorMessage);
}
