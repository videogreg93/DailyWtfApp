package gregoryfournier.com.dailywtf.view.about


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import gregoryfournier.com.dailywtf.R
import kotlinx.android.synthetic.main.fragment_about.view.*
import android.content.Intent
import android.net.Uri


class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        view.submit_wtf.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.about_submit_url)))
            startActivity(browserIntent)
        }
        return view
    }


}
