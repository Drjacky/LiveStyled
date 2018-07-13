package ir.hosseinabbasi.livestyled.utils.rx

import ir.hosseinabbasi.livestyled.utils.rx.impl.CompositeDisposablesImpl
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/15.
 */
class RxDisposableFactory @Inject constructor() {
    fun get(): RxDisposables {
        return CompositeDisposablesImpl()
    }
}