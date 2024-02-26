// Generated by view binder compiler. Do not edit!
package com.apps.abilitytohelp.kidslearning.kidseducation.preschool.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.apps.abilitytohelp.kidslearning.kidseducation.preschool.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CardVideoLearningBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final CardView cVHomeCategories;

  @NonNull
  public final TextView txtCategories;

  private CardVideoLearningBinding(@NonNull CardView rootView, @NonNull CardView cVHomeCategories,
      @NonNull TextView txtCategories) {
    this.rootView = rootView;
    this.cVHomeCategories = cVHomeCategories;
    this.txtCategories = txtCategories;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CardVideoLearningBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardVideoLearningBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_video_learning, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardVideoLearningBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      CardView cVHomeCategories = (CardView) rootView;

      id = R.id.txtCategories;
      TextView txtCategories = ViewBindings.findChildViewById(rootView, id);
      if (txtCategories == null) {
        break missingId;
      }

      return new CardVideoLearningBinding((CardView) rootView, cVHomeCategories, txtCategories);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}