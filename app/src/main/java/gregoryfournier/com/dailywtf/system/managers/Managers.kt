package gregoryfournier.com.dailywtf.system.managers

import android.content.Context

internal object Managers {

    lateinit var DailyWtfApiManager: DailyWtfApiService

    fun initMainServices(context: Context) {
        DailyWtfApiManager = DailyWtfApiService.createService()
    }
}