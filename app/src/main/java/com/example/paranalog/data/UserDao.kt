package com.example.paranalog.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT) // Prevent inserting user with existing CPF due to index
    suspend fun insert(user: User)

    @Query("SELECT * FROM users WHERE cpf = :cpf LIMIT 1")
    suspend fun getUserByCpf(cpf: String): User?

    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    suspend fun getUserById(id: Long): User?

    // Add other queries if needed, e.g., update user info
}

