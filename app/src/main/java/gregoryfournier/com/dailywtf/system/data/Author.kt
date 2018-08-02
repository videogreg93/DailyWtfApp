package gregoryfournier.com.dailywtf.system.data

import com.google.gson.annotations.SerializedName

data class Author (

         val name : String,
         val firstName : String,
         val shortDescription : String,
         val descriptionHtml : String,
         val slug : String,
         val isAdmin : Boolean,
         val isActive : Boolean,
         val imageUrl : String
) {

}