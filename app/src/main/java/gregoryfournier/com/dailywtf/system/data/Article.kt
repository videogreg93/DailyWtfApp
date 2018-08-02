package gregoryfournier.com.dailywtf.system.data

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

class Article(val id: Int, val summaryHtml: String, val bodyHtml: String, val title: String) {

    companion object {
        fun fromJson(json: JsonObject): Article {
            val id = json.get("Id").asInt
            val summaryHtml = json.get("SummaryHtml").asString
            val bodyHtml = json.get("BodyHtml").asString
            val title = json.get("Title").asString

            return Article(id,summaryHtml,bodyHtml,title)
        }
    }
}