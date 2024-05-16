package com.woofjooy.datas

data class Servico (
    val tipoServico: String? = null,
    val valor: Double? = null,
    val areaExterna: Boolean? = null,
    val temAnimais: Boolean? = null,
    val temCriancas: Boolean? = null,
    val rotaFuga: Boolean? = null,
    val dogSofaCama: Boolean? = null,
    val servicos:List<ServicoAvaliacao>
)