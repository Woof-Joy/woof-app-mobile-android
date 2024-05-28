package com.woofjooy.datas

import java.time.LocalDate

data class ParceiroFeed (
    val idParceiro:Int? = null,
    val idUser:Int? = null,
    //val imgParceiro:String? = null,
    val nome:String? = null,
    val sobrenome:String? = null,
    val email:String? = null,
    val dataNasc: String? = null,
    val dataEntrada: String? = null,
    val estrelas:Double? = null,
    val qtdServicosPrestados:Int? = null,
    val idUsuario:Int? = null,
    val cidade:String? = null,
    val uf:String? = null,
    val servicos:List<FichaServico>? = null,
    val descricao:String? = null
)