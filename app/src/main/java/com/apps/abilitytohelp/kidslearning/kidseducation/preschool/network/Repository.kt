package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.network

import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.AntonymsSynonymsResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.PartOfSpeechResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.PeriodicElementResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.RiddleResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.SynonymsResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.WordImageResponse

class Repository(val dataApi: RestApi) {

    suspend fun getSynonyms(word: String): NetworkResources<SynonymsResponse>{
        try {
            val response = dataApi.getSynonyms("https://synonyms-api.p.rapidapi.com/synonym","b42a85a811msh4e571f6b5d07e65p102209jsneb74d08ea20f","synonyms-api.p.rapidapi.com",word)
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null && response.code() == 200) {
                    // Check if the response body is not empty
                    if (!responseBody.synonyms.isNullOrEmpty()) {
                        return NetworkResources.success(responseBody)
                    } else {
                        return NetworkResources.error("No data!")
                    }
                } else if(responseBody != null && responseBody.statusCode == 404){
                    return NetworkResources.error(responseBody.message)
                }else {
                    return NetworkResources.error("No data!")
                }
            } else {
                return NetworkResources.error(response.message())
            }
        }catch (e: Exception){
            return NetworkResources.error(e.message!!)
        }
    }

    suspend fun getWordImage(word: String): NetworkResources<WordImageResponse>{
        try {
            val response = dataApi.getWordImage(
                "https://edupix.p.rapidapi.com/science/$word",
                "b42a85a811msh4e571f6b5d07e65p102209jsneb74d08ea20f",
                "edupix.p.rapidapi.com")
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null && response.code() == 200) {
                    // Check if the response body is not empty
                    if (responseBody.images.isNotEmpty()) {
                        return NetworkResources.success(responseBody)
                    } else {
                        return NetworkResources.error("No data!")
                    }
                }else {
                    return NetworkResources.error("No data!")
                }
            } else {
                return NetworkResources.error(response.message())
            }
        }catch (e: Exception){
            return NetworkResources.error(e.message!!)
        }
    }


    suspend fun getRiddle(): NetworkResources<RiddleResponse>{
        try {
            val response = dataApi.getRiddle("b42a85a811msh4e571f6b5d07e65p102209jsneb74d08ea20f","riddlie.p.rapidapi.com")
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null && response.code() == 200) {
                    // Check if the response body is not empty
                    if (!responseBody.riddle.isNullOrEmpty() && !responseBody.answer.isNullOrEmpty()) {
                        return NetworkResources.success(responseBody)
                    } else {
                        return NetworkResources.error("No data!")
                    }
                } else {
                    return NetworkResources.error("No data!")
                }
            } else {
                return NetworkResources.error(response.message())
            }
        }catch (e: Exception){
            return NetworkResources.error(e.message!!)
        }
    }

    suspend fun getPeriodicTable(): NetworkResources<PeriodicElementResponse>{
        try {
            val response = dataApi.getPeriodicTable("https://periodictable.p.rapidapi.com/","b42a85a811msh4e571f6b5d07e65p102209jsneb74d08ea20f","periodictable.p.rapidapi.com")
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null && response.code() == 200) {
                    // Check if the response body is not empty
                    if (!responseBody.isNullOrEmpty() && responseBody.isNotEmpty()) {
                        return NetworkResources.success(responseBody)
                    } else {
                        return NetworkResources.error("No data!")
                    }
                } else {
                    return NetworkResources.error("No data!")
                }
            } else {
                return NetworkResources.error(response.message())
            }
        }catch (e: Exception){
            return NetworkResources.error(e.message!!)
        }
    }

    suspend fun getAntonymsSynonyms(word: String) : NetworkResources<AntonymsSynonymsResponse>{
        try {
            val response = dataApi.getAntonymsSynonyms("https://thesaurus-by-api-ninjas.p.rapidapi.com/v1/thesaurus/","73c0c813a4mshebc31b8efca06b3p1dd4abjsn5b42d292097c","thesaurus-by-api-ninjas.p.rapidapi.com",word)
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null && response.code() == 200) {
                    // Check if the response body is not empty
                    if (responseBody.word.isNotEmpty()) {
                        return NetworkResources.success(responseBody)
                    } else {
                        return NetworkResources.error("No data!")
                    }
                } else {
                    return NetworkResources.error("No data!")
                }
            } else {
                return NetworkResources.error(response.message())
            }
        }catch (e: Exception){
            return NetworkResources.error(e.message!!)
        }
    }

    suspend fun getPartsOfSpeech(word: String) : NetworkResources<PartOfSpeechResponse>{
        try {
            val response = dataApi.getPartsOfSpeech("https://speechfinder-word-class-identification.p.rapidapi.com/part_of_speech/","73c0c813a4mshebc31b8efca06b3p1dd4abjsn5b42d292097c","speechfinder-word-class-identification.p.rapidapi.com", word)
            if (response.isSuccessful) {
                val responseBody = response.body()
                if (responseBody != null && response.code() == 200) {
                    // Check if the response body is not empty
                    if (!responseBody.word.isNullOrEmpty()) {
                        return NetworkResources.success(responseBody)
                    } else {
                        return NetworkResources.error("No data!")
                    }
                } else {
                    return NetworkResources.error("No data!")
                }
            } else {
                return NetworkResources.error(response.message())
            }
        }catch (e: Exception){
            return NetworkResources.error(e.message!!)
        }
    }
}