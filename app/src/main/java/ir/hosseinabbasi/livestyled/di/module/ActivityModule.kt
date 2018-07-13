package ir.hosseinabbasi.livestyled.di.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import ir.hosseinabbasi.livestyled.di.ActivityContext
import ir.hosseinabbasi.livestyled.di.PerActivity
import ir.hosseinabbasi.livestyled.ui.eventlist.*
import ir.hosseinabbasi.livestyled.ui.main.*

/**
 * Created by Dr.jacky on 2018/06/15.
 */
@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    @ActivityContext
    fun provideActivityContext(): Context {
        return mActivity
    }

    @Provides
    fun provideActivity(): Activity {
        return mActivity
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @PerActivity
    fun provideMainActivityPresenter(presenter: MainActivityPresenter<IMainActivityView, IMainActivityInteractor>):
            IMainActivityPresenter<IMainActivityView, IMainActivityInteractor> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideMainInteractor(interactor: MainActivityInteractor): IMainActivityInteractor {
        return interactor
    }

    @Provides
    @PerActivity
    fun provideEventListPresenter(presenter: EventListPresenter<IEventListView, IEventListInteractor>):
            IEventListPresenter<IEventListView, IEventListInteractor> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideEventListInteractor(interactor: EventListInteractor): IEventListInteractor {
        return interactor
    }
}