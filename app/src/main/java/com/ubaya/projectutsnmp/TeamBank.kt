package com.ubaya.projectutsnmp

import android.os.Parcel
import android.os.Parcelable

data class TeamBank ( var nama: String,
                      var member: List<MemberBank>): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.createTypedArrayList(MemberBank.CREATOR) ?: emptyList()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeTypedList(member)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TeamBank> {
        override fun createFromParcel(parcel: Parcel): TeamBank {
            return TeamBank(parcel)
        }

        override fun newArray(size: Int): Array<TeamBank?> {
            return arrayOfNulls(size)
        }
    }
}