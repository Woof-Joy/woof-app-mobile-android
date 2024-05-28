package com.woofjooy.datas

import android.os.Parcel
import android.os.Parcelable

data class Item (
    val id:Int,
    val categoria:String,
    val titulo:String,
    val endereco:EnderecoX,
    val descricao:String,
    val imagem:String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readParcelable(EnderecoX::class.java.classLoader) ?: EnderecoX(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(categoria)
        parcel.writeString(titulo)
        parcel.writeParcelable(endereco, flags)
        parcel.writeString(descricao)
        parcel.writeString(imagem)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}