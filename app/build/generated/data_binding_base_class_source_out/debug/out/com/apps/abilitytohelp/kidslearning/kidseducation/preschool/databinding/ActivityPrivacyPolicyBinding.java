// Generated by view binder compiler. Do not edit!
package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPrivacyPolicyBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView imgBackButton;

  @NonNull
  public final RelativeLayout rltTop;

  @NonNull
  public final TextView txtTitleSubHome;

  @NonNull
  public final WebView webView;

  private ActivityPrivacyPolicyBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView imgBackButton, @NonNull RelativeLayout rltTop,
      @NonNull TextView txtTitleSubHome, @NonNull WebView webView) {
    this.rootView = rootView;
    this.imgBackButton = imgBackButton;
    this.rltTop = rltTop;
    this.txtTitleSubHome = txtTitleSubHome;
    this.webView = webView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPrivacyPolicyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPrivacyPolicyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_privacy_policy, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPrivacyPolicyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imgBackButton;
      ImageView imgBackButton = ViewBindings.findChildViewById(rootView, id);
      if (imgBackButton == null) {
        break missingId;
      }

      id = R.id.rltTop;
      RelativeLayout rltTop = ViewBindings.findChildViewById(rootView, id);
      if (rltTop == null) {
        break missingId;
      }

      id = R.id.txtTitleSubHome;
      TextView txtTitleSubHome = ViewBindings.findChildViewById(rootView, id);
      if (txtTitleSubHome == null) {
        break missingId;
      }

      id = R.id.webView;
      WebView webView = ViewBindings.findChildViewById(rootView, id);
      if (webView == null) {
        break missingId;
      }

      return new ActivityPrivacyPolicyBinding((RelativeLayout) rootView, imgBackButton, rltTop,
          txtTitleSubHome, webView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}