package gregoryfournier.com.dailywtf

import android.app.Application
import gregoryfournier.com.dailywtf.system.managers.Managers

class DailyWtfApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Managers.initMainServices(this)
    }
}