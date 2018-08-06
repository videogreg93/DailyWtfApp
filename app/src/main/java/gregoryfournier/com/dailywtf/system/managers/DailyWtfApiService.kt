package gregoryfournier.com.dailywtf.system.managers

import com.google.gson.JsonArray
import gregoryfournier.com.dailywtf.system.data.Article
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface DailyWtfApiService {
    @GET("articles/recent/{count}")
    @Headers("Content-Type: application/json")
    fun getRecentArticles(@Path("count") count: String): Call<JsonArray>

    @GET("series/")
    @Headers("Content-Type: application/json")
    fun getAllSeries(): Call<JsonArray>

    companion object {
        fun createService(): DailyWtfApiService {
            return Retrofit.Builder()
                    .baseUrl("http://thedailywtf.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(DailyWtfApiService::class.java)
        }
    }
}