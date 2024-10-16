package com.ubaya.projectutsnmp

import android.os.Parcel
import android.os.Parcelable

data class AchievementBank ( var nama: String,
                             var tahun: Int ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt() ?: 0
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeInt(tahun)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AchievementBank> {
        override fun createFromParcel(parcel: Parcel): AchievementBank {
            return AchievementBank(parcel)
        }

        override fun newArray(size: Int): Array<AchievementBank?> {
            return arrayOfNulls(size)
        }
    }
}

