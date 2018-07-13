package ir.hosseinabbasi.livestyled.ui.eventlist

import android.util.Log
import ir.hosseinabbasi.livestyled.data.db.model.EventsItem
import ir.hosseinabbasi.livestyled.ui.base.BasePresenter
import ir.hosseinabbasi.livestyled.utils.rx.RxDisposableFactory
import ir.hosseinabbasi.livestyled.utils.rx.RxDisposables
import ir.hosseinabbasi.livestyled.utils.rx.ThreadTransformer
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/16.
 */
class EventListPresenter<V : IEventListView, I : IEventListInteractor> @Inject
constructor(interactor: I,
            threadTransformer: ThreadTransformer,
            rxDisposableFactory: RxDisposableFactory) : BasePresenter<V, I>(interactor, threadTransformer, rxDisposableFactory), IEventListPresenter<V, I> {
    private val threadTransformer: ThreadTransformer = this.mThreadTransformer
    private val disposables: RxDisposables = this.mRxDisposables

    override fun getEvents(params: Map<String, String>) {
        mBaseView?.showLoading()
        mBaseView?.setIsLoading(true)

        disposables.add(getInteractor()!!.getEvents(params)
                .map {
                    it.embedded?.events
                    //TODO Sort by date
                }
                .compose(threadTransformer.applySchedulers())
                .subscribe({ events ->
                    mBaseView?.hideLoading()
                    mBaseView?.setIsLoading(false)
                    mBaseView?.loadEvents(events)
                }, { throwable ->
                    mBaseView?.hideLoading()
                    mBaseView?.setIsLoading(false)
                    mBaseView?.onError(throwable.message)
                    Log.wtf(TAG, throwable.message + "") //TODO Use Logger Factory, to send exceptions to the server automatically.
                }))
    }

    override fun insertOrUpdateFavorite(event: EventsItem): Boolean {
        return getInteractor()!!.insertOrUpdateFavorite(event)
    }

    companion object {
        private val TAG: String = EventListPresenter::class.java.simpleName
    }
}