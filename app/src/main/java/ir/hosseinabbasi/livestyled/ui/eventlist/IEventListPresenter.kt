package ir.hosseinabbasi.livestyled.ui.eventlist

import ir.hosseinabbasi.livestyled.data.db.model.EventsItem
import ir.hosseinabbasi.livestyled.ui.base.IBasePresenter

/**
 * Created by Dr.jacky on 2018/06/16.
 */
interface IEventListPresenter<V : IEventListView, I : IEventListInteractor> : IBasePresenter<V, I>{
    fun getEvents(params: Map<String, String>)
    fun insertOrUpdateFavorite(event: EventsItem): Boolean
}