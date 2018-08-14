package gregoryfournier.com.dailywtf.view.utils

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.View
import gregoryfournier.com.dailywtf.R


fun View.showSnackBar(message: String, duration: Int): Snackbar {
    val snackbar = Snackbar.make(this, message, duration)
    snackbar.show()
    return snackbar
}

fun View.showSnackBarButton(message: String, duration: Int, actionTitleResId: Int, action: View.OnClickListener): Snackbar {
    val snackbar = Snackbar.make(this, message, duration)
            .setAction(actionTitleResId, action)

    snackbar.show()
    return snackbar
}

fun View.showSnackBarButton(message: String, duration: Int, actionTitle: String, action: View.OnClickListener): Snackbar {
    val snackbar = Snackbar.make(this, message, duration)
            .setAction(actionTitle, action)
    snackbar.show()
    return snackbar
}

//TODO put in LLUIFOUNDATION when created
object ViewUtils {
    /**
     * Replace the current fragment without arguments
     *
     * @param fragmentToDisplay new fragment
     * @param addToBackStack    true if the new fragment should be added to the backstack
     */
    fun displayFragmentWithoutArgs(activity: FragmentActivity, fragmentToDisplay: Fragment, addToBackStack: Boolean) {
        val transaction = activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.content, fragmentToDisplay, fragmentToDisplay.javaClass.name)
        if (addToBackStack) {
            transaction.addToBackStack(fragmentToDisplay.javaClass.name)
        }
        transaction.commit()
    }


    /**
     * Replace the current fragment
     *
     * @param fragmentToDisplay new fragment
     * @param addToBackStack    true if the new fragment should be added to the backstack
     * @param args              fragment arguments
     */
    fun displayFragmentWithArgs(activity: FragmentActivity, fragmentToDisplay: Fragment, addToBackStack: Boolean, args: Bundle?) {
        fragmentToDisplay.arguments = args
        displayFragmentWithoutArgs(activity, fragmentToDisplay, addToBackStack)
    }

}
