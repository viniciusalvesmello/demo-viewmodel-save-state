package viniciusalvesmello.github.demoviewmodelsavestate

import android.os.Parcel
import android.os.Parcelable

data class MainData(
    var firstText: String = "",
    var secondText: String = ""
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString() ?: "",
        source.readString() ?: ""
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(firstText)
        writeString(secondText)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<MainData> = object : Parcelable.Creator<MainData> {
            override fun createFromParcel(source: Parcel): MainData = MainData(source)
            override fun newArray(size: Int): Array<MainData?> = arrayOfNulls(size)
        }
    }
}