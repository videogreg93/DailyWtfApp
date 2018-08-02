package gregoryfournier.com.dailywtf.system

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

object CoroutineContextProvider {
    val AndroidMain: CoroutineContext by lazy { UI }
    val Common: CoroutineContext by lazy { CommonPool }
}