package ir.hosseinabbasi.livestyled.ui.eventlist

import io.reactivex.Observable
import ir.hosseinabbasi.livestyled.data.db.helper.EventListDbHelper
import ir.hosseinabbasi.livestyled.data.db.model.EventsItem
import ir.hosseinabbasi.livestyled.data.db.model.Response
import ir.hosseinabbasi.livestyled.data.network.IApiService
import ir.hosseinabbasi.livestyled.ui.base.BaseInteractor
import javax.inject.Inject

/**
 * Created by Dr.jacky on 6/18/2018.
 */
class EventListInteractor @Inject
constructor(apiService: IApiService, private val mEventListDbHelper: EventListDbHelper) : BaseInteractor(apiService), IEventListInteractor {
    override fun getEvents(params: Map<String, String>): Observable<Response> {
        return getApiService().getEvents(params)
    }

    override fun insertOrUpdateFavorite(event: EventsItem): Boolean {
        return mEventListDbHelper.insertOrUpdateFavorite(event)
    }
}
