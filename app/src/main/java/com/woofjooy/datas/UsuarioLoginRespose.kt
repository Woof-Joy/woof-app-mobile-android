package com.woofjooy.datas

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable
import java.time.LocalDate

data class UsuarioLoginRespose(
    val userId: Int?=null,
    var nome: String?=null,
    val email: String?=null,
    val role: String?=null,
    val token:String?=null,
    val nomeCompleto:String?=null,
    val cpf:String?=null,
    val senha:String?=null,
    val dataNasc: String?=null,
    val imgUsuario:String?=null,
    val descricao:String?=null,
    val parceiro:Parceiro?=null,
    val cliente:Cliente?=null,
    val listItens:List<Item>?=null,
    val endereco: EnderecoX?=null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Parceiro::class.java.classLoader),
        parcel.readParcelable(Cliente::class.java.classLoader),
        parcel.createTypedArrayList(Item.CREATOR),
        parcel.readParcelable(EnderecoX::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(userId)
        parcel.writeString(nome)
        parcel.writeString(email)
        parcel.writeString(role)
        parcel.writeString(token)
        parcel.writeString(nomeCompleto)
        parcel.writeString(cpf)
        parcel.writeString(senha)
        parcel.writeString(dataNasc)
        parcel.writeString(imgUsuario)
        parcel.writeString(descricao)
        parcel.writeParcelable(parceiro, flags)
        parcel.writeParcelable(cliente, flags)
        parcel.writeTypedList(listItens)
        parcel.writeParcelable(endereco, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UsuarioLoginRespose> {
        override fun createFromParcel(parcel: Parcel): UsuarioLoginRespose {
            return UsuarioLoginRespose(parcel)
        }

        override fun newArray(size: Int): Array<UsuarioLoginRespose?> {
            return arrayOfNulls(size)
        }
    }
}