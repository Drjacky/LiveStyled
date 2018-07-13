package ir.hosseinabbasi.livestyled.ui.base

import ir.hosseinabbasi.livestyled.data.network.IApiService
import javax.inject.Inject

/**
 * Created by Dr.jacky on 6/17/2018.
 */
open class BaseInteractor @Inject
constructor(private val mApiService: IApiService) : IBaseInteractor {
    override fun getApiService(): IApiService {
        return mApiService
    }
}
