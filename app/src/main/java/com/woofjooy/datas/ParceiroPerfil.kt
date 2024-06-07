package com.woofjooy.datas

data class ParceiroPerfil(
    val nome:String?=null,
    val localizacao:String?=null,
    val descricao:String?=null,
    val servicos:List<ServicoOld>?=null,
    val qtdServicos:Int?=null
)
