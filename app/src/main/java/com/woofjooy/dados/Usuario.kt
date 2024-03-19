package com.woofjooy.dados

import android.provider.ContactsContract.CommonDataKinds.Email
import java.time.LocalDate

data class Usuario (
    val id:Int,
    val nomeCompleto:String,
    val cpf:String,
    val cep:String,
    val numero:Int,
    val email:String,
    val senha:String,
    val dataNasc:LocalDate,
    val imgUsuario:String,
    val descricao:String,
    val parceiro:Parceiro,
    val cliente:Cliente,
    val listItens:List<Item>
    )