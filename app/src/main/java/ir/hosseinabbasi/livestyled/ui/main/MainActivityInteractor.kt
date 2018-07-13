package ir.hosseinabbasi.livestyled.ui.main

import ir.hosseinabbasi.livestyled.data.network.IApiService
import javax.inject.Inject
import ir.hosseinabbasi.livestyled.ui.base.BaseInteractor



/**
 * Created by Dr.jacky on 6/18/2018.
 */
class MainActivityInteractor @Inject
constructor(apiService: IApiService) : BaseInteractor(apiService), IMainActivityInteractor