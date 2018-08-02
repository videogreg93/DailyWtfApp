package gregoryfournier.com.dailywtf.view.recentarticles


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.JsonArray

import gregoryfournier.com.dailywtf.R
import org.json.JSONArray


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

    override fun onGetRecentArticles(articles: JsonArray) {
        Log.d("RecentArticlesFragment", articles.toString())
    }

    override fun doOnError(e: Exception) {
        e.printStackTrace()
    }


}
