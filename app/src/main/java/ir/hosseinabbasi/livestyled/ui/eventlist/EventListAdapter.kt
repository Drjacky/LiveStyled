package ir.hosseinabbasi.livestyled.ui.eventlist

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.constraint.ConstraintLayout
import android.support.v4.widget.ImageViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.squareup.picasso.Picasso
import ir.hosseinabbasi.livestyled.R
import ir.hosseinabbasi.livestyled.data.db.model.EventsItem
import ir.hosseinabbasi.livestyled.databinding.EventItemBinding
import java.util.ArrayList

/**
 * Created by Dr.jacky on 2018/06/21.
 */
class EventListAdapter(private val mListener: IEventListView) : RecyclerView.Adapter<EventListAdapter.DataHolder>() {
    private var mEventsItems: MutableList<EventsItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val bind: EventItemBinding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context),
                R.layout.event_item, parent, false) as EventItemBinding

        return DataHolder(bind)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val eventsItemModel = mEventsItems[holder.adapterPosition]
        holder.bind(eventsItemModel)
    }

    override fun getItemCount(): Int {
        return mEventsItems.size
    }

    fun addAll(eventsList: List<EventsItem?>?) {
        mEventsItems.addAll(eventsList!!.filterNotNull())
    }

    inner class DataHolder(private var eventItemBinding: EventItemBinding) : RecyclerView.ViewHolder
    (eventItemBinding.root), View.OnClickListener {
        @BindView(R.id.event_item_imvFav)
        lateinit var favorite: ImageView

        @BindView(R.id.event_item_imvEvent)
        lateinit var imageEvent: ImageView

        init {
            ButterKnife.bind(this, eventItemBinding.root)
        }

        fun bind(scItem: EventsItem) {
            eventItemBinding.eventsItemModel = scItem
            this.favorite.setOnClickListener(this)
            eventItemBinding.executePendingBindings()
            Picasso.get()
                    .load(eventItemBinding.eventsItemModel?.images?.get(0)?.url)
                    .placeholder(R.mipmap.ic_launcher_round)
                    .error(R.mipmap.ic_launcher_round)
                    .into(imageEvent)
            if (scItem.isFav)
                this.favorite.setImageResource(R.drawable.ic_favorite_isfav_24dp)
            else if (!scItem.isFav)
                this.favorite.setImageResource(R.drawable.ic_favorite_unfav_24dp)
        }

        override fun onClick(view: View) {
            val event: EventsItem = mEventsItems[adapterPosition]
            val isFav = mListener.insertOrUpdateFavorite(event)
            when (isFav) {
                true -> this.favorite.setImageResource(R.drawable.ic_favorite_isfav_24dp)
                false -> this.favorite.setImageResource(R.drawable.ic_favorite_unfav_24dp)
            }
            event.isFav = isFav
        }

    }
}