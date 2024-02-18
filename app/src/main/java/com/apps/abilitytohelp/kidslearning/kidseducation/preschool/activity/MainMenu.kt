package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R

class MainMenu : AppCompatActivity() {

    var mySchool: Button? = null
    var guide: Button? = null
    var funActivity: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        supportActionBar!!.hide()
        mySchool = findViewById(R.id.mySchool)
        guide =  findViewById(R.id.guide)
        funActivity = findViewById(R.id.funactivity)

        mySchool?.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        guide?.setOnClickListener {
            startActivity(Intent(this,GuideActivity::class.java))
        }

        funActivity?.setOnClickListener {
            startActivity(Intent(this,FunActivity::class.java))
        }

    }
}