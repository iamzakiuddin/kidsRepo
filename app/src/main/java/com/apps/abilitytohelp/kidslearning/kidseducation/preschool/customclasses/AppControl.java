package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.customclasses;

import android.app.Application;
import android.content.Context;
import android.speech.tts.TextToSpeech;

import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.utils.Utils;

import java.util.Locale;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class AppControl extends Application {
    Context context;
    public static TextToSpeech textToSpeech;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        new Utils(context);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("Fon/OhWhale.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.UK);
//                    textToSpeech.setLanguage(new Locale("tr","TR"));
                }
            }
        });
        textToSpeech.setSpeechRate(0.3f);
    }


}
