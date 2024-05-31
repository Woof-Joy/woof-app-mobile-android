package com.woofjooy.datas

import java.time.LocalDateTime

data class CardModel(
    val boxId: Int,
    val idUser: Int,
    val tipoServico: String = "Não definido",
    val status: String = "Não definido",
    val dataInicio: LocalDateTime?,
    val dataFim: LocalDateTime?,
    val cliente: String = "Não definido",
    val functionPath: String,
    val functionDelete: String
)
