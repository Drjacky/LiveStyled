package ir.hosseinabbasi.livestyled.di.component

import dagger.Component
import ir.hosseinabbasi.livestyled.di.PerActivity
import ir.hosseinabbasi.livestyled.di.module.ActivityModule
import ir.hosseinabbasi.livestyled.ui.base.BaseActivity
import ir.hosseinabbasi.livestyled.ui.eventlist.EventListView
import ir.hosseinabbasi.livestyled.ui.main.MainActivity

/**
 * Created by Dr.jacky on 2018/06/15.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(activity: BaseActivity)
    fun inject(activity: MainActivity)
    fun inject(fragment: EventListView)
}