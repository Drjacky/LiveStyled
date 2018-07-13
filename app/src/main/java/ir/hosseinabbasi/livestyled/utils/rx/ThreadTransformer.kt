package ir.hosseinabbasi.livestyled.utils.rx

import io.reactivex.ObservableTransformer

/**
 * Created by Dr.jacky on 2018/06/15.
 */
interface ThreadTransformer {
    fun <T> applySchedulers(): ObservableTransformer<T, T>
}
