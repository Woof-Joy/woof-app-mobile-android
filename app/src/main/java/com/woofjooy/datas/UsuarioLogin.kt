package com.woofjooy.datas

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.ui.semantics.Role

data class UsuarioLogin(
    val email: String,
    val role:String,
    val senha:String,
)