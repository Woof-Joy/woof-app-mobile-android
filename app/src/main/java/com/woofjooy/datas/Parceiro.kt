package com.woofjooy.datas

import android.os.Parcel
import android.os.Parcelable
import java.time.LocalDate

data class Parceiro(
    val idUser:Int? = null,
    val imgParceiro:String? = null,
    val nome:String? = null,
    val maxDogs:Int? = null,
    val dataEntrada:String? = null,
    val aceitaDogEspecial:Boolean? = null,
    val aceitaDogIdoso:Boolean? = null,
    val aceitaDogBravo:Boolean? = null,
    val aceitaDogGrande:Boolean? = null,
    val aceitaDogCio:Boolean? = null,
    val descricao:String? = null,
    val servicos:List<Servico>? = null,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readString(),
        parcel.createTypedArrayList(Servico.CREATOR)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(idUser)
        parcel.writeString(imgParceiro)
        parcel.writeString(nome)
        parcel.writeValue(maxDogs)
        parcel.writeString(dataEntrada)
        parcel.writeValue(aceitaDogEspecial)
        parcel.writeValue(aceitaDogIdoso)
        parcel.writeValue(aceitaDogBravo)
        parcel.writeValue(aceitaDogGrande)
        parcel.writeValue(aceitaDogCio)
        parcel.writeString(descricao)
        parcel.writeTypedList(servicos)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Parceiro> {
        override fun createFromParcel(parcel: Parcel): Parceiro {
            return Parceiro(parcel)
        }

        override fun newArray(size: Int): Array<Parceiro?> {
            return arrayOfNulls(size)
        }
    }
}