package gregoryfournier.com.dailywtf.view.recentarticles


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import gregoryfournier.com.dailywtf.R
import gregoryfournier.com.dailywtf.system.data.Article


class RecentArticlesFragment : Fragment(), RecentArticlesContract.View {

    override lateinit var presenter: RecentArticlesContract.Presenter

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
    }

    override fun doOnError(e: Exception) {
        e.printStackTrace()
    }


}
