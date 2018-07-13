package ir.hosseinabbasi.livestyled.di.module

import dagger.Module
import dagger.Provides
import ir.hosseinabbasi.livestyled.BuildConfig
import ir.hosseinabbasi.livestyled.data.network.ApiEndPoint
import ir.hosseinabbasi.livestyled.data.network.ApiService
import ir.hosseinabbasi.livestyled.data.network.IApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException

/**
 * Created by Dr.jacky on 2018/06/15.
 */
@Module
class NetModule {

    @Provides
    @Singleton
    fun provideApiService(apiService: ApiService): IApiService {
        return apiService
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val client = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    var request = chain.request()
                    val url = request.url()
                            .newBuilder()
                            .addQueryParameter("apikey", ApiEndPoint.API_KEY)
                            .build()
                    request = request.newBuilder().url(url).build()
                    chain.proceed(request)
                }.build()

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiEndPoint.ENDPOINT_TICKETMASTER)
                .client(client)
                .build()
    }
}