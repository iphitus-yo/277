// Generated by view binder compiler. Do not edit!
package com.example.paranalog.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.paranalog.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final TextInputEditText cpfEditText;

  @NonNull
  public final TextInputLayout cpfLayout;

  @NonNull
  public final ProgressBar loadingProgressBar;

  @NonNull
  public final MaterialButton loginButton;

  @NonNull
  public final TextView loginTitle;

  @NonNull
  public final ImageView logoImageView;

  @NonNull
  public final TextInputEditText passwordEditText;

  @NonNull
  public final TextInputLayout passwordLayout;

  @NonNull
  public final TextView registerLinkText;

  private FragmentLoginBinding(@NonNull ScrollView rootView, @NonNull TextInputEditText cpfEditText,
      @NonNull TextInputLayout cpfLayout, @NonNull ProgressBar loadingProgressBar,
      @NonNull MaterialButton loginButton, @NonNull TextView loginTitle,
      @NonNull ImageView logoImageView, @NonNull TextInputEditText passwordEditText,
      @NonNull TextInputLayout passwordLayout, @NonNull TextView registerLinkText) {
    this.rootView = rootView;
    this.cpfEditText = cpfEditText;
    this.cpfLayout = cpfLayout;
    this.loadingProgressBar = loadingProgressBar;
    this.loginButton = loginButton;
    this.loginTitle = loginTitle;
    this.logoImageView = logoImageView;
    this.passwordEditText = passwordEditText;
    this.passwordLayout = passwordLayout;
    this.registerLinkText = registerLinkText;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cpf_edit_text;
      TextInputEditText cpfEditText = ViewBindings.findChildViewById(rootView, id);
      if (cpfEditText == null) {
        break missingId;
      }

      id = R.id.cpf_layout;
      TextInputLayout cpfLayout = ViewBindings.findChildViewById(rootView, id);
      if (cpfLayout == null) {
        break missingId;
      }

      id = R.id.loading_progress_bar;
      ProgressBar loadingProgressBar = ViewBindings.findChildViewById(rootView, id);
      if (loadingProgressBar == null) {
        break missingId;
      }

      id = R.id.login_button;
      MaterialButton loginButton = ViewBindings.findChildViewById(rootView, id);
      if (loginButton == null) {
        break missingId;
      }

      id = R.id.login_title;
      TextView loginTitle = ViewBindings.findChildViewById(rootView, id);
      if (loginTitle == null) {
        break missingId;
      }

      id = R.id.logo_image_view;
      ImageView logoImageView = ViewBindings.findChildViewById(rootView, id);
      if (logoImageView == null) {
        break missingId;
      }

      id = R.id.password_edit_text;
      TextInputEditText passwordEditText = ViewBindings.findChildViewById(rootView, id);
      if (passwordEditText == null) {
        break missingId;
      }

      id = R.id.password_layout;
      TextInputLayout passwordLayout = ViewBindings.findChildViewById(rootView, id);
      if (passwordLayout == null) {
        break missingId;
      }

      id = R.id.register_link_text;
      TextView registerLinkText = ViewBindings.findChildViewById(rootView, id);
      if (registerLinkText == null) {
        break missingId;
      }

      return new FragmentLoginBinding((ScrollView) rootView, cpfEditText, cpfLayout,
          loadingProgressBar, loginButton, loginTitle, logoImageView, passwordEditText,
          passwordLayout, registerLinkText);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
