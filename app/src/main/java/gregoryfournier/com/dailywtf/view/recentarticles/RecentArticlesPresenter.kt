package gregoryfournier.com.dailywtf.view.recentarticles

import com.google.gson.JsonArray
import gregoryfournier.com.dailywtf.system.CoroutineContextProvider
import gregoryfournier.com.dailywtf.system.managers.DailyWtfApiService
import gregoryfournier.com.dailywtf.system.managers.Managers
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import kotlinx.coroutines.experimental.withContext
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class RecentArticlesPresenter(val myView: RecentArticlesContract.View,
                              override var manager: DailyWtfApiService = Managers.DailyWtfApiManager,
                              override var coroutineContext: CoroutineContextProvider = CoroutineContextProvider)
    : RecentArticlesContract.Presenter {

    init {
        myView.presenter = this
    }

    override fun getRecentArticles(count: Int) {
//        launch {
//            try {
//                val articles = async(coroutineContext.AndroidMain) {
//                    withContext(coroutineContext.Common) { manager.getRecentArticles("1").execute().body() }
//                }.await()
//                myView.onGetRecentArticles(articles!!)
//            } catch (e: Exception) {
//                myView.doOnError(e)
//            }
//        }
        try {
            manager.getRecentArticles("1").enqueue(object : retrofit2.Callback<JsonArray> {


                override fun onFailure(call: Call<JsonArray>?, t: Throwable?) {
                    myView.doOnError(t as Exception)
                }

                override fun onResponse(call: Call<JsonArray>?, response: Response<JsonArray>?) {
                    if (response != null) {
                        myView.onGetRecentArticles(response.body()!!)
                    }
                }

            })

        } catch (e: Exception) {
            myView.doOnError(e)
        }
    }
}

