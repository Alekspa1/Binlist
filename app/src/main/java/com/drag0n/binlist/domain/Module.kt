package com.drag0n.binlist.domain

import android.app.Application
import androidx.room.Room
import com.drag0n.binlist.Const.BASE_URL
import com.drag0n.binlist.domain.retrofit.BinApi
import com.drag0n.binlist.domain.room.RoomDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {


    @Provides
    @Singleton
    fun providesRetrofitInstanse(): BinApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).client(client)
            .build()
        return retrofit.create(BinApi::class.java)
    }

    @Provides
    @Singleton
    fun provadesDB(context: Application): RoomDB {
        return Room.databaseBuilder(
            context,
            RoomDB::class.java, "HistoryBin"
        ).build()
    }
}