package com.example.paranalog.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

// Represents the User entity in the database
// CPF is unique to prevent duplicate registrations
@Entity(tableName = "users", indices = [Index(value = ["cpf"], unique = true)])
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val cpf: String, // Store CPF (ensure validation before saving)
    val passwordHash: String, // Store a hashed version of the password, NEVER plain text
    val defaultPlateCavalo: String?, // Default truck plate associated with the user
    val defaultPlateCarreta: String? // Default trailer plate associated with the user
)

