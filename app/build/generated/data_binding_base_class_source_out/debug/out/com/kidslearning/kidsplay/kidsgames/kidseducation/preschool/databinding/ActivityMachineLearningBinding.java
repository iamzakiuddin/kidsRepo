// Generated by view binder compiler. Do not edit!
package com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMachineLearningBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView back;

  @NonNull
  public final ConstraintLayout bounds;

  @NonNull
  public final ImageView camera;

  @NonNull
  public final ImageView content;

  @NonNull
  public final ImageView gallery;

  @NonNull
  public final Guideline guideline;

  @NonNull
  public final TextView info;

  @NonNull
  public final LinearLayout rltTop;

  private ActivityMachineLearningBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView back, @NonNull ConstraintLayout bounds, @NonNull ImageView camera,
      @NonNull ImageView content, @NonNull ImageView gallery, @NonNull Guideline guideline,
      @NonNull TextView info, @NonNull LinearLayout rltTop) {
    this.rootView = rootView;
    this.back = back;
    this.bounds = bounds;
    this.camera = camera;
    this.content = content;
    this.gallery = gallery;
    this.guideline = guideline;
    this.info = info;
    this.rltTop = rltTop;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMachineLearningBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMachineLearningBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_machine_learning, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMachineLearningBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back;
      ImageView back = ViewBindings.findChildViewById(rootView, id);
      if (back == null) {
        break missingId;
      }

      id = R.id.bounds;
      ConstraintLayout bounds = ViewBindings.findChildViewById(rootView, id);
      if (bounds == null) {
        break missingId;
      }

      id = R.id.camera;
      ImageView camera = ViewBindings.findChildViewById(rootView, id);
      if (camera == null) {
        break missingId;
      }

      id = R.id.content;
      ImageView content = ViewBindings.findChildViewById(rootView, id);
      if (content == null) {
        break missingId;
      }

      id = R.id.gallery;
      ImageView gallery = ViewBindings.findChildViewById(rootView, id);
      if (gallery == null) {
        break missingId;
      }

      id = R.id.guideline;
      Guideline guideline = ViewBindings.findChildViewById(rootView, id);
      if (guideline == null) {
        break missingId;
      }

      id = R.id.info;
      TextView info = ViewBindings.findChildViewById(rootView, id);
      if (info == null) {
        break missingId;
      }

      id = R.id.rltTop;
      LinearLayout rltTop = ViewBindings.findChildViewById(rootView, id);
      if (rltTop == null) {
        break missingId;
      }

      return new ActivityMachineLearningBinding((ConstraintLayout) rootView, back, bounds, camera,
          content, gallery, guideline, info, rltTop);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
