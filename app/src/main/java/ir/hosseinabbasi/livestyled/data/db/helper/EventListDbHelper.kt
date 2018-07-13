package ir.hosseinabbasi.livestyled.data.db.helper

import io.reactivex.Flowable
import io.reactivex.Observable
import io.realm.RealmResults
import ir.hosseinabbasi.livestyled.data.db.RealmManager
import ir.hosseinabbasi.livestyled.data.db.model.EventsItem
import ir.hosseinabbasi.livestyled.data.db.model.EventsItemFields
import java.util.concurrent.Callable
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/22.
 */
class EventListDbHelper @Inject
constructor(private val mRealmManager: RealmManager) {

    fun insertOrUpdateFavorite(eventsItem: EventsItem): Boolean {
        val isFav: Boolean
        val realm = mRealmManager.getLocalInstance()
        val eventResult = realm.where(EventsItem::class.java)
                .equalTo(EventsItemFields.ID, eventsItem.id ?: "-1").findFirst()
        isFav = if (eventResult != null) {
            realm.executeTransaction { eventResult.deleteFromRealm() }
            false
        } else {
            realm.executeTransaction { realm1 -> realm1.insertOrUpdate(eventsItem) }
            true
        }

        return isFav
    }

    fun getAllFavorites(): List<EventsItem> {
        val realm = mRealmManager.getLocalInstance()
        return realm.where(EventsItem::class.java).findAll().toList()
    }
}