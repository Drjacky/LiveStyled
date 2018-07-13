package ir.hosseinabbasi.livestyled.ui.eventlist

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import ir.hosseinabbasi.livestyled.R
import ir.hosseinabbasi.livestyled.data.db.model.EventsItem
import ir.hosseinabbasi.livestyled.di.ActivityContext
import ir.hosseinabbasi.livestyled.ui.base.BaseFragment
import ir.hosseinabbasi.livestyled.utils.Constants
import java.util.ArrayList
import java.util.HashMap
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/16.
 */
class EventListView : BaseFragment(), IEventListView {

    @Inject
    @field:ActivityContext
    lateinit var mContext: Context

    @Inject
    lateinit var mPresenter: EventListPresenter<IEventListView, IEventListInteractor>

    @BindView(R.id.fragment_eventlist_rcyEvents)
    lateinit var mRcyEvents: RecyclerView

    private lateinit var adapter: EventListAdapter
    private lateinit var mLayoutManager: LinearLayoutManager
    private var mIsRecyclerViewLoading = false
    private var mBottomReached = false
    private var mCurrentPage = 1
    private val mPageSize = 10
    private val mTotal = 50
    private var mEventsList: List<EventsItem?>? = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_eventlist, container, false)
        getActivityComponent()?.inject(this)
        setUnBinder(ButterKnife.bind(this, view))
        mPresenter.onAttach(this)
        initViews()
        return view
    }

    override fun onDestroyView() {
        mPresenter.onDetach()
        super.onDestroyView()
    }

    private fun initViews() {
        mLayoutManager = LinearLayoutManager(mContext)
        mRcyEvents.layoutManager = mLayoutManager
        mRcyEvents.setHasFixedSize(true)
        mRcyEvents.addOnScrollListener(recyclerViewOnScrollListener)
        adapter = EventListAdapter(this)
        mRcyEvents.adapter = adapter

        if (isNetworkConnected()) run {
            getEventsList()
        }
    }

    private val recyclerViewOnScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val view = recyclerView.getChildAt(recyclerView.childCount - 1) as View
            val diff = view.bottom - (recyclerView.height + recyclerView.scrollY)
            mBottomReached = diff <= 0

            if (dy > 0) {
                val mVisibleItemCount = mLayoutManager.childCount
                val mTotalItemCount = mLayoutManager.itemCount
                val mFirstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition()

                if (!isRecyclerViewLoading()) {
                    if (mVisibleItemCount + mFirstVisibleItemPosition >= mTotalItemCount && mBottomReached && mTotalItemCount < mTotal) {
                        if (isNetworkConnected())
                            getEventsList()
                        else
                            onError(R.string.error_no_internet_connection)
                    }
                }
            }

            super.onScrolled(recyclerView, dx, dy)
        }
    }

    fun getEventsList() {
        val params = HashMap<String, String>()
        params["city"] = Constants.CITY
        params["page"] = mCurrentPage.toString()
        params["size"] = mPageSize.toString()
        mPresenter.getEvents(params)
        mCurrentPage++
    }

    override fun setIsLoading(isLoading: Boolean) {
        this.mIsRecyclerViewLoading = isLoading
    }

    override fun loadEvents(events: List<EventsItem?>?) {
        mEventsList = events
        adapter.addAll(mEventsList)
        adapter.notifyDataSetChanged()
    }

    fun isRecyclerViewLoading(): Boolean {
        return mIsRecyclerViewLoading
    }

    override fun insertOrUpdateFavorite(event: EventsItem): Boolean {
        return mPresenter.insertOrUpdateFavorite(event)
    }

    companion object {
        val TAG: String = EventListView::class.java.simpleName

        fun getInstance(): EventListView {
            return EventListView()
        }
    }
}