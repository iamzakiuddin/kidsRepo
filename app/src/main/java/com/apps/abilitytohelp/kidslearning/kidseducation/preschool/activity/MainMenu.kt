package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.activity

import android.Manifest
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.broadcastmanagers.DailyBroadcast
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.interfaces.AdsCallback
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.utils.CommonConstantAd
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.utils.Utils
import java.util.Calendar

class MainMenu : AppCompatActivity(), AdsCallback {

    var mySchool: Button? = null
    var myGrammar: Button? = null
    var funActivity: Button? = null
    var llAdView: RelativeLayout? = null
    var llAdViewFacebook: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        supportActionBar?.hide()
        mySchool = findViewById(R.id.mySchool)
        myGrammar = findViewById(R.id.my_grammar)
        funActivity = findViewById(R.id.funactivity)
        llAdView = findViewById(R.id.llAdView)
        llAdViewFacebook = findViewById(R.id.llAdViewFacebook)
        createNotificationChannel()
        setupDailyNotificationReminder()
        CommonConstantAd.googlebeforloadAd(this)
        Utils.loadBannerAd(this, llAdView, llAdViewFacebook)

        mySchool?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            overridePendingTransition(R.anim.slide_up_a, R.anim.slide_up_b)
        }

        myGrammar?.setOnClickListener {
            startActivity(Intent(this, MyGrammarActivity::class.java))
            overridePendingTransition(R.anim.slide_up_a, R.anim.slide_up_b)
        }
        funActivity?.setOnClickListener {
            startActivity(Intent(this, FunActivity::class.java))
            overridePendingTransition(R.anim.slide_up_a, R.anim.slide_up_b)
        }

    }

    private fun setupDailyNotificationReminder() {

        val intent = Intent(this@MainMenu, DailyBroadcast::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this@MainMenu,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val calendar: Calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 9)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        if (calendar.timeInMillis <= System.currentTimeMillis()) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                alarmManager.setRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    AlarmManager.INTERVAL_DAY,
                    pendingIntent
                )
            }
        } else {
            alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                AlarmManager.INTERVAL_DAY,
                pendingIntent
            )
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            val name = "DailyMessageChannel"
            val description = "Channel for Daily Message"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("dailymessage", name, importance)
            channel.description = description

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    override fun onResume() {
        super.onResume()
        CommonConstantAd.showInterstitialAdsGoogle(this, this);
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