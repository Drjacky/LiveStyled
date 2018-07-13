package ir.hosseinabbasi.livestyled.di.component

import ir.hosseinabbasi.livestyled.data.db.RealmManager
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/15.
 */
@Singleton
interface DataComponent {
    @Singleton
    fun exposeRealmManager(): RealmManager
}