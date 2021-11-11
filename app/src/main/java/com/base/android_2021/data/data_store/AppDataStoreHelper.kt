package com.base.android_2021.data.data_store

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppDataStoreHelper @Inject constructor(
    private val context: Context
): DataStoreHelper {

    companion object {
        val KEY_TOKEN = stringPreferencesKey("ACCESS_TOKEN")
    }

    override suspend fun saveToken(token: String) {
        context.dataStore.edit {
            it[KEY_TOKEN] = token
        }
    }

    override suspend fun token(): String {
        return context.dataStore.data.map {
            it[KEY_TOKEN]
        }.first() ?: ""
    }
}
