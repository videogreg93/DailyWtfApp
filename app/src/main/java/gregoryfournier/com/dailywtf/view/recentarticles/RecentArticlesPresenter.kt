package gregoryfournier.com.dailywtf.view.recentarticles

import com.google.gson.Gson
import gregoryfournier.com.dailywtf.system.CoroutineContextProvider
import gregoryfournier.com.dailywtf.system.data.Article
import gregoryfournier.com.dailywtf.system.managers.DailyWtfApiService
import gregoryfournier.com.dailywtf.system.managers.Managers
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class RecentArticlesPresenter(val myView: RecentArticlesContract.View,
                              override var manager: DailyWtfApiService = Managers.DailyWtfApiManager,
                              override var coroutineContext: CoroutineContextProvider = CoroutineContextProvider)
    : RecentArticlesContract.Presenter {

    init {
        myView.presenter = this
    }

    override fun getRecentArticles(count: Int) {
        launch(coroutineContext.AndroidMain) {
            try {
                val articlesJsonArray = async(coroutineContext.AndroidMain) {
                    withContext(coroutineContext.Common) { manager.getRecentArticles(count.toString()).execute().body() }
                }.await()
                val articles = ArrayList<Article>()
                for (item in articlesJsonArray!!) {
                    articles.add(Article.fromJson(item.asJsonObject))
                }
                myView.onGetRecentArticles(articles)
            } catch (e: Exception) {
                myView.doOnError(e)
            }
        }
    }
}

