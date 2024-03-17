package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.provider.Settings;

import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.interfaces.CallbackListener;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.utils.Utils;

public class SplashActivity extends AppCompatActivity implements CallbackListener {
    private boolean isComingFromSettings = false;

    /*For Internet*/
    @Override
    public void onSuccess() {

    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onRetry() {
        callApi();
    }


    Context context;
    private ActivityResultLauncher<String> notificationsPermissionLauncher;
    Boolean hasNotificationPermissionGranted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        notificationsPermissionLauncher = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback<Boolean>() {
                    @Override
                    public void onActivityResult(Boolean isGranted) {
                        if (!isGranted) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                if (Build.VERSION.SDK_INT >= 33) {
                                    if (shouldShowRequestPermissionRationale(android.Manifest.permission.POST_NOTIFICATIONS)) {
                                        showNotificationPermissionRationale();
                                    } else {
                                        showSettingDialog();
                                    }
                                }
                            }
                        } else {
                            navigateToMainMenu();
                        }
                    }
                });
                context = this;
        callApi();

    }

    private void showSettingDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Alert")
                .setMessage("Notification permission is required, Please allow notification permission from setting")
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        isComingFromSettings = true;
                        Intent intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        navigateToMainMenu();
                    }
                })
                .show();
    }

    public void callApi() {
        if (Utils.isNetworkConnected(this)) {
            successCall();
        } else {
            Utils.openInternetDialog(this, true,this);
        }
    }

    private void successCall() {
        startNextActivity(2000);
    }

    public void startNextActivity(Integer time) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (notificationsPermissionLauncher!=null){
                    if (Build.VERSION.SDK_INT >= 33) {
                        notificationsPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS);
                    } else {
                        hasNotificationPermissionGranted = true;
                    }
                    if (hasNotificationPermissionGranted){
                        navigateToMainMenu();
                    }
                }
            }
        }, time);
    }

    private void navigateToMainMenu() {
        Intent intent = new Intent(SplashActivity.this, MainMenu.class);
        startActivity(intent);
        finish();
    }

  /*  private boolean ensureNotificationsPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {return true;}
        String permission = android.Manifest.permission.POST_NOTIFICATIONS;
        boolean granted = ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;

        if (granted) return true;

        if (shouldShowRequestPermissionRationale(permission)) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.app_name)
                    .setMessage("Ability to Help app needs permission to send daily notification. If denied, you won't receive these notifications, and the app won't ask again. Thank you for understanding.")
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            notificationsPermissionLauncher.launch(permission);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            navigateToMainMenu();
                        }
                    })
                    .show();
            return false;
        }
        notificationsPermissionLauncher.launch(permission);
        return false;
    }
*/
    private void showNotificationPermissionRationale(){
        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("Ability to Help app needs permission to send daily notification. If denied, you won't receive daily notification. Thank you for understanding.")
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        notificationsPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        navigateToMainMenu();
                    }
                })
                .show();
    }

    private Boolean isLoaded = false;

    private Handler handler = new Handler();
    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            if (Utils.isNetworkConnected(SplashActivity.this)) {
                if (!isLoaded) {
                    startNextActivity(0);
                }
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        if (isComingFromSettings){
            isComingFromSettings = false;
            navigateToMainMenu();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(myRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notificationsPermissionLauncher = null;
        handler.removeCallbacks(myRunnable);
    }
}

