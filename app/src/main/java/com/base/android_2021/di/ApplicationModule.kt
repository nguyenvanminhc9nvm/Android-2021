package com.base.android_2021.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.room.Room
import com.base.android_2021.BuildConfig
import com.base.android_2021.data.data_store.AppDataStoreHelper
import com.base.android_2021.data.data_store.DataStoreHelper
import com.base.android_2021.data.database.AppDatabase
import com.base.android_2021.data.database.AppDbHelper
import com.base.android_2021.data.database.DbHelper
import com.base.android_2021.data.networking.ApiHelper
import com.base.android_2021.data.networking.ApiService
import com.base.android_2021.data.networking.AppApiHelper
import com.base.android_2021.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun providerApiHost() = "http://192.168.1.100:6969/api/v1"

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun providerAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, Constants.DB_APP).build()

    @Provides
    @Singleton
    fun providerUserDao(db: AppDatabase) = db.userDao

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: AppApiHelper): ApiHelper = apiHelper

    @Provides
    @Singleton
    fun providerAppDataStore(@ApplicationContext appContext: Context) = AppDataStoreHelper(context = appContext)

    @Provides
    @Singleton
    fun providerAppDbHelper(appDatabase: AppDatabase) = AppDbHelper(appDatabase)

    @Provides
    @Singleton
    fun providerDbHelper(appDbHelper: AppDbHelper): DbHelper = appDbHelper

    @Provides
    @Singleton
    fun providerDataStore(appDataStoreHelper: AppDataStoreHelper): DataStoreHelper = appDataStoreHelper
}