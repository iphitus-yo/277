package com.example.paranalog.ui.auth

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.paranalog.R

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToChecklistListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_checklistListFragment)

    public fun actionLoginFragmentToRegisterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_registerFragment)
  }
}
