package ir.hosseinabbasi.livestyled.data.network

import io.reactivex.Observable
import ir.hosseinabbasi.livestyled.data.db.model.Response
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 6/17/2018.
 */
@Singleton
class ApiService @Inject
constructor(retrofit: Retrofit) : IApiService{
    private val mRetrofit = retrofit

    override fun getEvents(params: Map<String, String>): Observable<Response> {
        return mRetrofit.create(IApiService::class.java).getEvents(params)
    }
}