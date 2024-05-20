package com.woofjooy.datas

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.ui.semantics.Role

data class UsuarioLogin(
    val email: String,
    val senha:String,
    val role:String
) {
}