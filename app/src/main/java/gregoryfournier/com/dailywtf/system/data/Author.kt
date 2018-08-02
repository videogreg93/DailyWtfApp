package gregoryfournier.com.dailywtf.system.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class Author(

        val name: String,
        val firstName: String,
        val shortDescription: String,
        val slug: String,
        val isAdmin: Boolean,
        val isActive: Boolean,
        val imageUrl: String
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            1 == source.readInt(),
            1 == source.readInt(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(firstName)
        writeString(shortDescription)
        writeString(slug)
        writeInt((if (isAdmin) 1 else 0))
        writeInt((if (isActive) 1 else 0))
        writeString(imageUrl)
    }

    companion object {
        fun fromJson(json: JsonObject): Author {
            return Author(
                    json.get("Name").asString,
                    json.get("FirstName").asString,
                    json.get("ShortDescription").asString,
                    json.get("Slug").asString,
                    json.get("IsAdmin").asJsonPrimitive.asBoolean,
                    json.get("IsActive").asJsonPrimitive.asBoolean,
                    json.get("ImageUrl").asString
            )
        }

        @JvmField
        val CREATOR: Parcelable.Creator<Author> = object : Parcelable.Creator<Author> {
            override fun createFromParcel(source: Parcel): Author = Author(source)
            override fun newArray(size: Int): Array<Author?> = arrayOfNulls(size)
        }
    }
}