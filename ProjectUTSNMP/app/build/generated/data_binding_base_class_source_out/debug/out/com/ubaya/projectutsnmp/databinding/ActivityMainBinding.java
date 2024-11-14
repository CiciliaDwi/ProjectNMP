// Generated by view binder compiler. Do not edit!
package com.ubaya.projectutsnmp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ubaya.projectutsnmp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnGame;

  @NonNull
  public final Button btnSchedule;

  @NonNull
  public final Button btnTeam;

  @NonNull
  public final ImageView imageView13;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final ImageView imageView6;

  @NonNull
  public final ConstraintLayout main;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnGame,
      @NonNull Button btnSchedule, @NonNull Button btnTeam, @NonNull ImageView imageView13,
      @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4,
      @NonNull ImageView imageView5, @NonNull ImageView imageView6,
      @NonNull ConstraintLayout main) {
    this.rootView = rootView;
    this.btnGame = btnGame;
    this.btnSchedule = btnSchedule;
    this.btnTeam = btnTeam;
    this.imageView13 = imageView13;
    this.imageView2 = imageView2;
    this.imageView3 = imageView3;
    this.imageView4 = imageView4;
    this.imageView5 = imageView5;
    this.imageView6 = imageView6;
    this.main = main;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnGame;
      Button btnGame = ViewBindings.findChildViewById(rootView, id);
      if (btnGame == null) {
        break missingId;
      }

      id = R.id.btnSchedule;
      Button btnSchedule = ViewBindings.findChildViewById(rootView, id);
      if (btnSchedule == null) {
        break missingId;
      }

      id = R.id.btnTeam;
      Button btnTeam = ViewBindings.findChildViewById(rootView, id);
      if (btnTeam == null) {
        break missingId;
      }

      id = R.id.imageView13;
      ImageView imageView13 = ViewBindings.findChildViewById(rootView, id);
      if (imageView13 == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.imageView5;
      ImageView imageView5 = ViewBindings.findChildViewById(rootView, id);
      if (imageView5 == null) {
        break missingId;
      }

      id = R.id.imageView6;
      ImageView imageView6 = ViewBindings.findChildViewById(rootView, id);
      if (imageView6 == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      return new ActivityMainBinding((ConstraintLayout) rootView, btnGame, btnSchedule, btnTeam,
          imageView13, imageView2, imageView3, imageView4, imageView5, imageView6, main);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
