// Generated by view binder compiler. Do not edit!
package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySurfingBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView back;

  @NonNull
  public final WebView explorer;

  @NonNull
  public final ConstraintLayout headerLayout;

  private ActivitySurfingBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView back,
      @NonNull WebView explorer, @NonNull ConstraintLayout headerLayout) {
    this.rootView = rootView;
    this.back = back;
    this.explorer = explorer;
    this.headerLayout = headerLayout;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySurfingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySurfingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_surfing, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySurfingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.back;
      ImageView back = ViewBindings.findChildViewById(rootView, id);
      if (back == null) {
        break missingId;
      }

      id = R.id.explorer;
      WebView explorer = ViewBindings.findChildViewById(rootView, id);
      if (explorer == null) {
        break missingId;
      }

      id = R.id.headerLayout;
      ConstraintLayout headerLayout = ViewBindings.findChildViewById(rootView, id);
      if (headerLayout == null) {
        break missingId;
      }

      return new ActivitySurfingBinding((ConstraintLayout) rootView, back, explorer, headerLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
