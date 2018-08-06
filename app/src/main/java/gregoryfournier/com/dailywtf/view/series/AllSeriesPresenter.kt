package gregoryfournier.com.dailywtf.view.series

import com.google.gson.Gson
import gregoryfournier.com.dailywtf.system.CoroutineContextProvider
import gregoryfournier.com.dailywtf.system.data.Series
import gregoryfournier.com.dailywtf.system.managers.DailyWtfApiService
import gregoryfournier.com.dailywtf.system.managers.Managers
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext

class AllSeriesPresenter(val myView: AllSeriesContract.View,
                         override var manager: DailyWtfApiService = Managers.DailyWtfApiManager,
                         override var coroutineContext: CoroutineContextProvider = CoroutineContextProvider): AllSeriesContract.Presenter {
    init {
        myView.presenter = this
    }

    override fun getAllSeries() {
        launch(coroutineContext.AndroidMain) {
            try {
                val seriesJsonArray = async(coroutineContext.AndroidMain) {
                    withContext(coroutineContext.Common) { manager.getAllSeries().execute().body() }
                }.await()
                val series = ArrayList<Series>()
                for (item in seriesJsonArray!!) {
                    series.add(Series.FromJson(item.asJsonObject))
                }
                myView.onGetAllSeries(series)
            } catch (e: Exception) {
                myView.doOnError(e)
            }
        }
    }

}