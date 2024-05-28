package com.woofjooy.datas

import android.os.Parcel
import android.os.Parcelable

data class EnderecoX(
    val id:Int?=null,
    val cep:String?=null,
    val logradouro:String?=null,
    val numero:String?=null,
    val localidade:String?=null,
    val uf:String?=null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(cep)
        parcel.writeString(logradouro)
        parcel.writeString(numero)
        parcel.writeString(localidade)
        parcel.writeString(uf)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<EnderecoX> {
        override fun createFromParcel(parcel: Parcel): EnderecoX {
            return EnderecoX(parcel)
        }

        override fun newArray(size: Int): Array<EnderecoX?> {
            return arrayOfNulls(size)
        }
    }
}