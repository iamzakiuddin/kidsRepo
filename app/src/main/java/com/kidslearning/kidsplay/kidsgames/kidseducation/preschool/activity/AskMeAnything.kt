package com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.ai.client.generativeai.GenerativeModel
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.R
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.network.NetworkUtil
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.network.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AskMeAnything : AppCompatActivity() {
    var responseTextView: TextView? = null
    var repo:Repository? = null

    init {
        repo = NetworkUtil.provideRepository()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ask_me_anything)
        initUI()
        supportActionBar?.hide()

        val generativeModel = GenerativeModel(
            // Use a model that's applicable for your use case (see "Implement basic use cases" below)
            modelName = "gemini-pro",
            // Access your API key as a Build Configuration variable (see "Set up your API key" above)
            apiKey = "AIzaSyAvQbPTXNju11AXymHNT3YMivMS2IpdVuw"
        )

        val prompt = "What's day today?"
        CoroutineScope(Dispatchers.Main).launch {
            val response = generativeModel.generateContent(prompt)
            //responseTextView?.text = response?.text ?: ""
            //repo?.getPeriodicTable()
            // https://catfact.ninja/fact
        }

    }

    private fun initUI() {
        responseTextView = findViewById(R.id.responseText)
    }
}