package ir.hosseinabbasi.livestyled.ui.base

import android.support.annotation.StringRes

/**
 * Created by Dr.jacky on 2018/06/15.
 */
interface IBaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(@StringRes resId: Int)
    fun onError(message: String?)
    fun isNetworkConnected(): Boolean
}