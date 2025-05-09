// Generated by view binder compiler. Do not edit!
package com.example.paranalog.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.paranalog.R;
import com.google.android.material.card.MaterialCardView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ChecklistItemBinding implements ViewBinding {
  @NonNull
  private final MaterialCardView rootView;

  @NonNull
  public final Button buttonViewPdf;

  @NonNull
  public final TextView itemCrtTextView;

  @NonNull
  public final TextView itemDateTimeTextView;

  @NonNull
  public final TextView itemPlateTextView;

  private ChecklistItemBinding(@NonNull MaterialCardView rootView, @NonNull Button buttonViewPdf,
      @NonNull TextView itemCrtTextView, @NonNull TextView itemDateTimeTextView,
      @NonNull TextView itemPlateTextView) {
    this.rootView = rootView;
    this.buttonViewPdf = buttonViewPdf;
    this.itemCrtTextView = itemCrtTextView;
    this.itemDateTimeTextView = itemDateTimeTextView;
    this.itemPlateTextView = itemPlateTextView;
  }

  @Override
  @NonNull
  public MaterialCardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ChecklistItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ChecklistItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.checklist_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ChecklistItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_view_pdf;
      Button buttonViewPdf = ViewBindings.findChildViewById(rootView, id);
      if (buttonViewPdf == null) {
        break missingId;
      }

      id = R.id.item_crt_text_view;
      TextView itemCrtTextView = ViewBindings.findChildViewById(rootView, id);
      if (itemCrtTextView == null) {
        break missingId;
      }

      id = R.id.item_date_time_text_view;
      TextView itemDateTimeTextView = ViewBindings.findChildViewById(rootView, id);
      if (itemDateTimeTextView == null) {
        break missingId;
      }

      id = R.id.item_plate_text_view;
      TextView itemPlateTextView = ViewBindings.findChildViewById(rootView, id);
      if (itemPlateTextView == null) {
        break missingId;
      }

      return new ChecklistItemBinding((MaterialCardView) rootView, buttonViewPdf, itemCrtTextView,
          itemDateTimeTextView, itemPlateTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
