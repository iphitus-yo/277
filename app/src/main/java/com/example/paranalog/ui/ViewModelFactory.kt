package com.example.paranalog.ui

import android.app.Application
import android.content.Context // Import Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.work.WorkManager
import com.example.paranalog.data.AppDatabase
import com.example.paranalog.data.ChecklistRepository
import com.example.paranalog.data.UserRepository
import com.example.paranalog.ui.auth.LoginViewModel
import com.example.paranalog.ui.auth.RegisterViewModel
import com.example.paranalog.ui.checklist.ChecklistFormViewModel
import com.example.paranalog.ui.checklist.ChecklistListViewModel

// Factory for creating ViewModels with dependencies
// Now requires Context as well
class ViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Get DAOs and Repositories
        val database = AppDatabase.getDatabase(application)
        val userDao = database.userDao()
        val checklistDao = database.checklistDao()
        val userRepository = UserRepository(userDao)
        val checklistRepository = ChecklistRepository(checklistDao)
        val workManager = WorkManager.getInstance(application)
        val context = application.applicationContext // Get context from application

        return when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(userRepository) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(userRepository) as T
            }
            modelClass.isAssignableFrom(ChecklistListViewModel::class.java) -> {
                ChecklistListViewModel(checklistRepository) as T
            }
            modelClass.isAssignableFrom(ChecklistFormViewModel::class.java) -> {
                // Pass context as the fourth argument
                ChecklistFormViewModel(checklistRepository, userRepository, workManager, context) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}

