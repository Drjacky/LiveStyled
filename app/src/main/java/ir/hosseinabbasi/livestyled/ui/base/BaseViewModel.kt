package ir.hosseinabbasi.livestyled.ui.base

import android.arch.lifecycle.ViewModel

/**
 * Created by Dr.jacky on 6/26/2018.
 */
class BaseViewModel<V : IBaseView, I : IBaseInteractor, P : IBasePresenter<V, I>> : ViewModel() {

    private var presenter: P? = null

    fun setPresenter(presenter: P) {
        if (this.presenter == null) {
            this.presenter = presenter
        }
    }

    fun getPresenter(): P? {
        return this.presenter
    }
}