package com.woofjooy.dados

import java.time.LocalDate
import java.util.Date

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