package sekolahbeta.lubisa.wartakotawae.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("top-headlines")
    suspend fun getNewsList(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("q") query: String,
        @Query("apiKey") api_key: String
    ): Response<DataNewspaper>
}