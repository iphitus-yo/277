package com.example.paranalog.ui.checklist

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.paranalog.R

public class ChecklistListFragmentDirections private constructor() {
  public companion object {
    public fun actionChecklistListFragmentToChecklistFormFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_checklistListFragment_to_checklistFormFragment)
  }
}
