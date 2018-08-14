package gregoryfournier.com.dailywtf.view.recentarticles

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import gregoryfournier.com.dailywtf.R
import gregoryfournier.com.dailywtf.system.data.Article
import kotlinx.android.synthetic.main.view_recent_article.view.*
import org.jsoup.Jsoup

class RecentArticlesAdapter(val itemListener: RecyclerViewClickListener) : ListAdapter<Article, RecentArticlesAdapter.ViewHolder>(ArticlesDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_recent_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = getItem(position)
        holder.titleView.text = article.title
        holder.authorView.text = "by ${article.author.firstName}"
        holder.summaryView.text = Jsoup.parse(article.summaryHtml).text()

        with(holder.mView) {
            tag = article
        }
    }



    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView), View.OnClickListener {
        val titleView: TextView = mView.title
        val authorView: TextView = mView.author
        val summaryView: TextView = mView.summary

        init {
            mView.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            if (view != null) {
                itemListener.recyclerViewListClicked(view, this.adapterPosition)
            }
        }

        override fun toString(): String {
            return super.toString() + " '" + summaryView.text + "'"
        }
    }

    interface RecyclerViewClickListener {
        fun recyclerViewListClicked(v: View, position: Int)
    }
}