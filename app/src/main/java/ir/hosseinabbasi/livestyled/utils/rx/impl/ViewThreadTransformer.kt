package ir.hosseinabbasi.livestyled.utils.rx.impl

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import ir.hosseinabbasi.livestyled.utils.rx.ThreadTransformer
import ir.hosseinabbasi.livestyled.utils.rx.qualifiers.IOThreadPref
import ir.hosseinabbasi.livestyled.utils.rx.qualifiers.UIThreadPref
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/15.
 */
class ViewThreadTransformer @Inject
constructor(@param:IOThreadPref private val subscribeOnScheduler: Scheduler,
            @param:UIThreadPref private val observeOnScheduler: Scheduler) : ThreadTransformer {

    override fun <T> applySchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable -> observable.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler) }
    }
}
