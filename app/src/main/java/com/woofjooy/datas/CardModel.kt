package com.woofjooy.datas

import java.time.LocalDateTime

data class CardModel(
    val tipoServico: String = "Não definido",
    val status: String = "Não definido",
    val dataInicio: LocalDateTime?,
    val dataFim: LocalDateTime?,
    val cliente: String = "Não definido",
)
