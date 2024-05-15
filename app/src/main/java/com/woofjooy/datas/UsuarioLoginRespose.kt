package com.woofjooy.datas

data class UsuarioLoginRespose(
    val userId: Int?=null,
    var nome: String?=null,
    val email: String?=null,
    val role: String?=null,
    val token:String?=null
)