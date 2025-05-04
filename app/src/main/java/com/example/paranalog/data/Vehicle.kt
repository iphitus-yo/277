package com.example.paranalog.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// Represents the Vehicle entity in the database
@Entity(tableName = "vehicles")
data class Vehicle(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val plate: String, // Vehicle plate (e.g., Cavalo or Carreta)
    val description: String? // Optional description (e.g., "Volvo FH 540", "Carreta Baú")
)

