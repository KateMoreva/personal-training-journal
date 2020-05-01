package ru.ok.technopolis.training.personal.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.ok.technopolis.training.personal.BuildConfig
import ru.ok.technopolis.training.personal.config.Config

object RetrofitApiUtils {

    private val TRAINING_JOURNAL_URL = Config.getBackendAddress() + "/"

    @JvmStatic
    fun createApi(): ApiInterface {
        val okHttpClient = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
            okHttpClient.addInterceptor(httpLoggingInterceptor)
        }

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(TRAINING_JOURNAL_URL)
                .client(okHttpClient.build())
                .build()
                .create(ApiInterface::class.java)
    }
}