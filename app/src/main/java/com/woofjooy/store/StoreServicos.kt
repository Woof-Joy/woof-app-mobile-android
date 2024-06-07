package com.woofjooy.store

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.woofjooy.datas.Servico
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
class StoreServicos private constructor(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("servicos")
        private val FASE_KEY = stringPreferencesKey("servicos_key")
        private var INSTANCE: StoreServicos? = null
        private val gson = Gson()

        fun getInstance(context: Context): StoreServicos {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: StoreServicos(context).also { INSTANCE = it }
            }
        }
    }

    // Retrieve the list of Fase objects
    val getServicos: Flow<List<Servico>> = context.dataStore.data.map { preferences ->
        val json = preferences[FASE_KEY] ?: return@map emptyList()
        gson.fromJson(json, object : TypeToken<List<Servico>>() {}.type) ?: emptyList()
    }


    // Save the list of Fase objects
    suspend fun saveServicos(fases: List<Servico>) {
        context.dataStore.edit { preferences ->
            val json = gson.toJson(fases)
            preferences[FASE_KEY] = json
        }
    }
}
