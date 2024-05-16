package com.woofjooy.datas

data class ParceiroPerfil(
    val nome:String?=null,
    val localizacao:String?=null,
    val descricao:String?=null,
    val servicos:List<Servico>?=null,
    val qtdServicos:Int?=null
)
