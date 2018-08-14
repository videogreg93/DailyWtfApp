package gregoryfournier.com.dailywtf.system.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.JsonObject

class Article(val id: Int, val summaryHtml: String, val bodyHtml: String, val title: String, val author: Author) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readParcelable<Author>(Author::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(summaryHtml)
        writeString(bodyHtml)
        writeString(title)
        writeParcelable(author, 0)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Article

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id
    }


    companion object {
        fun fromJson(json: JsonObject): Article {
            val id = json.get("Id").asInt
            val summaryHtml = json.get("SummaryHtml").asString
            val bodyHtml = json.get("BodyHtml").asString
            val title = json.get("Title").asString
            val author = Author.fromJson(json.get("Author").asJsonObject)

            return Article(id, summaryHtml, bodyHtml, title, author)
        }

        @JvmField
        val CREATOR: Parcelable.Creator<Article> = object : Parcelable.Creator<Article> {
            override fun createFromParcel(source: Parcel): Article = Article(source)
            override fun newArray(size: Int): Array<Article?> = arrayOfNulls(size)
        }
    }
}