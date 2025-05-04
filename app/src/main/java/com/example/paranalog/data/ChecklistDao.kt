package com.example.paranalog.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ChecklistDao {

    // Use @Insert with REPLACE strategy for saving new or updating existing
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(checklist: Checklist): Long // Returns the inserted/updated row ID

    // Add a specific @Update method for updating existing checklists
    @Update
    suspend fun update(checklist: Checklist)

    @Query("SELECT * FROM checklists WHERE id = :id")
    suspend fun getChecklistById(id: Long): Checklist?

    @Query("SELECT * FROM checklists ORDER BY timestamp DESC")
    fun getAllChecklists(): Flow<List<Checklist>>

    @Query("SELECT * FROM checklists WHERE status = :status ORDER BY timestamp DESC")
    suspend fun getChecklistsByStatus(status: String): List<Checklist>

    // Specific update for status used by workers
    @Query("UPDATE checklists SET status = :newStatus WHERE id = :id")
    suspend fun updateStatus(id: Long, newStatus: String)

    // Specific update for pdfPath used by NativePdfGenerationWorker
    // (Although the general 'update' method in the worker could also handle this)
    @Query("UPDATE checklists SET pdfPath = :pdfPath WHERE id = :id")
    suspend fun updatePdfPath(id: Long, pdfPath: String?)

    @Delete
    suspend fun delete(checklist: Checklist)
}

