// Generated by view binder compiler. Do not edit!
package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityHomeBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout backBtn;

  @NonNull
  public final ImageView imgBackButton;

  @NonNull
  public final ImageView imgSoundOff;

  @NonNull
  public final ImageView imgSoundOn;

  @NonNull
  public final RelativeLayout llAdView;

  @NonNull
  public final LinearLayout llAdViewFacebook;

  @NonNull
  public final RecyclerView rvHomeCategories;

  @NonNull
  public final TextView txtExamTitle;

  @NonNull
  public final TextView txtTitleSubHome;

  private ActivityHomeBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout backBtn,
      @NonNull ImageView imgBackButton, @NonNull ImageView imgSoundOff,
      @NonNull ImageView imgSoundOn, @NonNull RelativeLayout llAdView,
      @NonNull LinearLayout llAdViewFacebook, @NonNull RecyclerView rvHomeCategories,
      @NonNull TextView txtExamTitle, @NonNull TextView txtTitleSubHome) {
    this.rootView = rootView;
    this.backBtn = backBtn;
    this.imgBackButton = imgBackButton;
    this.imgSoundOff = imgSoundOff;
    this.imgSoundOn = imgSoundOn;
    this.llAdView = llAdView;
    this.llAdViewFacebook = llAdViewFacebook;
    this.rvHomeCategories = rvHomeCategories;
    this.txtExamTitle = txtExamTitle;
    this.txtTitleSubHome = txtTitleSubHome;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backBtn;
      LinearLayout backBtn = ViewBindings.findChildViewById(rootView, id);
      if (backBtn == null) {
        break missingId;
      }

      id = R.id.imgBackButton;
      ImageView imgBackButton = ViewBindings.findChildViewById(rootView, id);
      if (imgBackButton == null) {
        break missingId;
      }

      id = R.id.imgSoundOff;
      ImageView imgSoundOff = ViewBindings.findChildViewById(rootView, id);
      if (imgSoundOff == null) {
        break missingId;
      }

      id = R.id.imgSoundOn;
      ImageView imgSoundOn = ViewBindings.findChildViewById(rootView, id);
      if (imgSoundOn == null) {
        break missingId;
      }

      id = R.id.llAdView;
      RelativeLayout llAdView = ViewBindings.findChildViewById(rootView, id);
      if (llAdView == null) {
        break missingId;
      }

      id = R.id.llAdViewFacebook;
      LinearLayout llAdViewFacebook = ViewBindings.findChildViewById(rootView, id);
      if (llAdViewFacebook == null) {
        break missingId;
      }

      id = R.id.rvHomeCategories;
      RecyclerView rvHomeCategories = ViewBindings.findChildViewById(rootView, id);
      if (rvHomeCategories == null) {
        break missingId;
      }

      id = R.id.txtExamTitle;
      TextView txtExamTitle = ViewBindings.findChildViewById(rootView, id);
      if (txtExamTitle == null) {
        break missingId;
      }

      id = R.id.txtTitleSubHome;
      TextView txtTitleSubHome = ViewBindings.findChildViewById(rootView, id);
      if (txtTitleSubHome == null) {
        break missingId;
      }

      return new ActivityHomeBinding((LinearLayout) rootView, backBtn, imgBackButton, imgSoundOff,
          imgSoundOn, llAdView, llAdViewFacebook, rvHomeCategories, txtExamTitle, txtTitleSubHome);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
