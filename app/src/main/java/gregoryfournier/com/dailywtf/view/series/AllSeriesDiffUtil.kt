package gregoryfournier.com.dailywtf.view.series

import android.support.v7.util.DiffUtil
import gregoryfournier.com.dailywtf.system.data.Series

class AllSeriesDiffUtil : DiffUtil.ItemCallback<Series>() {
    override fun areItemsTheSame(oldItem: Series?, newItem: Series?): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Series?, newItem: Series?): Boolean {
        return false
    }
}
