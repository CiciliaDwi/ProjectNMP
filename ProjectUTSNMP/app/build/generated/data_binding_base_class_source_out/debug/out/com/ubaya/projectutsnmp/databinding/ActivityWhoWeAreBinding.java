// Generated by view binder compiler. Do not edit!
package com.ubaya.projectutsnmp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ubaya.projectutsnmp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityWhoWeAreBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnLike;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView imageView11;

  @NonNull
  public final ImageView imageView7;

  @NonNull
  public final ImageView imageView8;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView txtLike;

  private ActivityWhoWeAreBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnLike,
      @NonNull ImageView imageView, @NonNull ImageView imageView11, @NonNull ImageView imageView7,
      @NonNull ImageView imageView8, @NonNull ConstraintLayout main, @NonNull TextView textView,
      @NonNull TextView textView2, @NonNull TextView txtLike) {
    this.rootView = rootView;
    this.btnLike = btnLike;
    this.imageView = imageView;
    this.imageView11 = imageView11;
    this.imageView7 = imageView7;
    this.imageView8 = imageView8;
    this.main = main;
    this.textView = textView;
    this.textView2 = textView2;
    this.txtLike = txtLike;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityWhoWeAreBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityWhoWeAreBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_who_we_are, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityWhoWeAreBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnLike;
      Button btnLike = ViewBindings.findChildViewById(rootView, id);
      if (btnLike == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.imageView11;
      ImageView imageView11 = ViewBindings.findChildViewById(rootView, id);
      if (imageView11 == null) {
        break missingId;
      }

      id = R.id.imageView7;
      ImageView imageView7 = ViewBindings.findChildViewById(rootView, id);
      if (imageView7 == null) {
        break missingId;
      }

      id = R.id.imageView8;
      ImageView imageView8 = ViewBindings.findChildViewById(rootView, id);
      if (imageView8 == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.txtLike;
      TextView txtLike = ViewBindings.findChildViewById(rootView, id);
      if (txtLike == null) {
        break missingId;
      }

      return new ActivityWhoWeAreBinding((ConstraintLayout) rootView, btnLike, imageView,
          imageView11, imageView7, imageView8, main, textView, textView2, txtLike);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
