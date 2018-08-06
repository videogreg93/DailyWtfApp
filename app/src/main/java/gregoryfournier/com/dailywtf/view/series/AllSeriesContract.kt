package gregoryfournier.com.dailywtf.view.series

import gregoryfournier.com.dailywtf.system.data.Series
import gregoryfournier.com.dailywtf.system.managers.DailyWtfApiService
import gregoryfournier.com.dailywtf.view.base.BasePresenter
import gregoryfournier.com.dailywtf.view.base.BaseView

class AllSeriesContract {
    interface View : BaseView<Presenter> {
        fun onGetAllSeries(series: ArrayList<Series>)
        fun doOnError(error: Exception)
    }

    interface Presenter : BasePresenter<DailyWtfApiService> {
        fun getAllSeries()
    }
}