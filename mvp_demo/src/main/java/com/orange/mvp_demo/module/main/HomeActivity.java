package com.orange.mvp_demo.module.main;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orange.mvp_demo.R;
import com.orange.mvp_demo.adapter.ArticleAdapter;
import com.orange.mvp_demo.base.BaseActivity;
import com.orange.mvp_demo.base.BaseBean;
import com.orange.mvp_demo.bean.Article;
import com.yechaoa.yutils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseActivity<HomePresenter> implements IHomeView, BaseQuickAdapter.OnItemChildClickListener {
    private RecyclerView                 mHomeRecyclerView;
    private ArticleAdapter               mArticleAdapter;
    private List<Article.DataDetailBean> mArticles = new ArrayList<>();
    private int                          mPosition;

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        mHomeRecyclerView = findViewById(R.id.home_recycler_view);

        mHomeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter.getArticleList();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void initData() {

    }

    @Override
    public void setArticleData(BaseBean<Article> list) {
        mArticles = list.data.datas;
        mArticleAdapter = new ArticleAdapter(R.layout.item_article_list, list.data.datas);
        mHomeRecyclerView.setAdapter(mArticleAdapter);
        mArticleAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void showArticleError(String errorMessage) {

    }

    @Override
    public void showCollectSuccess(String successMessage) {
        ToastUtil.showToast(successMessage);
        mArticles.get(mPosition).collect = true;
        //因为收藏成功，所以要刷新界面，以显示小红心
        mArticleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showCollectError(String errorMessage) {
        ToastUtil.showToast(errorMessage);
    }

    @Override
    public void showUncollectSuccess(String successMessage) {
        ToastUtil.showToast(successMessage);
        mArticles.get(mPosition).collect = false;
        //因为取消收藏成功，所以要刷新界面，以取消显示小红心
        mArticleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showUncollectError(String errorMessage) {
        ToastUtil.showToast(errorMessage);

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (view.getId() == R.id.article_favorite) {
            mPosition = position;
            if (mArticles.get(position).collect) {
                presenter.uncollect(mArticles.get(position).id);
            } else {
                presenter.collect(mArticles.get(position).id);
            }
        }
    }
}
