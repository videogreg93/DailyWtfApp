package gregoryfournier.com.dailywtf.view.recentarticles

import gregoryfournier.com.dailywtf.system.data.Article
import gregoryfournier.com.dailywtf.system.managers.DailyWtfApiService
import gregoryfournier.com.dailywtf.view.base.BasePresenter
import gregoryfournier.com.dailywtf.view.base.BaseView


interface RecentArticlesContract {
    interface View : BaseView<Presenter> {
        fun onGetRecentArticles(articles: List<Article>)
        fun doOnError(e: Exception)
    }

    interface Presenter : BasePresenter<DailyWtfApiService> {
        fun getRecentArticles(count: Int = 8)
        fun getArticlesFromSeries(series: String,count: Int = 8)
    }
}