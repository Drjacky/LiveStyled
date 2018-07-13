package ir.hosseinabbasi.livestyled.di.component

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Component
import ir.hosseinabbasi.livestyled.MyApplication
import ir.hosseinabbasi.livestyled.data.db.RealmManager
import ir.hosseinabbasi.livestyled.data.network.ApiService
import ir.hosseinabbasi.livestyled.data.network.IApiService
import ir.hosseinabbasi.livestyled.di.ApplicationContext
import ir.hosseinabbasi.livestyled.di.module.ApplicationModule
import ir.hosseinabbasi.livestyled.di.module.DataModule
import ir.hosseinabbasi.livestyled.di.module.NetModule
import ir.hosseinabbasi.livestyled.di.module.UtilsModule
import ir.hosseinabbasi.livestyled.utils.rx.ThreadTransformer
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/15.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class, NetModule::class, UtilsModule::class))
interface ApplicationComponent : DataComponent, NetComponent, UtilsComponent {

    fun inject(app: MyApplication)

    @ApplicationContext
    fun exposeContext(): Context

    fun exposeResources(): Resources

    fun exposeApplication(): Application

    override fun exposeRealmManager(): RealmManager

    override fun exposeIApiService(): IApiService

    override fun exposeThreadTransformer(): ThreadTransformer
}