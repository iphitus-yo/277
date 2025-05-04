package com.example.paranalog.ui.checklist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.paranalog.data.Checklist
import com.example.paranalog.data.ChecklistRepository

class ChecklistListViewModel(private val repository: ChecklistRepository) : ViewModel() {

    // Corrected: Observe the Flow property from the repository and convert it to LiveData
    val checklists: LiveData<List<Checklist>> = repository.allChecklists.asLiveData()

    // If you need to perform actions like deleting, add methods here
    // fun deleteChecklist(checklist: Checklist) = viewModelScope.launch {
    //     repository.deleteChecklist(checklist)
    // }
}

