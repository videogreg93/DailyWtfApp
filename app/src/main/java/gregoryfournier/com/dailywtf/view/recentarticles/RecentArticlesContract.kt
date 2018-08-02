package gregoryfournier.com.dailywtf.view.recentarticles

import com.google.gson.JsonArray
import gregoryfournier.com.dailywtf.system.managers.DailyWtfApiService
import gregoryfournier.com.dailywtf.view.base.BasePresenter
import gregoryfournier.com.dailywtf.view.base.BaseView


interface RecentArticlesContract {
    interface View : BaseView<Presenter> {
        fun onGetRecentArticles(articles: JsonArray)
        fun doOnError(e: Exception)
    }

    interface Presenter : BasePresenter<DailyWtfApiService> {
        fun getRecentArticles(count: Int = 8)
    }
}