package com.ubaya.projectutsnmp

import android.os.Parcel
import android.os.Parcelable

data class MemberBank ( var nama: String,
                        var role : String,
                        var gambar: Int): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt() ?: 0
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeString(role)
        parcel.writeInt(gambar)
    }

    override fun describeContents(): Int {
      return 0
    }

    companion object CREATOR : Parcelable.Creator<MemberBank> {
        override fun createFromParcel(parcel: Parcel): MemberBank {
            return MemberBank(parcel)
        }

        override fun newArray(size: Int): Array<MemberBank?> {
            return arrayOfNulls(size)
        }
    }
}