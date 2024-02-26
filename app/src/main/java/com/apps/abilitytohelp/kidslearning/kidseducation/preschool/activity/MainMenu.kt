package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.interfaces.AdsCallback
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.utils.CommonConstantAd
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.utils.Utils

class MainMenu : AppCompatActivity(), AdsCallback {

    var mySchool: Button? = null
    var guide: Button? = null
    var funActivity: Button? = null
    var llAdView : RelativeLayout? = null
    var llAdViewFacebook: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        supportActionBar?.hide()
        mySchool = findViewById(R.id.mySchool)
        guide =  findViewById(R.id.guide)
        funActivity = findViewById(R.id.funactivity)
        llAdView = findViewById(R.id.llAdView)
        llAdViewFacebook = findViewById(R.id.llAdViewFacebook)
        CommonConstantAd.googlebeforloadAd(this)
        Utils.loadBannerAd(this, llAdView, llAdViewFacebook)

        mySchool?.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            overridePendingTransition(R.anim.slide_up_a,R.anim.slide_up_b)
        }

        guide?.setOnClickListener {
            //startActivity(Intent(this,GuideActivity::class.java))
            //overridePendingTransition(R.anim.slide_up_a,R.anim.slide_up_b)
        }

        funActivity?.setOnClickListener {
            startActivity(Intent(this,FunActivity::class.java))
            overridePendingTransition(R.anim.slide_up_a,R.anim.slide_up_b)
        }

    }

    override fun onResume() {
        super.onResume()
        CommonConstantAd.showInterstitialAdsGoogle(this,this);
    }
    override fun adLoadingFailed() {
        
    }

    override fun adClose() {

    }

    override fun startNextScreen() {

    }

    override fun onLoaded() {

    }

}