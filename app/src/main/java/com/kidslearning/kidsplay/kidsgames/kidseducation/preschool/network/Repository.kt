package com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.network

import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.model.PeriodicElementResponse
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.model.PeriodicElementResponseItem
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.model.RiddleResponse
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.model.SynonymsResponse

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


}