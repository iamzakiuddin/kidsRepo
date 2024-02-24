package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R

class FunActivity : AppCompatActivity() {

    var back : ImageView? = null
    var synonyms: Button? = null
    var riddle: Button? = null
    var periodicTable: Button? = null
    var machineLearningActivity: Button? = null
    var askMeAnything : Button? = null
    var wordToImage : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fun)
        supportActionBar?.hide()
        initUI()
        back?.setOnClickListener {
            onBackPressed()
        }
        synonyms?.setOnClickListener {
            startActivity(Intent(this,SynonymsActivity::class.java))
            overridePendingTransition(R.anim.enter_anim,R.anim.exit)
        }

        riddle?.setOnClickListener {
            startActivity(Intent(this,RiddleActivity::class.java))
            overridePendingTransition(R.anim.enter_anim,R.anim.exit)
        }

        periodicTable?.setOnClickListener {
            startActivity(Intent(this,PeriodicElementsActivity::class.java))
            overridePendingTransition(R.anim.enter_anim,R.anim.exit)
        }

        machineLearningActivity?.setOnClickListener {
            startActivity(Intent(this,MachineLearningActivity::class.java))
            overridePendingTransition(R.anim.enter_anim,R.anim.exit)
        }

        askMeAnything?.setOnClickListener {
            startActivity(Intent(this,AskMeAnything::class.java))
            overridePendingTransition(R.anim.enter_anim,R.anim.exit)
        }

        wordToImage?.setOnClickListener {
            startActivity(Intent(this,WordImageActivity::class.java))
            overridePendingTransition(R.anim.enter_anim,R.anim.exit)
        }

    }

    private fun initUI() {
        back = findViewById(R.id.close)
        synonyms = findViewById(R.id.synonyms)
        riddle = findViewById(R.id.riddleBtn)
        periodicTable = findViewById(R.id.learning_periodic_table)
        machineLearningActivity = findViewById(R.id.machine_learning)
        askMeAnything = findViewById(R.id.ask_me_anything)
        wordToImage = findViewById(R.id.word_image)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_down_a,R.anim.slide_down_b)
    }
}