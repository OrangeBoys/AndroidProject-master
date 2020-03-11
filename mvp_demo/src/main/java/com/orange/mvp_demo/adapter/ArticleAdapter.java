package com.orange.mvp_demo.adapter;

import android.text.Html;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orange.mvp_demo.R;
import com.orange.mvp_demo.bean.Article;

import java.util.List;

/**
 * Time: 2020/3/11 10:06
 * <p>
 * Author: 橘子丶
 */
public class ArticleAdapter extends BaseQuickAdapter<Article.DataDetailBean, BaseViewHolder> {
    public ArticleAdapter(int layoutResId, @Nullable List<Article.DataDetailBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Article.DataDetailBean item) {
        //fromHtml，因为搜索结果中的title中含有html标签
        helper.setText(R.id.article_title, Html.fromHtml(item.title));
        helper.setText(R.id.article_chapter, item.chapterName);
        helper.setText(R.id.article_author, item.author);
        //设置收藏的点击事件
        helper.addOnClickListener(R.id.article_favorite);
        //先判断类型是不是收藏列表，因为收藏列表不返回item.collect字段，所以没法判断


        if (item.collect) {
            Glide.with(mContext).load(R.drawable.ic_like_checked).into((ImageView) helper.getView(R.id.article_favorite));

        } else {
            Glide.with(mContext).load(R.drawable.ic_like_normal).into((ImageView) helper.getView(R.id.article_favorite));
        }
    }
}
