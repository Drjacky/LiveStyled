package ir.hosseinabbasi.livestyled.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.hosseinabbasi.livestyled.utils.rx.RxDisposables
import ir.hosseinabbasi.livestyled.utils.rx.ThreadTransformer
import ir.hosseinabbasi.livestyled.utils.rx.impl.CompositeDisposablesImpl
import ir.hosseinabbasi.livestyled.utils.rx.impl.ViewThreadTransformer
import ir.hosseinabbasi.livestyled.utils.rx.impl.WorkThreadTransformer
import ir.hosseinabbasi.livestyled.utils.rx.qualifiers.IOThreadPref
import ir.hosseinabbasi.livestyled.utils.rx.qualifiers.UIThreadPref
import ir.hosseinabbasi.livestyled.utils.rx.qualifiers.WorkThreadTransformerPref
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/15.
 */
@Module
class UtilsModule {

    @Provides
    @Singleton
    internal fun providesViewThreadTransformer(
            transformer: ViewThreadTransformer): ThreadTransformer {
        return transformer
    }

    @Provides
    @Singleton
    @WorkThreadTransformerPref
    internal fun providesWorkThreadTransformer(
            transformer: WorkThreadTransformer): ThreadTransformer {
        return transformer
    }

    @Provides
    @Singleton
    @IOThreadPref
    internal fun provideIoScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Provides
    @Singleton
    @UIThreadPref
    internal fun provideMainScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Provides
    @Singleton
    fun provideCompositeDisposables(
            disposables: CompositeDisposablesImpl): RxDisposables {
        return disposables
    }
}