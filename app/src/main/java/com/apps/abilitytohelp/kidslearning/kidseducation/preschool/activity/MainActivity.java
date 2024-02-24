package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.activity;

import android.content.Context;
import android.content.Intent;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;



import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.activity.video.VideoLearningActivity;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.adapter.HomeAdapter;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.customclasses.Constant;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.database.DatabaseHelper;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.interfaces.CallbackListener;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.utils.Utils;

public class MainActivity extends AppCompatActivity implements CallbackListener {

    Context context;
    DatabaseHelper databaseHelper;
    RelativeLayout llAdView;
    LinearLayout llAdViewFacebook;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        context=this;
        initDefine();
        databaseHelper = new DatabaseHelper(context);
        try {
            databaseHelper.createDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        successCall();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        llAdView = findViewById(R.id.llAdView);
        llAdViewFacebook = findViewById(R.id.llAdViewFacebook);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    private void successCall() {
        if (Utils.isNetworkConnected(this)) {
            if (Constant.ENABLE_DISABLE.equals(Constant.ENABLE)) {

                Utils.setPref(MainActivity.this, Constant.STATUS_ENABLE_DISABLE, Constant.ENABLE_DISABLE);


            } else {
                Utils.setPref(MainActivity.this, Constant.STATUS_ENABLE_DISABLE, Constant.ENABLE_DISABLE);
            }
        } else {
            Utils.openInternetDialog(this, true,this);
        }
    }

    public int[] arrOfCategory;
    public int[] categoriesTitle;
    private void initDefine() {
        back = findViewById(R.id.back);
        rvCategory=findViewById(R.id.rvCategory);
        arrOfCategory = new int[]{R.drawable.card_one, R.drawable.card_two, R.drawable.card_three, R.drawable.card_four};
        categoriesTitle = new int[]{R.string.kids_learning, R.string.video_learning, R.string.look_and_choose, R.string.listen_and_guess};
        setRvAdapter();
    }


    public void onClickSetting(View view){
        Intent intent= new Intent(MainActivity.this,SettingActivity.class);
        startActivityForResult(intent,111);
    }

    HomeAdapter homeAdapter;
    RecyclerView rvCategory;
    int position = 0;
    private void setRvAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        //LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        rvCategory.setLayoutManager(gridLayoutManager);
        homeAdapter=new HomeAdapter(context, arrOfCategory,categoriesTitle, new HomeAdapter.onClickMain() {
            @Override
            public void onClickCategory(int pos) {
                position = pos;
                if (Utils.getPref(MainActivity.this, Constant.CLICK_IMAGE_COUNT, 1) == 1) {
                    Utils.setPref(MainActivity.this, Constant.CLICK_IMAGE_COUNT, 2);
                    startNextActivity();
                }else{
                    startNextActivity();
                }

            }
        });
        rvCategory.setAdapter(homeAdapter);
    }


    public void startNextActivity(){
        switch (position) {
            case 0:
                Intent intent1 = new Intent(context, HomeActivity.class);
                intent1.putExtra("Type", 1);
                context.startActivity(intent1);
                overridePendingTransition(R.anim.enter_anim,R.anim.exit);
                break;
            case 1:
                Intent intent2 = new Intent(context, VideoLearningActivity.class);
                context.startActivity(intent2);
                overridePendingTransition(R.anim.enter_anim,R.anim.exit);
                break;
            case 2:
                Intent intent3 = new Intent(context, HomeActivity.class);
                intent3.putExtra("Type", 2);
                context.startActivity(intent3);
                overridePendingTransition(R.anim.enter_anim,R.anim.exit);
                break;
            case 3:
                Intent intent4 = new Intent(context, HomeActivity.class);
                intent4.putExtra("Type", 3);
                context.startActivity(intent4);
                overridePendingTransition(R.anim.enter_anim,R.anim.exit);
                break;
        }
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onRetry() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_down_a,R.anim.slide_down_b);
    }
}
