package ir.hosseinabbasi.livestyled.ui.base

import android.arch.lifecycle.Lifecycle
import android.os.Bundle


/**
 * Created by Dr.jacky on 2018/06/15.
 */
interface IBasePresenter<V : IBaseView, I : IBaseInteractor> {
    fun onAttach(baseView: V)
    fun onDetach()
    fun getView(): V?
    fun getInteractor(): I?
    fun isViewAttached(): Boolean
}