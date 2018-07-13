package ir.hosseinabbasi.livestyled.di.module

import dagger.Module
import dagger.Provides
import ir.hosseinabbasi.livestyled.data.db.RealmManager
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/15.
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRealmManager(): RealmManager {
        return RealmManager()
    }
}