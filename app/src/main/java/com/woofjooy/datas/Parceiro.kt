package com.woofjooy.datas

import java.time.LocalDate

data class Parceiro(
    val idUser:Int? = null,
    val imgParceiro:String? = null,
    val nome:String? = null,
    val maxDogs:Int? = null,
    val dataEntrada:LocalDate? = null,
    val aceitaDogEspecial:Boolean? = null,
    val aceitaDogIdoso:Boolean? = null,
    val aceitaDogBravo:Boolean? = null,
    val aceitaDogGrande:Boolean? = null,
    val aceitaDogCio:Boolean? = null,
    val descricao:String? = null,
    val servicos:List<Servico>? = null,
)