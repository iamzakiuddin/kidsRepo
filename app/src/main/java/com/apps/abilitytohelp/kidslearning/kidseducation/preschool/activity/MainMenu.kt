package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.customclasses.Constant
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.interfaces.AdsCallback
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.utils.CommonConstantAd
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.utils.Utils

class MainMenu : AppCompatActivity(), AdsCallback {

    var mySchool: Button? = null
    var guide: Button? = null
    var funActivity: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        supportActionBar?.hide()
        if (Utils.getPref(this, Constant.STATUS_ENABLE_DISABLE, "") == Constant.ENABLE) {
            if (Utils.getPref(this, Constant.AD_TYPE_FB_GOOGLE, "") == Constant.AD_GOOGLE) {
                CommonConstantAd.googlebeforloadAd(this)
                Log.e("TAG", "checkAd:Google::::  ")
            }
        }
        mySchool = findViewById(R.id.mySchool)
        guide =  findViewById(R.id.guide)
        funActivity = findViewById(R.id.funactivity)

        mySchool?.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            overridePendingTransition(R.anim.slide_up_a,R.anim.slide_up_b)
        }

        guide?.setOnClickListener {
            startActivity(Intent(this,GuideActivity::class.java))
            overridePendingTransition(R.anim.slide_up_a,R.anim.slide_up_b)
        }

        funActivity?.setOnClickListener {
            startActivity(Intent(this,FunActivity::class.java))
            overridePendingTransition(R.anim.slide_up_a,R.anim.slide_up_b)
        }

    }

    override fun onResume() {
        super.onResume()
        if (Utils.getPref(this, Constant.STATUS_ENABLE_DISABLE, "") == Constant.ENABLE) {
            CommonConstantAd.showInterstitialAdsGoogle(this,this);
            Log.e("TAG", "checkAd:Google::::  ")
        }
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