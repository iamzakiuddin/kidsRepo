package com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.R
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.network.NetworkResources
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.viewmodels.FunActivityViewModel

class RiddleActivity : AppCompatActivity() {

    var showAnswer: Button? = null
    var riddle: TextView? = null
    var answer: TextView? = null
    var loading: ProgressBar? = null
    var back : ImageView? = null

    val viewmodel: FunActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riddle)
        supportActionBar?.hide()
        initUI()
        viewmodel.getRiddle()
        viewmodel.riddleResponseObserver().observe(this, Observer {
            when (it.status){
                NetworkResources.NetworkStatus.LOADING ->{
                    loading?.visibility = View.VISIBLE
                }
                NetworkResources.NetworkStatus.SUCCESS -> {
                    loading?.visibility = View.GONE
                    riddle?.text = it.data?.riddle
                    answer?.text = it.data?.answer
                }
                NetworkResources.NetworkStatus.ERROR -> {
                    loading?.visibility = View.GONE
                    Log.e("fuck",it.message?:"")
                    Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
                }
                else ->{
                    loading?.visibility = View.GONE
                    Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show()
                }
            }
        })

        showAnswer?.setOnClickListener {
            answer?.visibility = View.VISIBLE
        }

        back?.setOnClickListener {
            finish()
        }
    }

    private fun initUI() {
        showAnswer = findViewById(R.id.showAnswer)
        riddle = findViewById(R.id.riddle)
        answer = findViewById(R.id.answer)
        loading = findViewById(R.id.loading)
        back = findViewById(R.id.back)
        var loadingDrawable = loading?.progressDrawable?.mutate()
        loadingDrawable?.setColorFilter(resources.getColor(R.color.purple),android.graphics.PorterDuff.Mode.SRC_IN)
        loading?.progressDrawable = loadingDrawable
    }
}