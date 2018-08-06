package gregoryfournier.com.dailywtf.system.data

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class Series (

         val slug : String,
         val title : String,
         val description : String,
         val cssClass : String
) {

    companion object {
        fun FromJson(json: JsonObject): Series {
            val slug = json.get("Slug").asString
            val title = json.get("Title").asString
            var description: String = ""
            //TODO this is pretty ugly
            try {
                description = json.get("Description").asString
            } catch (e: Exception) {
            }
            val cssClass = json.get("CssClass").asString.orEmpty()

            return Series(slug,title,description,cssClass)
        }
    }
}