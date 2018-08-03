package gregoryfournier.com.dailywtf.view.article


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import gregoryfournier.com.dailywtf.R
import gregoryfournier.com.dailywtf.system.data.Article
import kotlinx.android.synthetic.main.fragment_article.view.*
import org.jsoup.Jsoup

/**
 * A simple [Fragment] subclass.
 *
 */
class ArticleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_article, container, false)
        val article = activity?.intent?.extras?.getParcelable<Article>(ARTICLE)
        if (article != null) {
            // TODO Display Article
            view.title.text = article.title
            view.body.text = Jsoup.parse(article.bodyHtml).text()
        }

        return view
    }

    companion object {
        const val ARTICLE = "ARTICLE"
    }


}
