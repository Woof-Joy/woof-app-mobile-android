package com.woofjooy.datas

import java.io.Serializable
import java.time.LocalDate

data class Usuario (
    val id:Int?=null,
    val nomeCompleto:String?=null,
    val cpf:String?=null,
    val email:String?=null,
    val senha:String?=null,
    val dataNasc:LocalDate?=null,
    val imgUsuario:String?=null,
    val descricao:String?=null,
    val parceiro:Parceiro?=null,
    val cliente:Cliente?=null,
    val role:String?=null,
    val listItens:List<Item>?=null,
    val endereco: EnderecoX?=null
    ) : Serializable