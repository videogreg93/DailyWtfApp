package gregoryfournier.com.dailywtf.view.series


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import gregoryfournier.com.dailywtf.R
import gregoryfournier.com.dailywtf.system.data.Series
import gregoryfournier.com.dailywtf.view.recentarticles.RecentArticlesFragment
import gregoryfournier.com.dailywtf.view.utils.ViewUtils
import gregoryfournier.com.dailywtf.view.utils.showSnackBar
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_all_series.*


class AllSeriesFragment : Fragment(), AllSeriesContract.View, AllSeriesAdapter.RecyclerViewClickListener {
    override lateinit var presenter: AllSeriesContract.Presenter
    lateinit var allSeriesAdapter: AllSeriesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_all_series, container, false)
        AllSeriesPresenter(this)
        presenter.getAllSeries()
        return view
    }

    override fun onGetAllSeries(series: ArrayList<Series>) {
        if (all_series is RecyclerView) {
            with(all_series) {
                allSeriesAdapter = AllSeriesAdapter(this@AllSeriesFragment)
                layoutManager = android.support.v7.widget.LinearLayoutManager(context)
                adapter = allSeriesAdapter
                allSeriesAdapter.submitList(series)
            }
        }
    }

    override fun doOnError(error: Exception) {
        content.showSnackBar(getString(R.string.error_no_series), Toast.LENGTH_SHORT)
        error.printStackTrace()
    }

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun recyclerViewListClicked(seriesView: View, position: Int) {
        val series = seriesView.tag
        if (series is Series) {
            val bundle = Bundle()
            bundle.putString(RecentArticlesFragment.SERIES, series.slug)
            ViewUtils.displayFragmentWithArgs(activity!!, RecentArticlesFragment(), true, bundle)
        }
    }
}
