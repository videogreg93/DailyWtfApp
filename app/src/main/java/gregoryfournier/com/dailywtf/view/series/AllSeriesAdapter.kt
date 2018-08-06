package gregoryfournier.com.dailywtf.view.series

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import gregoryfournier.com.dailywtf.R
import gregoryfournier.com.dailywtf.system.data.Series
import kotlinx.android.synthetic.main.view_series.view.*

class AllSeriesAdapter(val itemListener: RecyclerViewClickListener) : ListAdapter<Series, AllSeriesAdapter.ViewHolder>(AllSeriesDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_series, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val series = getItem(position)
        holder.titleView.text = series.title
        holder.summaryView.text = series.description


        with(holder.mView) {
            tag = series
        }

    }


    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView), View.OnClickListener {
        val titleView: TextView = mView.title
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