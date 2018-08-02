package gregoryfournier.com.dailywtf.view.base

import gregoryfournier.com.dailywtf.system.CoroutineContextProvider


interface BasePresenter<T> {
    var manager: T
    var coroutineContext: CoroutineContextProvider


}