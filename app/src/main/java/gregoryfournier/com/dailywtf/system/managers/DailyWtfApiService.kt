package gregoryfournier.com.dailywtf.system.managers

import com.google.gson.JsonArray
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface DailyWtfApiService {
    @GET("api/articles/recent/{count}")
    @Headers("Content-Type: application/json")
    fun getRecentArticles(@Path("count") count: String): Call<JsonArray>

    companion object {
        fun createService(): DailyWtfApiService {
            return Retrofit.Builder()
                    .baseUrl("http://thedailywtf.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(DailyWtfApiService::class.java)
        }
    }
}