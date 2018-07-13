package ir.hosseinabbasi.livestyled.ui.eventlist

import io.reactivex.Observable
import ir.hosseinabbasi.livestyled.data.db.model.EventsItem
import ir.hosseinabbasi.livestyled.data.db.model.Response
import ir.hosseinabbasi.livestyled.ui.base.IBaseInteractor

/**
 * Created by Dr.jacky on 6/18/2018.
 */
interface IEventListInteractor : IBaseInteractor{
    fun getEvents(params: Map<String, String>): Observable<Response>
    fun insertOrUpdateFavorite(event: EventsItem): Boolean
}