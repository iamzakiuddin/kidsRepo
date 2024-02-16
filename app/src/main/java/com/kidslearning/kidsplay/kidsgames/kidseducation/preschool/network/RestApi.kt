package com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.network

import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.model.PeriodicElementResponse
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.model.PeriodicElementResponseItem
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.model.RiddleResponse
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.model.SynonymsResponse
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.model.WordImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.HeaderMap
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.http.Url

interface RestApi {

    @GET
    suspend fun getSynonyms(
        @Url baseUrl: String,
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String,
        @Query("word") word: String) : Response<SynonymsResponse>

    @GET("https://riddlie.p.rapidapi.com/api/v1/riddles/random")
    suspend fun getRiddle(
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String) : Response<RiddleResponse>

    @GET
    suspend fun getPeriodicTable(
        @Url baseUrl: String,
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String) : Response<PeriodicElementResponse>

    @GET
    suspend fun getWordImage(
        @Url baseUrl: String,
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String) : Response<WordImageResponse>
}