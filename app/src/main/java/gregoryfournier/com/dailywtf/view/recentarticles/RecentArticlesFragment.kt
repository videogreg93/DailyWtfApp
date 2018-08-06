package gregoryfournier.com.dailywtf.view.recentarticles


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import gregoryfournier.com.dailywtf.R
import gregoryfournier.com.dailywtf.system.data.Article
import gregoryfournier.com.dailywtf.view.article.ArticleFragment
import gregoryfournier.com.dailywtf.view.utils.ViewUtils
import kotlinx.android.synthetic.main.fragment_recent_articles.*
import kotlinx.android.synthetic.main.fragment_recent_articles.view.*


class RecentArticlesFragment : Fragment(), RecentArticlesContract.View, RecentArticlesAdapter.RecyclerViewClickListener {
    override lateinit var presenter: RecentArticlesContract.Presenter
    lateinit var recentArticlesAdapter: RecentArticlesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recent_articles, container, false)
        RecentArticlesPresenter(this)
        presenter.getRecentArticles()
        return view
    }

    override fun onGetRecentArticles(articles: List<Article>) {
        Log.d("RecentArticlesFragment", articles.get(0).toString())
        if (recent_articles is RecyclerView) {
            with(recent_articles) {
                recentArticlesAdapter = RecentArticlesAdapter(this@RecentArticlesFragment)
                layoutManager = LinearLayoutManager(context)
                adapter = recentArticlesAdapter
                recentArticlesAdapter.submitList(articles)
            }
        }
    }

    override fun doOnError(e: Exception) {
        e.printStackTrace()
    }

    override fun recyclerViewListClicked(articleView: View, position: Int) {
        if (articleView.tag is Article) {
            val article = articleView.tag as Article
            System.out.println(article.id)
            val bundle = Bundle()
            bundle.putParcelable(ArticleFragment.ARTICLE, article)
            ViewUtils.displayFragmentWithArgs(activity!!, ArticleFragment(),true, bundle)
        }
    }


}
