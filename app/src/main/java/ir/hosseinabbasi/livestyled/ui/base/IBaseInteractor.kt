package ir.hosseinabbasi.livestyled.ui.base

import ir.hosseinabbasi.livestyled.data.network.IApiService


/**
 * Created by Dr.jacky on 6/17/2018.
 */
/**
 * Lists APIs method and Helper classes that are common to all application components.
 */
interface IBaseInteractor{
    fun getApiService(): IApiService
}