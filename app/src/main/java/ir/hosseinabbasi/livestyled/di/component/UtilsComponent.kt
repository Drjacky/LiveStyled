package ir.hosseinabbasi.livestyled.di.component

import ir.hosseinabbasi.livestyled.utils.rx.ThreadTransformer

/**
 * Created by Dr.jacky on 2018/06/15.
 */
interface UtilsComponent {
    fun exposeThreadTransformer(): ThreadTransformer
}