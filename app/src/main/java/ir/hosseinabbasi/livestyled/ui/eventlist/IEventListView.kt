package ir.hosseinabbasi.livestyled.ui.eventlist

import ir.hosseinabbasi.livestyled.data.db.model.EventsItem
import ir.hosseinabbasi.livestyled.ui.base.IBaseView

/**
 * Created by Dr.jacky on 2018/06/16.
 */
interface IEventListView : IBaseView{
    fun setIsLoading(isLoading: Boolean)
    fun loadEvents(events: List<EventsItem?>?)
    fun insertOrUpdateFavorite(event: EventsItem): Boolean
}