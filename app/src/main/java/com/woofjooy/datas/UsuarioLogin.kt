package com.woofjooy.datas

import android.provider.ContactsContract.CommonDataKinds.Email

data class UsuarioLogin(
    val email: String,
    val senha:String,
    val type:String
) {
}