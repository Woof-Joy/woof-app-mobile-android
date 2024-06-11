package com.woofjooy.store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.woofjooy.datas.Relatorio
import kotlinx.coroutines.flow.map


class StoreRelatorio private constructor(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("Relatorio_preferences")
        private val USER_KEY = stringPreferencesKey("user_key")
        private var INSTANCE: StoreRelatorio? = null
        private val gson = Gson()

        fun getInstance(context: Context): StoreRelatorio {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: StoreRelatorio(context).also { INSTANCE = it }
            }
        }
    }

    // Retrieve the Relatorio object
    val getRelatorio: kotlinx.coroutines.flow.Flow<Relatorio?> = context.dataStore.data.map { preferences ->
        preferences[USER_KEY]?.let { json ->
            gson.fromJson(json, Relatorio::class.java)
        }
    }

    // Save the Relatorio object
    suspend fun saveRelatorio(relatorio: Relatorio?) {
        context.dataStore.edit { preferences ->
            preferences[USER_KEY] = gson.toJson(relatorio)
        }
    }
    
}