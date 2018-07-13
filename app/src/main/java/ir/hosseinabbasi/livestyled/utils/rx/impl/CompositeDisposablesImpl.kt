package ir.hosseinabbasi.livestyled.utils.rx.impl

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ir.hosseinabbasi.livestyled.utils.rx.RxDisposables
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/15.
 */
class CompositeDisposablesImpl @Inject
constructor() : RxDisposables {

    var compositeDisposable = CompositeDisposable()

    override fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun clear() {
        compositeDisposable.clear()
    }
}
