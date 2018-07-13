package ir.hosseinabbasi.livestyled.data.network

import io.reactivex.Observable
import ir.hosseinabbasi.livestyled.data.db.model.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Created by Dr.jacky on 2018/06/15.
 */
interface IApiService{
    @GET("events.json")
    fun getEvents(@QueryMap params: Map<String, String>): Observable<Response>
}