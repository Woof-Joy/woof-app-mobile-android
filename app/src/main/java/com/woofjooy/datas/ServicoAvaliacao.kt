package com.woofjooy.datas

import android.os.Parcel
import android.os.Parcelable

data class ServicoAvaliacao (
    val fotoParceiro:String,
    val nomeParceiro:String,
    val nota:Int,
    val comentario:String,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(fotoParceiro)
        parcel.writeString(nomeParceiro)
        parcel.writeInt(nota)
        parcel.writeString(comentario)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ServicoAvaliacao> {
        override fun createFromParcel(parcel: Parcel): ServicoAvaliacao {
            return ServicoAvaliacao(parcel)
        }

        override fun newArray(size: Int): Array<ServicoAvaliacao?> {
            return arrayOfNulls(size)
        }
    }
}
