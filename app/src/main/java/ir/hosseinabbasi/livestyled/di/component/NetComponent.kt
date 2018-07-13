package ir.hosseinabbasi.livestyled.di.component

import ir.hosseinabbasi.livestyled.data.network.IApiService
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/15.
 */
@Singleton
interface NetComponent {
    @Singleton
    fun exposeIApiService(): IApiService
}