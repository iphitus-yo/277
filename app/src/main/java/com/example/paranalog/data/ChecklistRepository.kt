package com.example.paranalog.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class ChecklistRepository(private val checklistDao: ChecklistDao) {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allChecklists: Flow<List<Checklist>> = checklistDao.getAllChecklists()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertChecklist(checklist: Checklist): Long {
        // Corrected: Use the existing insertOrUpdate method which returns Long
        return checklistDao.insertOrUpdate(checklist)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateChecklist(checklist: Checklist) {
        checklistDao.update(checklist)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteChecklist(checklist: Checklist) {
        checklistDao.delete(checklist)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getChecklistById(id: Long): Checklist? {
        return checklistDao.getChecklistById(id)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getChecklistsByStatus(status: String): List<Checklist> {
        return checklistDao.getChecklistsByStatus(status)
    }

    // Corrected: Call the actual DAO method name 'updateStatus'
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateStatus(id: Long, newStatus: String) {
        checklistDao.updateStatus(id, newStatus)
    }

    // Corrected: Call the actual DAO method name 'updatePdfPath'
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updatePdfPath(id: Long, pdfPath: String?) {
        checklistDao.updatePdfPath(id, pdfPath)
    }
}

