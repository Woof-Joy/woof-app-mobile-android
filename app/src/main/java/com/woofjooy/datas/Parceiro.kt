package com.woofjooy.datas

import java.time.LocalDate

data class Parceiro(
    val id:Int,
    val nome:String,
    val sobrenome:String,
    val cep:String,
    val numero:Int,
    val email:String,
    val dataNasc:LocalDate,
    val endereco:String,
    val estrelas:Double,
    val qtdServicosPrestados:Int,
    val servicos:List<Servico>
)