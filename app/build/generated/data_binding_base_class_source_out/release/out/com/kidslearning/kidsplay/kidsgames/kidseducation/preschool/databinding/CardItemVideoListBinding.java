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
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kidslearning.kidsplay.kidsgames.kidseducation.preschool.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CardItemVideoListBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView cardViewMain;

  @NonNull
  public final ImageView ivThumbnailView;

  @NonNull
  public final LinearLayout lloutForCardMain;

  @NonNull
  public final TextView txtVideoDescription;

  private CardItemVideoListBinding(@NonNull CardView rootView, @NonNull CardView cardViewMain,
      @NonNull ImageView ivThumbnailView, @NonNull LinearLayout lloutForCardMain,
      @NonNull TextView txtVideoDescription) {
    this.rootView = rootView;
    this.cardViewMain = cardViewMain;
    this.ivThumbnailView = ivThumbnailView;
    this.lloutForCardMain = lloutForCardMain;
    this.txtVideoDescription = txtVideoDescription;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CardItemVideoListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardItemVideoListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_item_video_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardItemVideoListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CardView cardViewMain = (CardView) rootView;

      id = R.id.ivThumbnailView;
      ImageView ivThumbnailView = ViewBindings.findChildViewById(rootView, id);
      if (ivThumbnailView == null) {
        break missingId;
      }

      id = R.id.lloutForCardMain;
      LinearLayout lloutForCardMain = ViewBindings.findChildViewById(rootView, id);
      if (lloutForCardMain == null) {
        break missingId;
      }

      id = R.id.txtVideoDescription;
      TextView txtVideoDescription = ViewBindings.findChildViewById(rootView, id);
      if (txtVideoDescription == null) {
        break missingId;
      }

      return new CardItemVideoListBinding((CardView) rootView, cardViewMain, ivThumbnailView,
          lloutForCardMain, txtVideoDescription);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
