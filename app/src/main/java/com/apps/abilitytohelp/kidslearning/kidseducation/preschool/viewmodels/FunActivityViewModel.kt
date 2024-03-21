package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.AntonymsSynonymsResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.PartOfSpeechResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.PeriodicElementResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.RiddleResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.SynonymsResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.model.WordImageResponse
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.network.NetworkResources
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.network.NetworkUtil
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.network.Repository
import kotlinx.coroutines.launch

class FunActivityViewModel : ViewModel(){

    var repository: Repository? = null

    private var synonymsResponse = MutableLiveData<NetworkResources<SynonymsResponse>>()
    var synonymsResponseObserver: LiveData<NetworkResources<SynonymsResponse>> = synonymsResponse

    private var wordImageResponse = MutableLiveData<NetworkResources<WordImageResponse>>()
    var wordImageResponseObserver: LiveData<NetworkResources<WordImageResponse>> = wordImageResponse

    private var riddleResponse = MutableLiveData<NetworkResources<RiddleResponse>>()
    var riddleResponseObserver: LiveData<NetworkResources<RiddleResponse>> = riddleResponse

    private var periodicElementsResponse = MutableLiveData<NetworkResources<PeriodicElementResponse>>()
    var periodicResponse : LiveData<NetworkResources<PeriodicElementResponse>> = periodicElementsResponse

    private var antonymsSynonymsResponse = MutableLiveData<NetworkResources<AntonymsSynonymsResponse>>()
    var antonymsSynResponse : LiveData<NetworkResources<AntonymsSynonymsResponse>> = antonymsSynonymsResponse

    private var partOfSpeechResponse = MutableLiveData<NetworkResources<PartOfSpeechResponse>>()
    var speechResponse : LiveData<NetworkResources<PartOfSpeechResponse>> = partOfSpeechResponse

    init {
        repository = NetworkUtil.provideRepository()
    }

    fun getSynonyms(word: String){
        synonymsResponse.value = NetworkResources.loading()
        viewModelScope.launch {
            synonymsResponse.value = repository?.getSynonyms(word)
        }
    }
    fun synonymsResponseObserver():LiveData<NetworkResources<SynonymsResponse>>{
        return synonymsResponseObserver
    }

    fun getWordImage(word: String){
        wordImageResponse.value = NetworkResources.loading()
        viewModelScope.launch {
            wordImageResponse.value = repository?.getWordImage(word)
        }
    }
    fun wordImageResponseObserver():LiveData<NetworkResources<WordImageResponse>>{
        return wordImageResponseObserver
    }

    fun getRiddle(){
        riddleResponse.value = NetworkResources.loading()
        viewModelScope.launch {
            riddleResponse.value = repository?.getRiddle()
        }
    }

    fun riddleResponseObserver(): LiveData<NetworkResources<RiddleResponse>>{
        return riddleResponseObserver
    }

    fun getPeriodicTable(){
        periodicElementsResponse.value = NetworkResources.loading()
        viewModelScope.launch {
            periodicElementsResponse.value = repository?.getPeriodicTable()
        }
    }

    fun periodicTableObserver() : LiveData<NetworkResources<PeriodicElementResponse>>{
        return periodicResponse
    }

    fun getAntonymSynonyms(word: String){
        antonymsSynonymsResponse.value = NetworkResources.loading()
        viewModelScope.launch {
            antonymsSynonymsResponse.value = repository?.getAntonymsSynonyms(word)
        }
    }

    fun getAntonymsSynonymsObserver() : LiveData<NetworkResources<AntonymsSynonymsResponse>>{
        return antonymsSynResponse
    }

    fun getPartsOfSpeech(word: String){
        partOfSpeechResponse.value = NetworkResources.loading()
        viewModelScope.launch {
            partOfSpeechResponse.value = repository?.getPartsOfSpeech(word)
        }
    }

    fun partsOfSpeechObserver() : LiveData<NetworkResources<PartOfSpeechResponse>>{
        return speechResponse
    }
}