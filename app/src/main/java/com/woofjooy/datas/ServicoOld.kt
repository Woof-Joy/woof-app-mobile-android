package com.woofjooy.datas

import android.os.Parcel
import android.os.Parcelable

data class ServicoOld (
    val tipoServico: String? = null,
    val valor: Double? = null,
    val areaExterna: Boolean? = null,
    val temAnimais: Boolean? = null,
    val temCriancas: Boolean? = null,
    val rotaFuga: Boolean? = null,
    val dogSofaCama: Boolean? = null,
    val servicos:List<ServicoAvaliacao>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.createTypedArrayList(ServicoAvaliacao.CREATOR) ?: listOf()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tipoServico)
        parcel.writeValue(valor)
        parcel.writeValue(areaExterna)
        parcel.writeValue(temAnimais)
        parcel.writeValue(temCriancas)
        parcel.writeValue(rotaFuga)
        parcel.writeValue(dogSofaCama)
        parcel.writeTypedList(servicos)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ServicoOld> {
        override fun createFromParcel(parcel: Parcel): ServicoOld {
            return ServicoOld(parcel)
        }

        override fun newArray(size: Int): Array<ServicoOld?> {
            return arrayOfNulls(size)
        }
    }
}