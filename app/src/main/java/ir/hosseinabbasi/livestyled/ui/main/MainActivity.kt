package ir.hosseinabbasi.livestyled.ui.main

import android.os.Bundle
import butterknife.ButterKnife
import ir.hosseinabbasi.livestyled.R
import ir.hosseinabbasi.livestyled.ui.base.BaseActivity
import ir.hosseinabbasi.livestyled.ui.eventlist.EventListView
import javax.inject.Inject


/**
 * Created by Dr.jacky on 2018/06/15.
 */
class MainActivity : BaseActivity(), IMainActivityView {

    @Inject
    lateinit var mPresenter: IMainActivityPresenter<IMainActivityView, IMainActivityInteractor>

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        setUnBinder(ButterKnife.bind(this))
        initViews()
        mPresenter.onAttach(this)
    }

    public override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }

    private fun initViews() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_frmMain, EventListView.getInstance(), EventListView.TAG)
                .commit()
    }
}