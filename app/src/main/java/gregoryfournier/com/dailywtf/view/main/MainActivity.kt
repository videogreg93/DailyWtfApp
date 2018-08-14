package gregoryfournier.com.dailywtf.view.main

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import gregoryfournier.com.dailywtf.R
import gregoryfournier.com.dailywtf.view.about.AboutFragment
import gregoryfournier.com.dailywtf.view.recentarticles.RecentArticlesFragment
import gregoryfournier.com.dailywtf.view.series.AllSeriesFragment
import gregoryfournier.com.dailywtf.view.utils.ViewUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        ViewUtils.displayFragmentWithoutArgs(this, RecentArticlesFragment(),false)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> {
                ViewUtils.displayFragmentWithoutArgs(this,AboutFragment(), true)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.recent_articles -> {
                ViewUtils.displayFragmentWithoutArgs(this, RecentArticlesFragment(),true)
            }
            R.id.featured_articles -> {
                viewSeries(getString(R.string.slug_feature_articles))
            }
            R.id.code_sod -> {
                viewSeries(getString(R.string.slug_code_sod))
            }
            R.id.errord -> {
                viewSeries(getString(R.string.slug_errord))
            }
            R.id.other_articles -> {
                ViewUtils.displayFragmentWithoutArgs(this,AllSeriesFragment(),true)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun viewSeries(series: String) {
        val bundle = Bundle()
        bundle.putString(RecentArticlesFragment.SERIES, series)
        ViewUtils.displayFragmentWithArgs(this, RecentArticlesFragment(), true, bundle)
    }
}
