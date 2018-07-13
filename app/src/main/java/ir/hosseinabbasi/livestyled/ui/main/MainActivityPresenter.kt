package ir.hosseinabbasi.livestyled.ui.main

import ir.hosseinabbasi.livestyled.ui.base.BasePresenter
import ir.hosseinabbasi.livestyled.utils.rx.RxDisposableFactory
import ir.hosseinabbasi.livestyled.utils.rx.RxDisposables
import ir.hosseinabbasi.livestyled.utils.rx.ThreadTransformer
import javax.inject.Inject


/**
 * Created by Dr.jacky on 2018/06/15.
 */
class MainActivityPresenter<V : IMainActivityView, I : IMainActivityInteractor> @Inject
constructor(interactor: I,
            threadTransformer: ThreadTransformer,
            rxDisposableFactory: RxDisposableFactory) : BasePresenter<V, I>(interactor, threadTransformer, rxDisposableFactory), IMainActivityPresenter<V, I> {
    private val threadTransformer: ThreadTransformer = this.mThreadTransformer
    private val disposables: RxDisposables = this.mRxDisposables
}