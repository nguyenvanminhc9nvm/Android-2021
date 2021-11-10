package com.base.android_2021.data.data_store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore : DataStore<Preferences> by preferencesDataStore("preferencesKey")
interface DataStoreHelper {
    suspend fun saveToken(token: String)

    suspend fun token(): String
}