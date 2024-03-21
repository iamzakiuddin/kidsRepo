package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.network

import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.AntonymsSynonymsResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.PartOfSpeechResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.PeriodicElementResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.RiddleResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.SynonymsResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.WordImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
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

    @GET
    suspend fun getAntonymsSynonyms(
        @Url baseUrl: String,
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String,
        @Query("word") word: String) : Response<AntonymsSynonymsResponse>

    @GET
    suspend fun getPartsOfSpeech(
        @Url baseUrl: String,
        @Header("X-RapidAPI-Key") key: String,
        @Header("X-RapidAPI-Host") host: String,
        @Query("word") word: String) : Response<PartOfSpeechResponse>


}