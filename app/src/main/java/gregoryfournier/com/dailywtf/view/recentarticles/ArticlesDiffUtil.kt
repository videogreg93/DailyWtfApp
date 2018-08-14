package gregoryfournier.com.dailywtf.view.recentarticles

import android.support.v7.util.DiffUtil
import gregoryfournier.com.dailywtf.system.data.Article

/**
 * We always wont to refresh the articles when we submit, for now
 */
class ArticlesDiffUtil : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article?, newItem: Article?): Boolean {
        return areTheSame(oldItem,newItem)
    }

    override fun areContentsTheSame(oldItem: Article?, newItem: Article?): Boolean {
        return areTheSame(oldItem,newItem)
    }

    private fun areTheSame(oldItem: Article?, newItem: Article?): Boolean {
        if (oldItem != null && newItem != null) {
            return oldItem.equals(newItem)
        } else {
            return false
        }
    }
}