package ir.hosseinabbasi.livestyled.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import butterknife.Unbinder
import ir.hosseinabbasi.livestyled.MyApplication
import ir.hosseinabbasi.livestyled.R
import ir.hosseinabbasi.livestyled.data.db.RealmManager
import ir.hosseinabbasi.livestyled.di.component.ActivityComponent
import ir.hosseinabbasi.livestyled.di.component.DaggerActivityComponent
import ir.hosseinabbasi.livestyled.di.module.ActivityModule
import ir.hosseinabbasi.livestyled.utils.CommonUtils
import ir.hosseinabbasi.livestyled.utils.NetworkUtils
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/15.
 */
abstract class BaseActivity : AppCompatActivity(), IBaseView, BaseFragment.Callback {

    @Inject
    lateinit var mRealmManager: RealmManager

    private var mProgressDialog: ProgressDialog? = null
    lateinit var activityComponent: ActivityComponent
        private set
    private var mUnBinder: Unbinder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .applicationComponent((application as MyApplication).applicationComponent)
                .build()

        activityComponent.inject(this)
        mRealmManager.openLocalInstance()
    }

    override fun showLoading() {
        hideLoading()
        mProgressDialog = CommonUtils.showLoadingDialog(this)
    }

    override fun hideLoading() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog!!.cancel()
        }
    }

    override fun onError(message: String?) {
        if (message != null) showSnackBar(message)
        else showSnackBar(getString(R.string.error_unknown))
    }

    private fun showSnackBar(message: String) {
        val snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_LONG)
        val sbView = snackbar.view
        val textView = sbView
                .findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        snackbar.show()
    }

    override fun onError(@StringRes resId: Int) {
        onError(getString(resId))
    }

    override fun isNetworkConnected(): Boolean {
        return NetworkUtils.isNetworkConnected(applicationContext)
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    fun setUnBinder(unBinder: Unbinder) {
        mUnBinder = unBinder
    }

    override fun onDestroy() {
        if (mUnBinder != null) {
            mUnBinder!!.unbind()
        }
        super.onDestroy()
    }
}