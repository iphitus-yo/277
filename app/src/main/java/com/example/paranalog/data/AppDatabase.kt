package com.example.paranalog.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Defines the Room database for the application
// *** Incremented version number from 1 to 2 ***
@Database(entities = [User::class, Vehicle::class, Checklist::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun vehicleDao(): VehicleDao
    abstract fun checklistDao(): ChecklistDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // Return existing instance or build a new one synchronized
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "paranalog_database" // Database file name
                )
                // *** Kept: Destructive migration for development ***
                // This will delete and recreate the database if the schema changes.
                // Remove this in production and implement proper migrations.
                .fallbackToDestructiveMigration()
                // Add migrations here if the schema changes in the future
                // .addMigrations(MIGRATION_1_2)
                .build()
                INSTANCE = instance
                // Return instance
                instance
            }
        }
    }
}

